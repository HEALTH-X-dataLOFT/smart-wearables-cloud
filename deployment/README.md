# Smart Werables Cloud Deployment

This folder is made up of five subfolders which may be used to deploy the Smart Wearable Cloud on a Kubernetes Cluster.

These serve the following purposes:

| Folder          | Description                                                                                                                                                                                                                                                           |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| base            | Basic deployment and configuration of the SWC components which assumes that the underyling images are available in the local container registry. It serves as basis for `local`, `prod` and `prod-restricted` and is not intended to be used directly.                |
| gateway         | Contains Gateway and LoadBalancer Service resources for exposing the SWC services to the internet. <br/>This folder contains a `tls` folder which contains a kustomization that may be used for enabling automatic TLS configuration and renewal using Let's Encrypt. |
| local           | Contains a kustomization which adds HTTP routes to the base deployment, adjusts the application's base URL and IP and sets the `imagePullPolicy` to `Never` for local deployment.                                                                                     |
| prod            | Contains a kustomization for the IONOS deployment. Specifically, it configures the IONOS image registry as well as a `ionos-enterprise-hdd` PVC for the MySQL database.                                                                                               |
| prod-restricted | Similar to `prod` but doesn't expose the app publicly so that it is reachable only from within the cluster.                                                                                                                                                           |

