pipeline {
   agent any

   stages {
      stage('Clone') {
        steps {
          echo 'start cloning...'
          git 'https://github.com/DorraBenLetayfa/springBoot-mongoDB-docker-jenkins.git'
        }
   }
   stage('Build') {
     steps {
        sh 'mvn clean install'
     }
   }
   stage('Deploy') {
     steps {
       echo 'Deploying...'
     }
   }
  }
}