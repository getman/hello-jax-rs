
set curl_path=C:\work\tool\web\curl\7.59\src
set tomcat_host=localhost
set tomcat_port=8081
set tomcat_username=admin-script
set tomcat_password=12345678
::name of the servlet
set context_path=jax-rs-webservice
set war_path=C:\work\develop\java\ee\tests\webservice\jax-rs\war-restful-service\target\jax-rs-webservice.war

%curl_path%\curl.exe -v -u "%tomcat_username%:%tomcat_password%" --upload-file %war_path% "http://localhost:8081/manager/text/deploy?path=/%context_path%&update=true"
