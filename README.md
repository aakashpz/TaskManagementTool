# TaskManagementTool
Angular10, spring boot and mongodb example app


<h2>Backend Local setup:</h2>

```
Step 1: Download or clone the source code to a local machine.

Step 2: mvn clean install

Step 3: Run the application or mvn spring-boot:run
```


<h2>Frontend Local setup:</h2>

```
Step 1: The npm install installs all modules that are listed on package.json file and their dependencies
npm install

Step 2: Run the Frontend application 
ng serve
```

Hit http://localhost:4200 link in a browser

<h2>Docker build</h2>

Step 1: Image creation : `docker build -t task_management_tool_image .`

Step 2: Pull mongodb container: `docker pull mongo`

Step 3: Running mongoldb container: `docker run -d --name mongo-on-docker -h localhost --ip 127.0.0.1 -p 27017:27017 mongo`

Step 4: Running Spring Application: `docker run -d --name task-management-tool -h localhost --ip 127.0.0.1 -p 8080:8080 task_management_tool_image`

Once done please use `http://localhost:8080/tasks`
