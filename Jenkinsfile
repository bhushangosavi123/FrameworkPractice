pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                echo 'Hello Jenkins'
                echo 'Current Date and Time'

                bat 'echo %date% %time%'

                echo 'Build process Successful Done....'

                bat 'mvn clean'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Hello Jenkins'
                echo 'Current Date and Time'

                bat 'echo %date% %time%'

                echo 'Deploy process Successful Done....'
            }
        }

        stage('Test') {
            steps {
                echo 'Hello Jenkins'
                echo 'Current Date and Time'

                bat 'echo %date% %time%'

                echo 'Test process Successful Done....'
                bat 'mvn test -PSubmitOrder'
            }
        }

        stage('Release') {
            steps {
                echo 'Hello Jenkins'
                echo 'Current Date and Time'

                bat 'echo %date% %time%'

                echo 'Release process Successful Done....'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Pipeline execution failed.'
        }
    }
}
