FROM jboss/wildfly:9.0.2.Final

ADD target/assignment.war /opt/jboss/wildfly/standalone/deployments/
USER root
RUN mkdir -pv /upload/img
EXPOSE 8080
ENTRYPOINT /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -DIMAGE_DIR=/upload/img -DPAGE_SIZE=10  -DDATABASE_URL=jdbc:postgresql://assignment_db:5432/assignment_local -DDATABASE_USER=postgres  -DDATABASE_SEC=docker -DLOGS_BASE=/opt/jboss/wildfly/standalone/log
