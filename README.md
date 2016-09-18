#Notifier Server

This notifier server receives data using a REST API (HTTP protocol) and sends messages to devices through FCM using the XMPP protocol.

##Technologies:

* Spring MVC
* Tomcat
* Maven
* Git

Considerations:

* The database is mocked
* Java 8
* IDE: Eclipse Mars

Additional tools to test the application:

* Json online viewer: [http://jsonviewer.stack.hu/](http://jsonviewer.stack.hu/)

##Methods:

1. **Send a message to a device. HTTP Method: GET**
```
http://localhost:8080/notifierServer/fcm/send?token=&message=

http://localhost:8080/notifierServer/fcm/send?token=cUxMCu2bgYM:APA91bEHpRPGM98R9cxXSDd87_lsrp8f2jH8swZPnD-d209DVhpN5jazEiKjkzyOG1NNJRahwYdrXft0sv5MoCzW22lt_Uc_YHfFajRFCLTatH8KeXwUj5YMBUXWwtCup2RxHoaUtkcC&message=hallo!!!
```

