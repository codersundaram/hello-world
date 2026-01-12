pipeline {
    agent any
    tools {
        maven 'mvn-3.9.12' // The name you gave in Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/codersundaram/hello-world.git', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('install') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('docker-image') {
            steps {
                bat 'docker build -t springboot-app .'
            }
        }
        stage('docker-container') {
            steps {
                bat 'docker run -p 8086:8080 springboot-app'
            }
        }
    }
}
