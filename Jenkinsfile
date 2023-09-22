pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/PierreAG/SimpleRestApi.git']]])
            }
        }
        stage('Build') {
            steps {
                // Set the JDK version to use
                tools {
                    jdk 'JDK_17' // This should match the JDK name defined in Jenkins
                }

                // Build the project using Maven
                sh 'mvn clean install'
            }
        }
    }

    post {
        success {
            // Add post-build actions here if needed
        }
    }
}
