# UI-тесты MTS: базовые сценарии

Selenium UI tests for the MTS online payment form, using Page Object.

Четыре сценария: заголовок, логотипы платёжных систем, ссылка с описанием сервиса и переход к форме оплаты. Page Object и явные ожидания используются уже в этой ветке.

Часть учебного портфолио Александра, подготовленного во время обучения AQA в Aston. [Все работы курса](https://github.com/rootofevi1/Aston_AQA_50#readme).

## Стек и структура

Selenium 4.27.0, JUnit 5.10.0, WebDriverManager 5.6.2, Gradle.

- [Исходный код](src/test/java/mts/)
- [Настройки сборки](build.gradle.kts)
- Gradle Wrapper 8.14.4 включён в репозиторий.

## Запуск

Для воспроизводимого запуска используется JDK 21; там, где задан sourceCompatibility, сохранена Java 11. Нужен интернет для первой загрузки Gradle и зависимостей.

```bash
git clone --branch Lesson_9 --single-branch https://github.com/rootofevi1/Aston_AQA_50.git
cd Aston_AQA_50
./gradlew test
```

В Windows PowerShell замените `./gradlew` на `.\gradlew.bat`. Команды `java -cp` одинаковы для обеих систем.

Выбор одного класса: `./gradlew test --tests 'mts.tests.MtsOnlinePaymentTest'`.

HTML-отчёт Gradle: `build/reports/tests/test/index.html`. XML: `build/test-results/test/`.

## Окружение и границы сценариев

Нужны Google Chrome, доступ к `https://mts.by` и загрузке ChromeDriver. Изменения внешнего сайта или платёжного провайдера могут потребовать обновления локаторов. Сценарии доходят до формы оплаты; данные карты не вводятся, платёж не выполняется. Перед запуском используйте разрешённые тестовые данные.

Page Object расположен в `mts.pages`, сценарии — в `mts.tests`. `BasePage` содержит общие действия и ожидания; браузер закрывается после каждого теста. CI проверяет компиляцию этой ветки. Это не означает прохождение браузерных сценариев.

## Автор

Александр · Junior QA/AQA Engineer · [Email](mailto:a@samoylov-qa.ru) · [Telegram](https://t.me/samoylov_av)

