pipeline {
    agent any

    stages {

        stage('Stage 1: Git Clone') {
            steps {
                checkout scm
            }
        }

        stage('Stage 2: Maven Build') {
    steps {
        sh '''
        export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
        export PATH=$JAVA_HOME/bin:$PATH
        java -version
        mvn clean package -DskipTests
        '''
    }
}


        stage('Stage 3: Build Docker Image') {
            steps {
                sh 'docker build -t abhashti/calculator:latest .'
            }
        }
        stage('Stage 4: Push Docker Image to Docker Hub') {
    steps {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            sh '''
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push abhashti/calculator:latest
            '''
        }
    }
}

    }
}

