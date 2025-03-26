# Getting Started
Запустить docker-compose
```shell
docker-compose up
```
или как указано ниже:
Создать бд через докер потом запустить приложение
```shell
docker run -it --name yaroslav -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=yaroslav -d postgres:11-alpine
```
Установить maven
https://maven.apache.org/download.cgi
(если есть то пропустить этот пункт)
 
Собрать исполняемый файл jar
```shell
mvn -f pom.xml clean package -D  maven.test.skip=false 
```
Запустить приложение
```shell
java -jar target/demo-0.0.1-SNAPSHOT.jar --status=running
```

Запросы:
Создаем пользователя:
```shell
curl --location 'http://127.0.0.1:8080/users' \
--header 'Content-Type: application/json' \
--data '{"id":"123123123","name":"name","email":"2025-02-03T10:48:45"
,"age":22,"weight":99,"height":99,
"goal":"WeightLoss","dailyCalorieNorm":777}'
```
Создаем блюда:
```shell
curl --location 'http://127.0.0.1:8080/food/meal?name=pelmeni&caloriesPerPortion=1111&proteins=111&fats=11&carbs=21' \
--header 'Content-Type: application/json'  
```
```shell
curl --location 'http://127.0.0.1:8080/food/meal?name=ice&caloriesPerPortion=1111&proteins=111&fats=11&carbs=21' \
--header 'Content-Type: application/json' 
```
```shell
curl --location 'http://127.0.0.1:8080/food/meal?name=meat&caloriesPerPortion=1111&proteins=111&fats=11&carbs=21' \
--header 'Content-Type: application/json' 
```
Записываем прием пищи:
```shell
curl --location 'http://127.0.0.1:8080/food/record?userId=2&mealNames=meat%2Cice%2Cpelmeni&date=2025-02-03' \
--header 'Content-Type: application/json' \
```

Получаем отчеты:
```shell
curl --location 'http://localhost:8080/reports/day?userId=2&date=2025-02-03'
```