pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                git 'https://github.com/codersundaram/hello-world'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}