FROM openjdk:17
VOLUME /tmp
ADD target/service-users.jar service-users.jar
ENTRYPOINT [ "java","-jar","/service-users.jar" ]