### Restrict Public Availability of Endpoints

_Append `--kubeconfig [KUBECONFIG_FILE]` to each command for remote clusters._

The kustomization in this folder configures the Kubernetes Gateway API to only publicy expose the following route patterns 
which are required to be available for the SWC to work properly:

```
# Health-X Gateway API endpoints
/data/health-x/*

# Garmin Webhook API
/data/garmin-api/*

# Garmin OAuth success callback endpoint
/data/external-vendors/garmin/authorization-granted/*
```

At the same time, the kustomization removes the route matcher for the SWC app and adjusts `app-configmap` accordingly 
so that the application is no longer available via `smartwearables.health-x.org`. 
Instead, it may be accessed by using `kubectl port-forward`:
```
kubectl port-forward svc/swc-data-service 3333:80 -n smartwearables
```

