# Kubernetes Deployment (PROD)

## Preparatory Steps

1. Follow the steps mentioned in `../base/README.md`. 
 
   _(append  `--kubeconfig [KUBECONFIG_FILE]` to the commands for remote deployment)._

2. Adjust the variables in `base/data_app.yaml`, 'prod/kustomization.yaml' and other resource files as well as the config properties in the Spring `application.yaml` and `application-prod.yaml` according to your needs.
   
3. Ensure that the Docker image for the SWC app is available in the container registry used by Kubernetes
   (see `data-boot/deployment`)

## Apply Kubernetes kustomization file

```
kubectl apply -k .
```