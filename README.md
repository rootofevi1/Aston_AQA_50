# Postman Echo API Tests

Автотесты для проверки API https://postman-echo.com

## Стек технологий
- Java 11
- RestAssured 5.4.0
- JUnit 5
- Gradle (Kotlin DSL)
- Jackson 2.16.2
- AssertJ 3.25.3

## Структура тестов

### GET-запросы (/get)
- ✅ Позитивный: GET с двумя параметрами
- ✅ Негативный: GET без параметров
- ✅ Негативный: GET с одним параметром
- ✅ Негативный: GET с пустыми значениями

### POST-запросы (/post)
**Raw Text (JSON):**
- ✅ Позитивный: POST с JSON в теле
- ✅ Негативный: POST с пустым телом
- ✅ Негативный: POST с невалидным JSON
- ✅ Негативный: POST с числом вместо объекта

### PUT-запросы (/put)
- ✅ Позитивный: PUT с текстом
- ✅ Негативный: PUT с пустым телом
- ✅ Негативный: PUT с JSON вместо текста
- ✅ Негативный: PUT со специальными символами

### PATCH-запросы (/patch)
- ✅ Позитивный: PATCH с текстом
- ✅ Негативный: PATCH с JSON вместо текста
- ✅ Негативный: PATCH с пустым телом

### DELETE-запросы (/delete)
- ✅ Позитивный: DELETE с текстом
- ✅ Негативный: DELETE с JSON вместо текста
- ✅ Негативный: DELETE с пустым телом

## Запуск

```bash
# Все тесты
./gradlew clean test

# Конкретный класс
./gradlew test --tests GetTests

# Отчет
# build/reports/tests/test/index.html