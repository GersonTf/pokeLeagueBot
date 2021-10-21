FROM openjdk:11.0.12-jre-buster
COPY build/libs/*.jar pokeLeagueBot-0.1.jar
EXPOSE 8080
CMD java  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar pokeLeagueBot-0.1.jar