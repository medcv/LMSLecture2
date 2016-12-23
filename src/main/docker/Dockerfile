FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD LMSLecutre2-0.0.1-SNAPSHOT.jar LMS.jar
RUN sh -c 'touch /LMS.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /LMS.jar" ]