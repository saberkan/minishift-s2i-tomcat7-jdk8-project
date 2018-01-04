#How to build

##BUILD BUILDER
<pre>
docker build -t s2i-tomcat7-jdk8-builder ./s2i-tomcat7-jdk8-build
</pre>

##PUSH BUILDER TO OC PROJECT
<pre>
oc create -f s2i-tomcat7-jdk8-builder-is.json
</pre>
The from tag should contain the image from repo, here we use saberkan repo from docker.io, we should be connect to it.

##DEPLOY PROJECT
<pre>
oc new-app %my-oc-project%/tomcat-7-jdk-8-builder~https://github.com/saberkan/TPRestJersey.git --name=tprestjersey
</pre>
