FROM openjdk:11
EXPOSE 8002
VOLUME /tmp

ADD ./target/springboot-servicio-item-0.0.1-SNAPSHOT.jar servicio-item.jar
ENTRYPOINT ["java", "-jar", "servicio-item.jar"]
#crear docker build config-server:v1 .
#

#docker run -p 8888<el que sea>:8888 --name <asdfafconfig-server> --network network-spring config-server:v1


