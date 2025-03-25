FROM tomcat:10.1.24-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./data.war /usr/local/tomcat/webapps
COPY setenv.sh /usr/local/tomcat/bin/
RUN chmod +x /usr/local/tomcat/bin/setenv.sh
#COPY server.xml /usr/local/tomcat/conf/
COPY catalina /etc/logrotate.d/
COPY localhost /etc/logrotate.d/
COPY localhost_access_log /etc/logrotate.d/
COPY manager /etc/logrotate.d/
COPY host-manager /etc/logrotate.d/
COPY mysql-connector-java-8.0.17.jar /usr/local/tomcat/lib/

