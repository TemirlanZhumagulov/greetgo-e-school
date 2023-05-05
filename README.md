# Задание "Электронная-школа"

## Обзор
![](https://github.com/TemirlanZhumagulov/greetgo-e-school/blob/main/Screenshot%20(44).png)

![](https://github.com/TemirlanZhumagulov/greetgo-e-school/blob/main/Screenshot%20(45).png)

## 1. Что должно быть скачано у вас:
1.1. Java JDK17+

1.2. Intellij IDEA или Eclipse

1.3. Visual Studio Code 

1.4. Angular CLI version 15.2.7

1.5. PostgreSQL 15 c pgAdmin и базой данных

1.6. Git

## 2. Как установить проект с Github
2.1. Открываем Visual Studio Code > new Terminal 

2.2. Вводим git clone https://github.com/TemirlanZhumagulov/greetgo-e-school.git

2.3. Открываем загруженную папку как проект в VS code

2.4. Открываем эту папку в проводнике

2.5. Внутри этой папки будет e-school-server, открываем его как проект в Intellij IDEA

Также, можете скачать проект с github через архив и распокавать его, или через расширение GitHub Pull Requests and Issues в VS code. 

## 3. Настройка и запуск
3.1. Открываем PgAdmin, заходим в сервер PostgreSQL15, и вводим свой пароль если он установлен и создаем базу данных с именем e-school

3.2. В application.properties указываем порт, username, password от PostgreSQL

```no-highlight
  spring.datasource.url=jdbc:postgresql://localhost:5432/e-school
  spring.datasource.username=USERNAME
  spring.datasource.password=PASSWORD
  spring.datasource.driver-class-name=org.postgresql.Driver
  spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
  spring.jpa.hibernate.ddl-auto=update
```

3.3. Запускаем приложение в классе ESchoolServerApplication.java

3.4. Ждём, когда запуститься сервер.

3.4. После запуска сервера, заходим в VS code > Terminal

3.5. Запускаем команду npm install, затем после загрузки, запускаем команду npm start

3.6. Ждём, когда запуститься сервер. После запуска сервера, заходим в браузере по адресу: http://localhost:4200/

## 4. Использование
4.0. Вы увидите окно входа/регистрации, вам необходимо зарегистрироваться

4.1. После регистрации вы увидите таблицу с студентами
