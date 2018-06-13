# StHerokuBackend

A simple project to try a spring boot REST-like API on Heroku

## Setup

I tried to follow the instructions given [here](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku). I'll take not of some noteworthy commands as I go along.

Install Heroku CLI and Spring CLI. Then
```
heroku login
```

Create a project
```
spring init --dependencies=web myapp
```

To create a project on heroku
```
heroku create
```

To push to heroku
```
git push heroku master
```

Visit deployed app
```
heroku open
```

View remote logs
```
heroku logs --tail
```

Attach a postgress db, see config, see more details
```
heroku addons:create heroku-postgresql
heroku config
heroku pg
```

Locally create a postgresql db
```
createdb -h localhost -p 5432 -U postgres --password abcd1234 stHerokuBackendDb
```

## Development

Build
```
mvn clean install
```

Start locally
```
heroku local
```

## Production ready endpoint
* https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/reference/htmlsingle/#production-ready-endpoints
* http://localhost:8080/actuator/health

## Flyway setup
* Create dumps of the schema in pgadmin
* download flyway commandline tool
* adapt /conf/flyway.conf
```
flyway.url=jdbc:postgresql://localhost:5432/stHerokuBackendDb
flyway.user=db username   
flyway.password=db pw
```
* copy V1_xxx.sql into /sql folder
* run
``` 
./flyway migrate
./flyway info
./flyway clean
```

clean DB
```
cd backend/db-model
mvn flyway:clean
mvn flyway:migrate
```

## jOOQ
jOOQ is run as part of the maven install command. It seems we have a bit of a special case here if we want to externalize the configuration variables. The ```.env``` file contains the environment variables when running the app defined in the procfile using ```heroku local```, but to generate the jooq code we need to run the mvn install command which does not take the env file into account.
```
-DJDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/stHerokuBackendDb -DJDBC_DATABASE_USERNAME=postgres -DJDBC_DATABASE_PASSWORD=postgres clean install
```
Use the following to run the codegen only `mvn jooq-codegen:generate`

## Swagger
* [How To](https://www.easyitblog.info/2017/01/08/api-first-approach-with-swagger/)  
* [Online swagger editor](http://editor.swagger.io/#/)
* [SpringFox](http://springfox.github.io/springfox/docs/current/#maven) library to use swagger for spring boot and java.
* [Codegen mvn plugin](https://github.com/swagger-api/swagger-codegen/blob/master/modules/swagger-codegen-maven-plugin/README.md)
* [Spec](https://swagger.io/docs/specification/2-0/)
* [api editor](https://mermade.github.io/openapi-gui/) but for OAS 3.0

## Build
* Maven dependency graph `mvn dependency:build-classpath`
* to build the whole project with subprojects run `mvn clean install`

## Next steps
* learn and add jooq code
* learn basics of spring boot
* write a rest endpoint to query data
* write a rest endpoint to insert data
* deploy simple jar for api on webfaction
* add some data we can query
* use firestore app to reuse frontend

## Decisions
* How to split the git repos for frontend/backend/generated code:
    * A single git repo with sub projects, without using git submodules seems like a good fit for now (without having tried it). Git sub modules seem to come with difficulties.
    * The above suggestion does not work well with heroku, as the standard case for a heroku app is to have one repo for one app. It complicates the setup and especially the deployment, as there needs to be nested git repositories. Root repo in inside the deploy folder multiple git repos. So i guess having different repos for backend, frontend and other stuff will be the currently preferred solution.
* Where do we put the generated sources, for DB models and REST models server and client-side?
    * DB related models only concern the backend, therefore the first solution would be to leave it inside `src/main/java/com...database`
    * The server-side REST models are used by the backend. The generated default files come with a pom.xml, application.properties so it can be started separately. In order to avoid much configuration, it might make sense to just generate it into a separate subproject that the backend can reference. It might make sense to separate the REST spec into a separate subproject and also place the codegen tool there, so spec and API generation are nicely separated. However the tool is 14mb and it seems like there is no need to do this? It would be nice if the codegen could be disabled and only enabled for development
    * Client REST models are in typescript. Ideally we can directly generate them into the web project.
* Where do we deploy frontend and backend, which service do we use?
    * as the frontend will be angular and prod build will produce static files that contain html/css/js, which only need a simple webserver, it might make sense to move those to AWS S3 + clodefront that can serve then easily and is cheaper than heroku. At the same time we can ping the backend every 29 mins so it does not sleep
    * to deploy the backend we need a server that can run jar files and that scales. Heroku offers itself. Since running a jar file is not terribly complicated, at a later point in time it could be worthwhile to investigate aws for this purpose.
    * However, setting up heroku to work with jooq, postgres and flyway is somewhat cumbersome. Also we do not really know if and when we need to scale. It might be more effective to develop deploy on webfaction and make sure we can see the workload and adapt accordingly

