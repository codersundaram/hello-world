pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                git 'https://github.com/codersundaram/hello-world.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}