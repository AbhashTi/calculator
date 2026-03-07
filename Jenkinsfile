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
        mvn clean package
        '''
    }
}
stage('Stage 3: Publish Test Results') {
    steps {
        junit '**/target/surefire-reports/*.xml'
    }
}


        stage('Stage 4: Build Docker Image') {
            steps {
                sh 'docker build -t abhashti/calculator:latest .'
            }
        }
        stage('Stage 5: Push Docker Image to Docker Hub') {
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
        stage('Stage 6: Cleanup Docker Images') {
    steps {
        sh '''
        docker rmi abhashti/calculator:latest || true
        '''
    }
}

stage('Step 7: Ansiblee Deployment') {
    steps {
        ansiblePlaybook becomeUser: null,
        colorized: true,
        credentialsId: 'localhost',
        disableHostKeyChecking: true,
        installation: 'Ansible',
        inventory: 'Deployment/inventory.ini',
        playbook: 'Deployment/deploy.yml',
        sudoUser: null
    }
}

post {

    success {
        emailext(
            subject: "SUCCESS: Calculator Pipeline #${BUILD_NUMBER}",
            body: "The build completed successfully.\n\nBuild URL: ${BUILD_URL}",
            to: "your-email@gmail.com"
        )
    }

    failure {
        emailext(
            subject: "FAILED: Calculator Pipeline #${BUILD_NUMBER}",
            body: "The pipeline failed.\n\nCheck Jenkins: ${BUILD_URL}",
            to: "your-email@gmail.com"
        )
    }

}


    }
}

