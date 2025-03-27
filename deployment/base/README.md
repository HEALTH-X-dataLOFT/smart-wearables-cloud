# Kubernetes Deployment (LOCAL)

_Append `--kubeconfig [KUBECONFIG_FILE]` to each command for remote clusters._

## Preparatory Steps

### Deploy the NGINX-Gateway
Deploy the Gateway by following the instructions given in `../gateway/README.md`.

### Create Kubernetes namespace

Create smartwearables namespace:
   ```
   kubectl create namespace smartwearables
   ```

## Deployment: Manual vs. GitLab CI/CD

For the next sextion Two different methods of deployment are available: First using the GitLab's CI/CD capabilities and second performing the according steps manually. Please refer to the  section below for detailed instructions corresponding to the chosen method.

### Deployment using GitLab CI/CD

#### Store required secret values in CI/CD variables


The secrets that need to exist in the cluster for the deployment are stored in the GitLab project as (masked and hidden) CI/CD variables and are available throughout the CI/CD pipeline runs. 
The following secrets have to be set for deployments of this directory. 

**Note:** For security reasons the secret variables described below must be defined as masked and hidden. Therefore, in order to change keys according variables have to be deleted and newly defined via the project settings section in the GitLab web UI or the GitLab api.
Due to limitations in GitLab's masking algorithm values of masked variables (i.e. actual secrets) must to be base64 encoded.

| Secret                                | Description                                                                                              |
|---------------------------------------|----------------------------------------------------------------------------------------------------------|
| **MYSQL-DB**                          |                                                                                                          |
| _MYSQL_PW_BASE64_                     | Password for MySQL DB - input value must be base64-encoded                                               |
| **Key for cluster encryption**        |                                                                                                          |
| _AESKEY_BASE64_                       | AES encryption key - input value must be base64-encoded                                                  |
| **Connection to Garmin API**          |                                                                                                          |
| _GARMIN_APIKEY_BASE64_                | Garmin consumer API key - input value must be base64-encoded                                             |
| _GARMIN_APIPW_BASE64_                 | Garmin consumer API password - input value must be base64-encoded                                        |
| **EDC connector secret**              |                                                                                                          |
| _EDC_APIKEY_BASE64_                   | EDC API-key - input value must be base64-encoded                                                         |
| **Admin user for Keycloak**           |                                                                                                          |
| _KEYCLOAK_ADMIN_USER_BASE64_          | Keycloak Admin-User name - input value must be base64-encoded                                            |
| _KEYCLOAK_ADMIN_PW_BASE64_            | Keycloak Admin password - input value must be base64-encoded                                             |
| _KEYCLOAK_ADMIN_CLIENT_SECRET_BASE64_ | Keycloak Admin client secret - input value must be base64-encoded                                        |
| **Additional non-secret variables**   | **Note:** As the following variables are not secrets they don't need to be defined as masked and hidden. |
| _SECRETS_NAMESPACE_                   | Namespace in k8s cluster, where secrets are created (not a secret - input **not** base64-encoded)        |
| _DOCKER_SERVER_                       | URL of container registry  (not a secret - input **\*\*not\*\*** base64-encoded)                         |

**Make sure to define Variables not protected - otherwise they are not available on development branches!** (May be default.)


#### Create Kubernetes manifest file for secrets

The manifest file through which above secrets can be created is build by running the CI/CD-Pipeline. The pipeline job `build-secret-manifests` uses template files present in the directory `deployment/base` to build an artefact that can be downloaded from the corresponding Pipeline window in the GitLab web UI.
The artifacts name is: `secrets_manifest_files`
As this artifact contains the secrets it's set to **expire within 5 minutes**, after which the artifact will be deleted.

Apply the downloaded secrets manifest file using the following command:

```
kubectl apply -f secrets.yaml
```

## Deployment using manual creation of k8s-secret

1. Create Kubernetes secret for MySQL password:
   ```
   kubectl create secret generic mysql-credentials --from-literal=mysql-password=[DB_PASSWORD] -n smartwearables
   ```
   
2. Create Kubernetes secret for AES encryption key:
   ```
   kubectl create secret generic swc-encryption --from-literal=aes-key=[AES_KEY] -n smartwearables
   ```   

3. Create Kubernetes secret for Garmin API consumer credentials:
   ```
   kubectl create secret generic swc-garmin-api-credentials --from-literal=consumer-key=[CONSUMER_KEY] --from-literal=consumer-secret=[CONSUMER_SECRET] -n smartwearables
   ```
   
4. Create Kubernetes secret for EDC API key:
   ```
   kubectl create secret generic swc-edc-api --from-literal=api-key=[API_KEY] -n smartwearables
   ```
   
5. Create Kubernetes secret for Keycloak admin user:
   ```
   kubectl create secret generic keycloak-admin-credentials --from-literal=username=[ADMIN_USERNAME] --from-literal=password=[ADMIN_PASSWORD] --from-literal=client-secret=[CLIENT_SECRET] -n smartwearables
   ```
   
6. Ensure that the Docker image for the application is available in the container registry used by Kubernetes
   (see `data-boot/deployment`, `auth/deployment` and `login/deployment`)

   
7. Create Kubernetes secret for the container registry:
   ```
   kubectl create secret docker-registry smartwearables-container-registry --docker-username=[DOCKER_USERNAME] --docker-password=[DOCKER_PW] --docker-server=[DOCKER_SERVER] -n smartwearables
   ```

9. Create secret for signing VCs
    ```
    kubectl create secret generic swc-vc-sign-key --from-literal=private.key=[PRIVATE_KEY] --from-literal=public.key=[PUBLIC_KEY] -n smartwearables
    ```

10. Create secret for JWE decryption
    ```
    kubectl create secret generic jwe-auth-private-key-file --from-file=private.key=[PATH_TO_JWK_FILE] -n smartwearables
    ```
    
11. Create secret for Thryve credentials
    ```
    kubectl create secret generic thryve-credentials --from-literal=username=[USERNAME] --from-literal=password=[PASSWORD] --from-literal=app-id=[APP_ID] --from-literal=app-secret=[APP_SECRET] --from-literal=auth-redirect-uri=[AUTH_REDIRECT_URI] -n smartwearables
    ```

## Continue with the appropriate environment instructions

You have now a basic setup which serves as a basis for the actual deployment scripts given in the directories `/local`, `prod` and `prod-restricted`.
Choose the one fitting your needs and follow the instructions in the provided `README.md` file.