
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorretto:17-alpine-jdk
    
    COPY target/portfolioapi-0.0.1-SNAPSHOT.jar portfoliobck.jar
    ENTRYPOINT ["java","-jar","portfoliobck.jar"]
