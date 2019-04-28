FROM primetoninc/jdk:1.8

MAINTAINER zhanwei_huang hzwy23@163.com

WORKDIR /opt

ADD ./target/ ./basic

WORKDIR basic

EXPOSE 8080

ENV TZ Asia/Shanghai

CMD java -jar microservice.jar --spring.profiles.active=prod