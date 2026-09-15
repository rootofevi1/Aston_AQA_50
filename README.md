# Александр — учебные проекты AQA / Aston

Java test automation coursework: unit tests, REST API checks and Selenium UI tests with Allure reporting.

Практические работы, выполненные во время обучения автоматизации тестирования в Aston. Репозиторий показывает путь от основ Java до модульных, API- и UI-тестов. Каждая учебная ветка содержит самостоятельный проект со своей сборкой и README.

## С чего начать

- [UI-тесты и Allure — Lesson_11](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_11): Page Object, проверки форм и iframe, организация отчётов.
- [REST Assured — Lesson_8](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_8): HTTP-методы, параметры, тела ответов и DTO.
- [JUnit 5](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_7_junit_5) и [TestNG](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_7_testng): две реализации модульных проверок одного предметного набора.

## Карта проектов

| Ветка | Содержание |
|---|---|
| [Lesson_1](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_1) | Основы Java |
| [Lesson_2](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_2) | Классы и объекты |
| [Lesson_3](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_3) | Наследование и интерфейсы |
| [Lesson_4](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_4) | Обработка исключений |
| [Lesson_5](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_5) | Коллекции Java |
| [Lesson_7_junit_5](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_7_junit_5) | Модульные тесты: JUnit 5 |
| [Lesson_7_testng](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_7_testng) | Модульные тесты: TestNG |
| [Lesson_8](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_8) | API-тесты Postman Echo |
| [Lesson_9](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_9) | UI-тесты MTS: базовые сценарии |
| [Lesson_10](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_10) | UI-тесты MTS: расширение покрытия |
| [Lesson_11](https://github.com/rootofevi1/Aston_AQA_50/tree/Lesson_11) | UI-тесты MTS: Allure |

Ветка `Lesson_6` в репозитории отсутствует. `main` служит оглавлением; для запуска выберите нужную учебную ветку.

## Развитие UI-проекта

1. `Lesson_9`: базовые проверки формы MTS; Page Object и явные ожидания уже используются.
2. `Lesson_10`: расширение до девяти сценариев, плейсхолдеры услуг и iframe оплаты.
3. `Lesson_11`: Allure-аннотации и формирование отчётности для расширенного набора.

## Быстрый старт

Нужен JDK 21 для единого окружения запуска Gradle Wrapper 8.14.4. В ветках с явно указанными Java source/target сохранена версия 11.

```bash
git clone https://github.com/rootofevi1/Aston_AQA_50.git
cd Aston_AQA_50
git switch Lesson_7_junit_5
./gradlew test
```

Windows PowerShell: `.\gradlew.bat test`. HTML-отчёт: `build/reports/tests/test/index.html`. Детальные команды и требования к браузеру/API находятся в README выбранной ветки.

## Проверка качества

[GitHub Actions](https://github.com/rootofevi1/Aston_AQA_50/actions/workflows/verify.yml) компилирует все учебные ветки и запускает модульные тесты JUnit 5/TestNG. Внешние API и платёжный сайт не запускаются автоматически: их состояние и разметка могут изменяться. Зелёная сборка не означает успешного выполнения внешних UI/API-сценариев.

Результаты модульных тестов сохраняются артефактами workflow. Код для UI-тестов не вводит данные карты и не выполняет платёж.

## Другие проекты

- [API: Reqres](https://github.com/rootofevi1/api-testing-reqres)
- [Web UI: SauceDemo](https://github.com/rootofevi1/ui-testing-saucedemo)
- [Android: Espresso](https://github.com/rootofevi1/android-espresso-ui-tests)
- [Профиль и контакты](https://github.com/rootofevi1)

## Автор

Александр · Junior QA/AQA Engineer

[Email: a@samoylov-qa.ru](mailto:a@samoylov-qa.ru) · [Telegram: @samoylov_av](https://t.me/samoylov_av)

