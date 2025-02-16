# Второй сервис

## Инструкция

Сервис выполнен в виде приложения на Spring Boot, соответственно точка входа в программу метод main класса FrameListenerApplication

Необходимо установить PostgreSQL

### Конфиг:

В файл application.properties необходимо ввести URL основного сервиса:

```
mainServiceUrl=YOUR_URL_TO_MAIN_SERVICE
```

Также необходимо ввести свободный, отличный от 8080 порт:

```
server.port=9090  # или любой другой кроме 8080
```

Необходимо сконфигурировать подключение к СУБД PostgreSQL:

```
spring.datasource.url=YOUR_DATASOURCE_URL  # например jdbc:postgresql://localhost:5432/video
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```
### API:

Реализован один тип запросов для пользователя:

- Запрос на получение содержимого базы данных

```
GET /
```

- Запрос на получение по названию видеофайла или URL rtsp потока

```
GET /name; params: name

Example: GET /name?name=video.mkv
```

## Использованные технологии

PostgreSQL для сохранения данных

Spring Boot для взаимодействия с СУБД и межсервисного взаимодействия

Работоспособность тестировалась на JDK Eclipse Temurin 17