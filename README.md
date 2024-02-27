
# PORTAONE_TEST  
**This web application allows you to calculate six values**
- maximum list value
- minimum list value
- median value
- arithmetic average value
- the largest sequence of numbers that increases
- the largest decreasing sequence of numbers

**To run this application you need IntellijIdea or other IDE for Java environment**

**To set up the application, follow these steps:**

1. Clone the repository: `git clone https://github.com/sanmartial/portaone_test.git`.
2. Ensure you have Java and Maven installed.
3. Run the Docker for your environment.
4. Execute the following commands in the project root directory:
   ```bash
   mvn package
   docker build -t app .
   docker run -p 8088:8080 app
  ***Unfortunately, Docker does not allow access to the file inside the container,   
but you can deploy this application to any server, such as AWS, and run it using this service.*** 

5. Or launch IDE, open any browser and follow the link access the Swagger documentation at 
`http://localhost:8080/swagger-ui/index.html`.  

Feel free to explore the API 🚀
Thank you for watching, and happy exploring!