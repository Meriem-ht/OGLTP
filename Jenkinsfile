pipeline {
  agent any
  stages {
     stage("test"){
      steps{
          bat './gradlew test'
          archiveArtifacts 'build/test-results/test/'
          cucumber buildStatus: 'UNSTABLE',
                          reportTitle: 'My report',
                          fileIncludePattern: '**/*.json',
                          trendsLimit: 10,
                          classifications: [
                              [
                                  'key': 'Browser',
                                  'value': 'Firefox'
                              ]
                          ]
      }
    }


    stage("Code Analysis"){
    steps{

      withSonarQubeEnv('sonar') {
                        bat "./gradlew sonar"
                    }
    }
    }


 stage("Code Quality") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }


stage("Build"){
           steps {
               bat './gradlew build'
               bat './gradlew javadoc'
               archiveArtifacts 'build/libs/*.jar'
            }
 }


 stage("Deploy"){
           steps {
               bat './gradlew publish'

           }
           }

stage("notification"){
          steps{
          notifyEvents message: 'New notification', token: 'yr39rpilgauqk4ryend8tulapje7cb36'
          mail to: 'km_hathat@esi.dz',
                         subject: "Succes",
                         body:"Najahna"

                    }
          }
}






}
}