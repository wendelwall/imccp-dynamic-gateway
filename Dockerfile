FROM openjdk:8u171-jre-alpine
MAINTAINER 1782800572@qq.com
ADD imccp-dynamic-gateway-restapi/target/imccp-dynamic-gateway-restapi-1.0.0.jar /web.jar
ENV PROFILE="-Dspring.profiles.active=local"
ENV PARAMS="-Djava.security.egd=file:/dev/./urandom"
ENV JAVA_OPTS="-Xms256m -Xmx512m -Xss1024K  -XX:MaxMetaspaceSize=256m"
ENTRYPOINT exec java $JAVA_OPTS   $PROFILE  $PARAMS  -jar /web.jar
