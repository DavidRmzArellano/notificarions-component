pipeline {

    agent any
    stages {

        stage('Build') {
            steps {
                    sh '''
                        ./build/mvn.sh mvn -B -DskipTests clean package
                        ./build/build.sh

                    '''
            }

        }
        stage('Test') {
            steps {
                            sh 'echo test'
            }

        }
        stage('Deploy') {
            steps {
                sh './deploy/deploy.sh'
            }
        }
    }
}
