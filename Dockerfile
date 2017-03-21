FROM openjdk:alpine
ENV C2WTROOT=/home/cpswt
COPY target/federation.manager-0.3.0-SNAPSHOT.jar /home
COPY federation.fed /home
COPY script.xml /home
COPY nar /home/nar/
COPY target/fedmgr.yml /home
COPY target/example.keystore /home
RUN mkdir -p /home/cpswt/log
WORKDIR /home
CMD ["java", "-jar", "-Djava.library.path=nar/processid-0.3.0-SNAPSHOT-amd64-Linux-gpp-jni/lib/amd64-Linux-gpp/jni/", "-Djava.net.preferIPv4Stack=true", "federation.manager-0.3.0-SNAPSHOT.jar", "server", "fedmgr.yml"]
EXPOSE 8080