# **KubeWatch: Cloud Native Resource Monitoring Using Python on K8s!** 💻☁️

## **Prerequisites** 🔍

(Things to have before starting the project)

- [x] AWS Account.
- [x] Programmatic access and AWS configured with CLI.
- [x] Python3 Installed.
- [x] Docker and Kubectl installed.
- [x] Code editor (VSCode)

# ✨Let’s Start the Project! ✨

## **Part 1: Deploying the Flask application locally** 🚀

### **Step 1: Clone the code** 📝

Clone the code from the repository:

```bash
git clone <repository_url>
```

### **Step 2: Install dependencies** 📦

The application uses the **`psutil`** and **`Flask`, Plotly, boto3** libraries. Install them using pip:

```bash
pip3 install -r requirements.txt
```

### **Step 3: Run the application** 🏃‍♂️

To run the application, navigate to the root directory of the project and execute the following command:

```bash
python3 app.py
```

This will start the Flask server on **`localhost:5000`**. Navigate to [http://localhost:5000/](http://localhost:5000/) on your browser to access the application.

## **Part 2: Dockerizing the Flask application** 🐳

### **Step 1: Create a Dockerfile** 📦

Create a **`Dockerfile`** in the root directory of the project with the following contents:

```Dockerfile
# Use the official Python image as the base image
FROM python:3.9-slim-buster

# Set the working directory in the container
WORKDIR /app

# Copy the requirements file to the working directory
COPY requirements.txt .

RUN pip3 install --no-cache-dir -r requirements.txt

# Copy the application code to the working directory
COPY . .

# Set the environment variables for the Flask app
ENV FLASK_RUN_HOST=0.0.0.0

# Expose the port on which the Flask app will run
EXPOSE 5000

# Start the Flask app when the container is run
CMD ["flask", "run"]
```

### **Step 2: Build the Docker image** 🛠️

To build the Docker image, execute the following command:

```bash
docker build -t <image_name> .
```

### **Step 3: Run the Docker container** 🚢

To run the Docker container, execute the following command:

```bash
docker run -p 5000:5000 <image_name>
```

This will start the Flask server in a Docker container on **`localhost:5000`**. Navigate to [http://localhost:5000/](http://localhost:5000/) on your browser to access the application.

## **Part 3: Pushing the Docker image to ECR** 🚀

### **Step 1: Create an ECR repository** 🏗️

Create an ECR repository using Python:

```python
import boto3

# Create an ECR client
ecr_client = boto3.client('ecr')

# Create a new ECR repository
repository_name = 'my-ecr-repo'
response = ecr_client.create_repository(repositoryName=repository_name)

# Print the repository URI
repository_uri = response['repository']['repositoryUri']
print(repository_uri)
```

### **Step 2: Push the Docker image to ECR** 🚀

Push the Docker image to ECR using the push commands on the console:

```bash
docker push <ecr_repo_uri>:<tag>
```

## **Part 4: Creating an EKS cluster and deploying the app using Python** 🌐

### **Step 1: Create an EKS cluster** 🛠️

Create an EKS cluster and add node group

### **Step 2: Create a node group** 🛠️

Create a node group in the EKS cluster.

### **Step 3: Create deployment and service** 🚀

```python
from kubernetes import client, config

# Load Kubernetes configuration
config.load_kube_config()

# Create a Kubernetes API client
api_client = client.ApiClient()

# Define the deployment
deployment = client.V1Deployment(
    metadata=client.V1ObjectMeta(name="my-flask-app"),
    spec=client.V1DeploymentSpec(
        replicas=1,
        selector=client.V1LabelSelector(
            match_labels={"app": "my-flask-app"}
        ),
        template=client.V1PodTemplateSpec(
            metadata=client.V1ObjectMeta(
                labels={"app": "my-flask-app"}
            ),
            spec=client.V1PodSpec(
                containers=[
                    client.V1Container(
                        name="my-flask-container",
                        image="568373317874.dkr.ecr.us-east-1.amazonaws.com/my-cloud-native-repo:latest",
                        ports=[client.V1ContainerPort(container_port=5000)]
                    )
                ]
            )
        )
    )
)

# Create the deployment
api_instance = client.AppsV1Api(api_client)
api_instance.create_namespaced_deployment(
    namespace="default",
    body=deployment
)

# Define the service
service = client.V1Service(
    metadata=client.V1ObjectMeta(name="my-flask-service"),
    spec=client.V1ServiceSpec(
        selector={"app": "my-flask-app"},
        ports=[client.V1ServicePort(port=5000)]
    )
)

# Create the service
api_instance = client.CoreV1Api(api_client)
api_instance.create_namespaced_service(
    namespace="default",
    body=service
)
```

Make sure to edit the name of the image on line 25 with your image URI.

- Once you run this file by running “python3 eks.py” deployment and service will be created.
- Check by running following commands:

```bash
kubectl get deployment -n default (check deployments)
kubectl get service -n default (check service)
kubectl get pods -n default (to check the pods)
```

Once your pod is up and running, run the port-forward to expose the service

```bash
kubectl port-forward service/<service_name> 5000:5000
```

Now, you should be able to access your application running on Kubernetes! 🎉

## **Contributing** 🤝

We welcome contributions from the community! If you'd like to contribute to this project, please follow these guidelines:

- Fork the repository and clone it to your local machine.
- Create a new branch for your feature or bug fix: `git checkout -b feature/your-feature` or `git checkout -b bugfix/your-bug-fix`.
- Make your changes and test them thoroughly.
- Commit your changes: `git commit -m 'Add some feature'`.
- Push to the branch: `git push origin feature/your-feature`.
- Submit a pull request detailing the changes you made.

## **License** 📜

This project is licensed under the MIT License - see

 the [LICENSE](LICENSE) file for details.

By contributing to this project, you agree that your contributions will be licensed under its MIT License.

## **Code of Conduct** 📝

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms, which can be found in the [CODE_OF_CONDUCT](CODE_OF_CONDUCT.md) file.
