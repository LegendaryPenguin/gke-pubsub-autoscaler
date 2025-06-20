# Implementation

This is a simple project to build a k8s cluster of scalable apps to process messages from PubSub topic. 

There is a topic - postbox - where Bob can publish messages to, and a cluster of listeners (letter-reader app) subscribed to this topic. These applications can pickup messages from the topic and process them.

Each message has the following format:

{
  "id": "<unique uuid>",
  "id": "unique uuid",
  "recent_attemtps": 1
}
Field id is required and must be unique across all letters
Field recent_attemtps is optional and indicates the number of recent attempts made for this message.
There is a 2nd topic with name read_letters, which is used to count the total number of processed messages. The dashboard app is basically just an interface to this topic, and collects other useful statistics along the way. 


*My Steps to Build*
1. **Develop** the `dashboard` and `letter-reader` applications locally.
2. **Create Dockerfiles** for both applications.
3. **Build Docker images**:
   ```bash
   docker build -t gcr.io/<your-project-id>/dashboard ./dashboard
   docker build -t gcr.io/<your-project-id>/letter-reader ./letter-reader
Authenticate Docker with Google Container Registry (GCR):
gcloud auth configure-docker
Push images to GCR:

docker push gcr.io/<your-project-id>/dashboard
docker push gcr.io/<your-project-id>/letter-reader
📦 Step 2: Provision Infrastructure with Terraform
Define infrastructure in Terraform, including:

GKE cluster

Pub/Sub topics and subscriptions

Initialize Terraform:


terraform plan
Apply the infrastructure changes:
terraform apply
Step 3: Deploy to Kubernetes
Create deployment YAMLs:
k8s/letter-reader-deployment.yaml
k8s/dashboard-deployment.yaml

Deploy letter-reader:

kubectl apply -f k8s/letter-reader-deployment.yaml
Deploy dashboard:

kubectl apply -f k8s/dashboard-deployment.yaml
Verify running pods:

kubectl get pods
⚙Step 4: Scale the Letter-Reader Service
Scale to 3 replicas:

kubectl scale deployment letter-reader --replicas=3
Confirm scaled pods

Inspo: https://github.com/akaliuta/gke-pubsub
