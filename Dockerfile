
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM alpine:11
    MAINTAINER nanreh1976
    COPY target/portfolioapi-0.0.1-SNAPSHOT.jar nanreh.jar
    ENTRYPOINT ["java","-jar","nanreh.jar"
