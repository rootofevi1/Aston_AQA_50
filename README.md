# Модульные тесты: TestNG

TestNG tests for the calculator domain, with data providers.

Альтернативная реализация тестов арифметики, факториала, сравнения чисел и площади треугольника. Используются @Test, DataProvider и ожидаемые исключения.

Часть учебного портфолио Александра, подготовленного во время обучения AQA в Aston. [Все работы курса](https://github.com/rootofevi1/Aston_AQA_50#readme).

## Стек и структура

Java 11 (source/target), TestNG 7.10.2, Gradle.

- [Исходный код](src/test/java/lesson_7_testng/)
- [Настройки сборки](build.gradle.kts)
- Gradle Wrapper 8.14.4 включён в репозиторий.

## Запуск

Для воспроизводимого запуска используется JDK 21; там, где задан sourceCompatibility, сохранена Java 11. Нужен интернет для первой загрузки Gradle и зависимостей.

```bash
git clone --branch Lesson_7_testng --single-branch https://github.com/rootofevi1/Aston_AQA_50.git
cd Aston_AQA_50
./gradlew test
```

В Windows PowerShell замените `./gradlew` на `.\gradlew.bat`. Команды `java -cp` одинаковы для обеих систем.

Выбор одного класса: `./gradlew test --tests 'Lesson_7_testng.ArithmeticCalculatorTest'`.

HTML-отчёт Gradle: `build/reports/tests/test/index.html`. XML: `build/test-results/test/`.

## Что показывает проект

- Проверки обычных, граничных и ошибочных входных данных.
- Изоляцию вычислительной логики от тестового кода.
- Параметризацию проверок и работу с тест-раннером.

Сравнить реализации: [JUnit 5](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_7_junit_5) · [TestNG](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_7_testng).

## Автор

Александр · Junior QA/AQA Engineer · [Email](mailto:a@samoylov-qa.ru) · [Telegram](https://t.me/samoylov_av)

