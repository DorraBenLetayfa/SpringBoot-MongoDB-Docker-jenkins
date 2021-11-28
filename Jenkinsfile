pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_PATH"
    }
    // tools {
    //     maven 'MAVEN_PATH'
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
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean install"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                // sh "mvn clean install"
                
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
