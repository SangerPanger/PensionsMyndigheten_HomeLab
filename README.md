# Mini Förmånssystem

Ett backendprojekt byggt i Java och Spring Boot för att simulera ett enkelt förmånssystem inspirerat av myndighetsdomän.

## Tekniker
- Java 21
- Spring Boot
- REST API
- JMS / ActiveMQ
- Maven
- JUnit
- Jenkins
- Git

## Funktioner
- Skapa ansökan
- Hämta ansökan
- Lista ansökningar
- Skicka in ansökan
- Skicka JMS-meddelande vid submit

## API-endpoints
- POST /applications
- GET /applications
- GET /applications/{id}
- POST /applications/{id}/submit

### Starta ActiveMQ
```bash
docker run -d --name activemq -p 61616:61616 -p 8161:8161 rmohr/activemq
```
### Starta Jenkins
```bash
docker run -d --name jenkins \ -p 8081:8080 -p 50000:50000 \ -v jenkins_home:/var/jenkins_home \ jenkins/jenkins:lts
```

### Kör Applikationen
```bash
mvn spring-boot:run
```

### Kör Test
```bash
mvn spring-boot:run
```

## 2. Arkitekturbild
```text
Client
  |
  v
ApplicationController
  |
  v
ApplicationService
  |
  +--> In-memory storage
  |
  +--> ApplicationEventProducer
          |
          v
      ActiveMQ Queue



