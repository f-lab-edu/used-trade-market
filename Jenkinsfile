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
    /* stage('Test') {
        steps {
            sh 'gradle test'
            echo 'test success'
        }
      } */
    stage('Build') {
      steps {
           sh 'gradle clean build'
           echo 'build success'
      }
    }
    stage('Send Jar') {
        steps {
            sshPublisher(
                publishers:
                    [
                        sshPublisherDesc(
                            configName: 'chunjaeYH',
                            transfers:
                                [
                                    sshTransfer(
                                        cleanRemote: false,
                                        excludes: '',
                                        execCommand: 'sh /usr/usedmarket/script/deploy.sh',
                                        execTimeout: 120000,
                                        flatten: false,
                                        makeEmptyDirs: false,
                                        noDefaultExcludes: false,
                                        patternSeparator: '[, ]+',
                                        remoteDirectory: '/usr/usedmarket/',
                                        remoteDirectorySDF: false,
                                        removePrefix: 'build/libs',
                                        sourceFiles: 'build/libs/app.jar')],
                                        usePromotionTimestamp: false,
                                        useWorkspaceInPromotion: false,
                                        verbose: true
                                        )
                                ]
                        )
        }
    }
  }
}