pipeline {
    agent any 
    parameters {
        string(name: 'Banner', defaultValue: 'Safeway', description: 'Which banner will be tested')
        choice(name: 'Runners', choices: ['1', '2', '3', '4', '5'], description: 'Amount of runners for testing our application')
        booleanParam (name: 'executeTests', defaultValue: true, description: '')
    }
    environment {
        VAR1 = '1.2'
    }
    stages {
        stage ("copy") {
            steps {
                echo 'Copying necessary files to test'
                //sh 'cp repository'
                //sh 'cp docker image'
            }
        }
        stage ("test execution") {
            when { //solo ejecuta los steps si se cumple esta condicion
                expression {
                   params.executeTests
                }
            }
            steps {
                script {
                    build job: 'Runner';
                    parameters: [
                        [ $class: 'StringParameterValue', name 'FROM_BUILD', value: "${BUILD_NUMBER}"]
                    ]
                }
            }
        }
    }
    
}