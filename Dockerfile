FROM java:1.8

MAINTAINER zhanwei_huang hzwy23@163.com

WORKDIR /opt

ADD . ./basic

WORKDIR basic

RUN mvn clean package -DskipTests=true

EXPOSE 8080

ENV TZ Asia/Shanghai

CMD java -jar target/microservice-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod