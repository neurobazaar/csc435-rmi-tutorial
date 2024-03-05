## CSC435 Java RMI Tutorial
**Jarvis College of Computing and Digital Media - DePaul University**

### Requirements

To run the Java programs you will need to have Java 1.7.x and Maven 3.6.x installed on your systems. On Ubuntu 22.04 you can install Java and Maven using the following commands:

```
sudo apt install openjdk-17-jdk maven

```

### Java solution
#### How to build/compile

To build the Java solution use the following commands:
```
cd app-java
mvn compile
mvn package
```

#### How to run application

To run the Java Server (after you build the project) use the following command:
```
java -cp target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.hostname=<IP address> -Djava.security.policy=server.policy csc435.app.Server <IP address> <port>
> [quit]
```

To run the Java Client (after you build the project) use the following command:
```
java -cp target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.hostname=<IP address> -Djava.security.policy=server.policy csc435.app.Client <IP address>
```

#### Example

RMI Registry
```
rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false
```

Server
```
java -cp target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.hostname=127.0.0.1 -Djava.security.policy=server.policy csc435.app.Server 127.0.0.1 12345
> quit
```

Client 1
```
java -cp target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.hostname=127.0.0.1 -Djava.security.policy=server.policy csc435.app.Client 127.0.0.1 12345
2+2=4
2x2=4
```

Client 2
```
java -cp target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:target/app-java-1.0-SNAPSHOT.jar -Djava.rmi.server.hostname=127.0.0.1 -Djava.security.policy=server.policy csc435.app.Client 127.0.0.1 12345
2+2=4
2x2=4
```
