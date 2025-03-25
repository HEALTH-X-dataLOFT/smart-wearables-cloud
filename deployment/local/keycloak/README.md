# Export Keycloak DEV Realm 

1. Export realm to pod-internal file
    ```
    kubectl exec -it svc/swc-keycloak-service -n smartwearables -- /opt/keycloak/bin/kc.sh export --dir /tmp/exports --users realm_file
    ```

2. Extract realm export from pod
    ```
    kubectl exec -it svc/swc-keycloak-service -n smartwearables -- cat /tmp/exports/smart-wearables-realm.json > [SWC_REPO_BASE_PATH]/deployment/local/realm-export.json
    ```
   
3. Copy realm config contents to configmap `keycloak_realm_configmap.yaml`

