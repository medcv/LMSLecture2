FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD lms-0.0.1-SNAPSHOT.jar lms.jar
RUN sh -c 'touch /lms.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /lms.jar" ]