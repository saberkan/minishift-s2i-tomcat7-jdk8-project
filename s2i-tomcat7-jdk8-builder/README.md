# Description
S2I builder for tomcat jdk8 mvn 3 projects

# How to build / start
<pre>
docker build -t s2i-tomcat7-jdk8-builder s2i-tomcat7-jdk8-project
s2i build file://<my java project> s2i-tomcat7-jdk8-builder <choose name for my project image>
docker run -p 80:8080 <my project name image>
</pre>
