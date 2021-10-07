# distichain-test

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Mohammedkherfan/distichain-test.git
   ```
2. Install Redis docker container
   ```
   docker-compose up
   ```
3. Start Application
   ```
   Run ProductApplication.class from test-api module
   ```

3. Start Application in docker file
   ```
   Already there are DockerFile file to build and run the application in docker container.
   
   Run This command below:
   
   mvn clean install
   docker build -t distichaindemo .
   docker run -p 8080:8080 distichaindemo
   ```

##### Note:
1. Please not everything configurable in application.yml
2. There is Postman collection in file (distichain-assignment.postman_collection.json) to import service api in postman.

