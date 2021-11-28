pipeline {
    agent any
    tools {
        maven 'MAVEN_PATH'
    }

    stages {
        stage('Clone') {
            steps {
                echo 'start cloning...'
                git 'https://github.com/DorraBenLetayfa/springBoot-mongoDB-docker-jenkins.git'
            }
        }
        stage('Build') {
            steps {
                echo 'start Building...'
                sh "mvn clean install"
                
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
