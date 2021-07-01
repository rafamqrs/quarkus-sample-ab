# quarkus-sample-ab
Quarkus Project to Test Deployment A/B on the Openshift

# Building is handled by the container-image-s2i extension. To trigger a build:

./mvnw clean package -Dquarkus.container-image.build=true

# To deploy the container image created in the above step to OpenShift, follow these commands:
```bash
oc get is
oc new-app --name=greeting <project>/openshift-quarkus-ab:1.0.0-SNAPSHOT
oc get svc
oc expose svc/greeting
oc get routes
curl http://<route>/greeting
```