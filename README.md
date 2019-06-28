## Estrutura do projeto

Deve ser observado a porta configurada para o servidor, no perfil selecionado no appplication.properties:

application.properties:

```
spring.profiles.active=dev
...

```
application-dev.properties:

```
...
server.port=8090
...

```

### Configuração

* Instalar o Lombok 1.18.2
* Modificar a URL de conexão com o Banco no application-dev.properties


Tecnologias Utilizadas:

* Spring Boot 2.0
* Java 8
* Lombok 1.18.2
* SQL server
* Flyway

Documentação:
* Swagger 2 ( http://localhost:8090/swagger-ui.html# )
