# distichain-test

### Summary
In this service I'm using redis cache server to write data on the cache to make check and get records more fast and easy also I'm writing the data one csv file.
We have four main component to this service:
1. Create api:
   In this api will receive list of products that we have to add it to csv file and this operation will be by the process below:
   1. Check if the record already exist in our file.
   2. Working to separating the existing products from non-existing.
   3. Add existing products to cache and file.
   4. Return existing products and non-existing to user.
   
2. Get api:
   In this api will get the product by sku. by the process below:
   1. Check if the product exist in cache, if yes will return it directly.
   2. If the product not exist in cache server will check in the file and return it.
   3. If the sku not exist will return error
   
3. Update api:
   In this api will update record on cache and on file.
   1. Check if the product exist in cache, and update it on cache.
   2. Check if the product exist in file, and update it on file.
   3. If record not exist in cache will check file directly and if not exist in file will return error.
   
4. Refresh Job
   This is a scheduler job working every configurable selected time in millisecond to refresh cache by read data from file.


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

