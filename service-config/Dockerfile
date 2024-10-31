FROM openjdk:17
VOLUME /tmp
ADD target/service-config.jar service-config.jar
ENTRYPOINT [ "java","-jar","/service-config.jar" ]