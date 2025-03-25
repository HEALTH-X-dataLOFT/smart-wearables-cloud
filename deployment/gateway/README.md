# NGNX Gateway deployment: Manual vs. GitLab CI/CD

Two different methods of deployment are available: First using the GitLab's CI/CD capabilities and second performing the according steps manually. Please refer to the  section below for detailed instructions corresponding to the chosen method.

## Deployment using GitLab CI/CD

Using the CI/CD-Pipeline a manifest file is created through which the various secrets can be applied in the cluster. The secrets are made available as CI/CD-variables in the GitLab project (see below for details). Please note that in the same manifest file the various secrets described in `../base/README.md` are present. Ideally the corresponding CI/CD-variables are also set before you run the pipeline.

**Note:** _Append `--kubeconfig [KUBECONFIG_FILE]` to each command for remote clusters._ 

### Setup Gateway API (if needed)

1. Install Gateway API CRDs
   ```
   kubectl apply -f https://github.com/kubernetes-sigs/gateway-api/releases/download/v1.0.0/standard-install.yaml
   ```

2. Deploy NGINX Gateway Fabric CRDs
   ```
   kubectl apply -f https://github.com/nginxinc/nginx-gateway-fabric/releases/download/v1.1.0/crds.yaml
   ```
   
3. Deploy NGINX Gateway Fabric
   ```
   kubectl apply -f https://github.com/nginxinc/nginx-gateway-fabric/releases/download/v1.1.0/nginx-gateway.yaml
   ```

### Create gateway and service

1. *Optional:* If an existing tls-certificate is available create the following two CI/CD Variables
   (If there is **no** certificate available see section "Automatic TLS configuration" below)

   *TLS_CERT_BASE64* - the server's vertificate, must be base64-encoded in a single line

   *TLS_PRIVKEY_BASE64* - the server's private key, must be base64-encoded in a single line 

   
   **Note:** For security reasons the secret variables described above must be defined as masked and hidden. Therefore, in order to change keys according variables have to be deleted and newly defined via the project settings section in the GitLab web UI or the GitLab api.
   Due to limitations in GitLab's masking algorithm values of masked variables (i.e. actual secrets) must to be base64 encoded in a single line using 'base64 -w 0'
   
   From these variables a kubernetes manifest for a cluster secret is created as part of the CI/CD-pipeline run. It is appended to the secret manifest file as created in directory */deployment/base*. In order to apply the manifest download the pipeline artifact *secrets_manifest* to your working directory and apply using the following command:
   ```
   kubectl apply -f secrets.yaml
   ```
   
   **Note:** The cluster secret manifest for gateway and service is created whenever variables *TLS_CERT_BASE64* and *TLS_PRIVKEY_BASE64* exist as CI/CD-Variables in GitLab. If automatic TLS configuration is to be used: make sure these variables do not exist from a prior deployment.
   

2. Create the gateway
   ```
   kubectl apply -f gateway.yaml
   ```

3. Expose the gateway via a loadbalancer service
   ```
   kubectl apply -f loadbalancer_service.yaml
   ```

   ***Note that the gateway loadbalancer service should be kept running to prevent the associated IP address from being changed!***

### Automatic TLS configuration

1. Ensure that the Gateway API CRDs are properly installed on the cluser 
    
   If they're not present during `cert-mananger` initialization, `cert-mananger` won't work properly and will require a restart.


2. Install [cert-manager](https://cert-manager.io/docs/installation/kubectl/) CRDs and create a Let's Encrypt Issuer
   ```
   kubectl apply -k ./tls
   ```
   
   This will install the cert-manager CRDs and create an Issuer resource which will leverage the Gateway's
   `cert-manager.io/issuer` annotation to automatically issue a Let's Encrypt certificate and put it into the TLS secret
   specified by the Gateway's TLS route (`smartwearables-tls` at the time of writing). Moreover, the certificate will be 
   automatically renewed 14 days before it expires.


## Deployment using manual creation of k8s-secret 

_Append `--kubeconfig [KUBECONFIG_FILE]` to each command for remote clusters._ 

### Setup Gateway API (if needed)

1. Install Gateway API CRDs
   ```
   kubectl apply -f https://github.com/kubernetes-sigs/gateway-api/releases/download/v1.1.0/standard-install.yaml
   ```

2. Deploy NGINX Gateway API resources
   ```
   kubectl kustomize "https://github.com/nginxinc/nginx-gateway-fabric/config/crd/gateway-api/standard?ref=v1.4.0" | kubectl apply -f -
   ```
   
3. Deploy NGINX Gateway Fabric
   ```
   kubectl apply -f https://raw.githubusercontent.com/nginxinc/nginx-gateway-fabric/v1.4.0/deploy/crds.yaml
   ```

### Create gateway and service

1. _(Optional)_ Create a Kubernetes secret holding the server's certificate and private key data (if existing certificate is available, otherwise see "Automatic TLS configuration"):
   ```
   kubectl create secret tls smartwearables-tls --cert=[PATH_TO_PEM_FILE] --key=[PATH_TO_KEYFILE] -n smartwearables
   ```

2. Create the gateway
   ```
   kubectl apply -f gateway.yaml
   ```

3. Expose the gateway via a loadbalancer service
   ```
   kubectl apply -f loadbalancer_service.yaml
   ```

   ***Note that the gateway loadbalancer service should be kept running to prevent the associated IP address from being changed!***

### Automatic TLS configuration

1. Ensure that the Gateway API CRDs are properly installed on the cluster 
    
   If they're not present during `cert-mananger` initialization, `cert-mananger` won't work properly and will require a restart.

2. Create a secret that stores the ACME account private key
   ```
   kubectl create secret generic issuer-account-key --from-literal=tls.key= -n smartwearables
   ```

3. Install [cert-manager](https://cert-manager.io/docs/installation/kubectl/) CRDs and create a Let's Encrypt Issuer
   ```
   kubectl apply -k ./tls
   ```
   
   This will install the cert-manager CRDs and create an Issuer resource which will leverage the Gateway's
   `cert-manager.io/issuer` annotation to automatically issue a Let's Encrypt certificate and put it into the TLS secret
   specified by the Gateway's TLS route (`smartwearables-tls` at the time of writing). Moreover, the certificate will be 
   automatically renewed 14 days before it expires.