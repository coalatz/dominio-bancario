spring.datasource.url= jdbc:postgresql://${PG_HOST}:${PG_PORT}/${PG_DATABASE}
spring.datasource.username= ${PG_USER}
spring.datasource.password= ${PG_PASSWORD}
spring.datasource.driver-class-name= org.postgresql.Driver
spring.jpa.database-platform= org.hibernate.dialect.PostgreSQLDialect

spring.flyway.enabled=true
spring.flyway.baselineOnMigrate=true

server.error.include-message=always
server.error.include-binding-errors=always

agenda.api.security.token.secret=chave_secreta_agenda_api