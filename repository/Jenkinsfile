pipeline {
    agent any 
    parameters {
        booleanParam (name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage ("Build") {
            steps {
                echo 'Building project'
            }
        }
        stage ("UnitTest") {
            steps {
                echo 'Running Unit Tests'
            }
        }
        stage ("UITests") {
            when { //solo ejecuta los steps si se cumple esta condicion
                expression {
                   params.executeTests
                }
            }
            steps {
                script {
                    build job: 'ParallelRunner',
                    parameters: [
                        [ $class: 'StringParameterValue', name: 'fromBuild', value: "${BUILD_NUMBER}"],
                        [ $class: 'StringParameterValue', name: 'banner', value: 'Safeway'],
                        [ $class: 'StringParameterValue', name: 'runners', value: '3'],
                        [ $class: 'BooleanParameterValue', name: 'executeTests', value: true]
                    ]
                }
            }
        }
    }
    
}