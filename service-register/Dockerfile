FROM openjdk:17
VOLUME /tmp
ADD target/service-register.jar service-register.jar
ENTRYPOINT [ "java","-jar","/service-register.jar" ]