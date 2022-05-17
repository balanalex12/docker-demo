pipeline {
    agent any

    stages {
        stage('Clean and clone repository') {
            steps {
                bat "docker-compose -f docker-compose.yml down || exit 0;"
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/balanalex12/docker-demo.git'

            }
        }

        stage("Build"){
            steps{
                  bat "gradle clean build"
            }
        }

        stage("Deploy"){
            steps{
                bat "docker-compose -f docker-compose.yml up -d "
            }
        }
    }
}
