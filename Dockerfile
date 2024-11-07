#Pull base image
FROM openjdk:21-jdk

#Set Locale for conatainer
ENV LANG en_US.UTF-8
ENV LANGUAGAE en_US:en

#Set timezone
ENV TZ Asia/Kolkata
RUN ln -snf /user/share/zoneinfo/$TZ etc/localtime && echo $TZ > /ect/timezone

#Copying the jar inside the image file system
COPY grocery-booking-0.0.1-SNAPSHOT.jar /usr/local
COPY runjar.sh /usr/bin/

#Running the jar
ENTRYPOINT["/bin/bash", "/usr/bin/runjar.sh"]
CMD["TRUE']