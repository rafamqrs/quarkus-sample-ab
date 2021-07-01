# quarkus-sample-ab
Quarkus Project to Test Deployment A/B on the Openshift

# Building is handled by the container-image-s2i extension. To trigger a build:
```bash
./mvnw clean package -Dquarkus.container-image.build=true
```

# To deploy two containers image created in the above step to OpenShift, follow these commands:
```bash
oc get is
oc new-app --name=quarkus-a <project>/openshift-quarkus-ab:1.0.0-SNAPSHOT
oc new-app --name=quarkus-b <project>/openshift-quarkus-ab:1.0.0-SNAPSHOT
oc set env deployment quarkus-a APP_NAME="quarkus-a"
oc set env deployment quarkus-b APP_NAME="quarkus-b"
oc get svc
oc expose svc/quarkus-a
oc get routes
curl http://<route>/greeting
```

# Load balancing for A/B testing
```bash
oc create -f route.yaml -n <project>
```

Docs: https://docs.openshift.com/container-platform/4.6/applications/deployments/route-based-deployment-strategies.html





