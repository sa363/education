Собрать образ docker для spring-boot можно разными способами
Например:
 - использовать плагин spring для сборки образа, идет в поставке и запускается командой
 ```cmd
  ./mvnw spring-boot:build-image 
 ```
 - Создание Dockerfile и запуск сборки командой 
 ```cmd
  docker build -t paragraph7_2:0.0.1 -f Dockerfile
 ```

Запуск контейнера на основе собранных образов
```cmd
docker run -d -e SERVER_PORT=8080 -p8080:8080 
```
Где параметр -p принимает значение маппинга порта host:container