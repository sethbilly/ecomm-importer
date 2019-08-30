
FROM openjdk:8-jre-alpine
#Use wget to download activemq
RUN wget -O activemq.tar.gz http://archive.apache.org/dist/activemq/5.15.6/apache-activemq-5.15.6-bin.tar.gz
#Extract activemq archive
RUN tar -xzf activemq.tar.gz
#Start activemq
CMD ["apache-activemq-5.15.6/bin/activemq", "console"]