pipeline {
  agent any
  environment {
        PATH = "/opt/gradle/gradle-7.4/bin:$PATH"
    }

  stages {
    stage('Git Checkout') {
              steps {
                  checkout scm
                  echo 'Git Checkout Success!'
              }
    }
    stage('Test') {
        steps {
            sh 'gradle test'
            echo 'test success'
        }
      }
    stage('Build') {
      steps {
           sh 'gradle clean build --exclude-task test --exclude-task asciidoctor'
           echo 'build success'
      }
    }
  }
}