pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'MAVEN_PATH'
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
        stage('Build Project with Maven') {
            steps {
                echo 'start Building...'
                // Run Maven on a Unix agent.
                bat 'mvn clean install'

            // To run Maven on a Linux agent, use
            // sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Build Docker Image') {
            steps {
                echo 'start building image...'
                bat 'docker build -t dorrabenletayfa/springboot_user_crud_image .'
            }
        }
        stage('Push Docker Image') {
            steps {
                echo 'start pushing image...'
                bat 'docker login'
                bat 'docker push dorrabenletayfa/springboot_user_crud_image:tagname'
            }
        }
    }
}
