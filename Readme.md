This is the account BackEnd code. The main requirements from the user is their firstname, lastname, email, phone, password, gender and birthday. 

Once the information is provided there is an option to see all the users, add new users, delete a perticular user and update their passwords. I will add other updates very soon. 

Thank you very much. I have done a sucsseful build for this package in Jenkins and currently working on adding it to my Tomcat server. 

Edit- 

Added the docker dockerfile to create the docker image:

Run this first to create a docker image: docker build -t springio/gsspringbootdocker .

Now run: docker run -p 8080:8080 springio/gsspringbootdocker

The container HAS to run on port 8080 as I have specifically mentioned it in the application.property file. 

