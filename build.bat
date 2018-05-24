@echo off
mvn clean install -DskipTests -DDATABASE_URL=jdbc:postgresql://postgres:postgres@localhost:5432/stHerokuBackendDb