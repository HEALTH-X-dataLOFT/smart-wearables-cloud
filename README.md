![](./docs/images/smart_wearables_cloud_logo_3000px.png)

# Smart Wearables Cloud

The Smart Wearables Cloud is an example data provider for the Health-X dataLOFT data space.

## Use Case 
The Smart Wearables Cloud (SWC) enables users to connect their wearable accounts and publish the associated data to the Health-X dataLOFT data space, where it can be shared with other data space participants.

Being an example data provider service, the SWC prototypically implements the use case of integrating activity and health data of the secondary healthcare market into the data space and making it available to other Health-X dataLOFT participants. It thus bridges the gap between device manufacturers and the Health-X dataLOFT platform.

## Tech Stack 🛠️

- *Java 17*
- *Spring Boot 3*
- *Docker*
- *Kubernetes/Kustomize*
- *Vue.js*
- *Maven*
- *MySQL*

## Build & Run (Local Environment)🚀
This chapter gives a brief overview of how the application can be run in the local environment outside a K8s cluster. For more technical details on the systems technical context consult the docs and READMEs mentioned in [Further Readings](#further-readings-).

### Setup a Cluster
For running the application locally, install a local K8s cluster environment like *minikube* or *Rancher* and run the following commands (from project root level):

```
cd deployment/local
kubectl apply -k . 
```

️⚠️ **Note:** Ensure that the Keycloak, MySQL and, optionally, RUN-DSP connector workloads are reachable from outside the cluster by using a `NodePort` service or `kubectl port-forward`. 

### Run the Application
The application requires a number of runtime variables in order to function properly. An overview of these is given by the list below.  
While these are managed by K8s in cluster deployments, they must be passed manually in local environments.

- `DB_IP_PORT_SCHEMA`
- `DB_USERNAME`
- `DB_PASSWORD`
- `SWC_KEYCLOAK_CLIENT_ID` *(optional)*
- `SWC_KEYCLOAK_CLIENT_SECRET`
- `SWC_KEYCLOAK_AUTH_GRANT_TYPE` *(optional)*
- `SWC_KEYCLOAK_SCOPE` *(optional)*
- `SWC_KEYCLOAK_ISSUER_URI` *(optional)*
- `SWC_KEYCLOAK_REALM`
- `SWC_KEYCLOAK_USER_NAME_ATTRIBUTE` *(optional)*
- `SWC_JWT_ISSUER_URI` *(optional)*
- `SWC_JWK_SET_URI` *(optional)*
- `AUTH_JWE_REJECT_JWT` *(optional)*
- `AUTH_JWE_PRIVATE_KEY_FILENAME` *(optional)*
- `THRYVE_BASE_URL` *(optional)*
- `THRYVE_USERNAME`
- `THRYVE_PASSWORD`
- `THRYVE_APP_ID`
- `THRYVE_APP_SECRET`
- `THRYVE_AUTH_REDIRECT_URI`
- `SWC_BASE_URL`
- `SWC_PUBLIC_URL`
- `GARMIN_OAUTH_SUCCESS_REDIRECT_URL`
- `GARMIN_CONSUMER_KEY`
- `GARMIN_CONSUMER_SECRET`
- `AES_ENCRYPTION_KEY`
- `KEYCLOAK_ADMIN_CLIENT_ID` *(optional)*
- `KEYCLOAK_ADMIN_USER` *(optional)*
- `KEYCLOAK_ADMIN_PASSWORD` *(optional)*
- `CONNECTOR_RUN-DSP_SERVER_PORT` *(optional)*
- `DATA_TRANSFER_URL_TEMPLATE`
- `EDC_API_KEY`
- `ASSET_GENERATION_URL`
- `VC_SIGNING_PUBLIC_KEY_FILENAME` *(optional)*
- `VC_SIGNING_PRIVATE_KEY_FILENAME` *(optional)*

Note, that for variables marked as ***(optional)*** default values are set so that these may be ommitted in cases where the default value defined in the `application.yaml` matches the local environment.

Run the application by executing the following command from the `/data-boot` directory or run the Spring project using your IDE:
```
./mvnw -DVariable1=value1 -DVariable2=value2 [...] install
```

## Further Readings 📗
### Documentation
A general overview of the application and its context can be found in the documentation files provided in the `/docs` subfolder.  

### Deployment
Deployment instructions are given in the README files within the `/deployment` subfolder.  

## License 📜

The software is published under the *European Union Public Licence (EUPL)* (see `LICENSE.txt`).