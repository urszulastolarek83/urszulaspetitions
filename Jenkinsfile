pipeline {
    agent any

    environment {
        // Define the app name here
        APP_NAME = 'urszulaspetitions'
    }

    stages {
        // Stage to checkout the code from GitHub
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        // Stage to build the project using Maven
        stage('Build') {
            steps {
                script {
                    // Run Maven build command to compile the project
                    sh 'mvn clean install'
                }
            }
        }

        // Stage to run unit tests
        stage('Test') {
            steps {
                script {
                    // Run unit tests using Maven (JUnit or similar)
                    sh 'mvn test'
                }
            }
        }

        // Stage to package the application into a WAR file
        stage('Package') {
            steps {
                script {
                    // Package the application into a WAR file
                    sh 'mvn package'
                }
            }
        }

        // Stage to manually approve deployment and deploy the WAR file
        stage('Deploy') {
            steps {
                // Ask for manual approval before deployment
                input message: 'Approve deployment?', ok: 'Deploy'
                
                script {
                    // Deploy to EC2 (make sure the path is correct for your Tomcat directory)
                    // You might need to adjust the EC2 instance's public IP address and destination path
                    sh 'scp target/' + APP_NAME + '.war ec2-user@<EC2_PUBLIC_IP>:/var/lib/tomcat9/webapps/'
                }
            }
        }
    }

    post

