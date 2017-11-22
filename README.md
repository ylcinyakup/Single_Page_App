Single_Page_App
Single Page App & Spring Boot, AngularJs

Çalıştırmak için öncelikle bir database bağlamanız gerekiyor bunun için mysql consolunda bu sql kodunu giriniz

    create database address_book
Daha sonra application.properties dosyasının içerisindeki username password bilgilerini kendi bilgileriniz ile değiştiriniz.

Çalıştırmak için ise MAVEN ın kurulu olması lazım. indirmiş olduğunuz paketin içerisinde cmd komut satırını açıp

    mvn clean spring-boot:run
komutunu çalıştırdığınızda gerekli jar lar indirilip proje koşturulucaktır.

Canlı halini görmek için tarayıcınızdan localhost:8080/ adresine gidin
