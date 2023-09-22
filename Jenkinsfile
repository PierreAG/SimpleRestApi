pipeline {
    agent any

    environment {
        // Define your Docker registry credentials
        DOCKER_REGISTRY_CREDENTIALS = credentials('123')
        // Define the Docker image name
        DOCKER_IMAGE_NAME = "pierreag/spring"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from your version control system (e.g., Git)
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build your Spring Boot application with Maven
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build a Docker image with the Spring Boot JAR
                    docker.build(DOCKER_IMAGE_NAME, "-f Dockerfile .")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Push the Docker image to Docker Hub
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_REGISTRY_CREDENTIALS) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                // Deploy your Spring Boot application (e.g., to a Kubernetes cluster)
                // You can use kubectl, Helm, or other tools here
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }

    post {
        always {
            // Cleanup: Remove the Docker image from the local Jenkins workspace
            cleanWs()
        }
    }
}
