FROM openjdk:17
VOLUME /tmp
ADD target/service-proxy.jar service-proxy.jar
ENTRYPOINT [ "java","-jar","/service-proxy.jar" ]