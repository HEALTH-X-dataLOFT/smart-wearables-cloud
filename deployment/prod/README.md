# Kubernetes Deployment (PROD)

## Preparatory Steps

1. Follow the steps mentioned in `../base/README.md`. 
 
   _(append  `--kubeconfig [KUBECONFIG_FILE]` to the commands for remote deployment)._


2. Create Kubernetes secret for the Smart Wearables Docker registry:
   ```
   kubectl create secret docker-registry smartwearables-container-registry --docker-username=[DOCKER_USERNAME] --docker-password=[DOCKER_PW] --docker-server=[DOCKER_SERVER] -n smartwearables
   ```
   
4. Ensure that the Docker image for the SWC app is available in the container registry used by Kubernetes
   (see `data-boot/deployment`)

## Apply Kubernetes kustomization file

```
kubectl apply -k .
```