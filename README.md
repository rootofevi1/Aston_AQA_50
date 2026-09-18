# API-тесты Postman Echo

REST Assured tests for HTTP request and response behavior using Postman Echo.

GET, POST, PUT, PATCH и DELETE: статус, Content-Type, параметры, заголовки, текстовое и JSON-тело ответа. DTO EchoResponse используется для десериализации.

Часть учебного портфолио, подготовленного во время обучения AQA в Aston. [Все работы курса](https://github.com/rootofevi1/Aston_AQA_50#readme).

## Стек и структура

Java 11 (source/target), REST Assured 5.4.0, JUnit 5.10.2, Jackson, AssertJ, Lombok, Gradle.

- [Исходный код](src/test/java/api/)
- [Настройки сборки](build.gradle.kts)
- Gradle Wrapper 8.14.4 включён в репозиторий.

## Запуск

Для воспроизводимого запуска используется JDK 21; там, где задан sourceCompatibility, сохранена Java 11. Нужен интернет для первой загрузки Gradle и зависимостей.

```bash
git clone --branch Lesson_8 --single-branch https://github.com/rootofevi1/Aston_AQA_50.git
cd Aston_AQA_50
./gradlew test
```

В Windows PowerShell замените `./gradlew` на `.\gradlew.bat`. Команды `java -cp` одинаковы для обеих систем.

Выбор одного класса: `./gradlew test --tests 'api.tests.GetTests'`.

HTML-отчёт Gradle: `build/reports/tests/test/index.html`. XML: `build/test-results/test/`.

## Особенности проверок

Postman Echo возвращает переданный запрос. Пустые параметры и альтернативные форматы тела проверяют варианты входных данных, а не обязательно ошибки HTTP: ряд таких тестов ожидает `200`. Запуск зависит от доступности `postman-echo.com`.

## Автор

Александр · Junior QA/AQA Engineer · [Email](mailto:a@samoylov-qa.ru) · [Telegram](https://t.me/samoylov_av)
