pipeline {
    agent any

    // tool name: 'MAVEN_HOME', type: 'maven'
    // tools {
    //     maven 'MAVEN_HOME'
    // }

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
                // sh 'mvn clean install'
                withMaven(maven : 'apache-maven-3.8.3') {
                    bat 'mvn clean compile'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
