# Наследование и интерфейсы

Java inheritance and interfaces demonstrated with animals and geometric shapes.

Две модели: животные (Animal, Cat, Dog, Bowl) и геометрические фигуры (Shape, Circle, Rectangle, Triangle). Наследование, полиморфизм и расчёт площади/периметра.

Часть учебного портфолио Александра, подготовленного во время обучения AQA в Aston. [Все работы курса](https://github.com/rootofevi1/Aston_AQA_50#readme).

## Стек и структура

Java, Gradle.

- [Исходный код](src/main/java/)
- [Настройки сборки](build.gradle.kts)
- Gradle Wrapper 8.14.4 включён в репозиторий.

## Запуск

Для воспроизводимого запуска используется JDK 21; там, где задан sourceCompatibility, сохранена Java 11. Нужен интернет для первой загрузки Gradle и зависимостей.

```bash
git clone --branch Lesson_3 --single-branch https://github.com/rootofevi1/Aston_AQA_50.git
cd Aston_AQA_50
./gradlew classes
java -cp build/classes/java/main lesson_3_animals.Main
java -cp build/classes/java/main lesson_3_calculating.Main
```

В Windows PowerShell замените `./gradlew` на `.\gradlew.bat`. Команды `java -cp` одинаковы для обеих систем.

## Что показывает проект

Самостоятельные консольные примеры для изучения Java. Отдельного набора автоматических тестов в этой ветке нет: `classes` проверяет компиляцию, запуск `Main` демонстрирует поведение.

## Автор

Александр · Junior QA/AQA Engineer · [Email](mailto:a@samoylov-qa.ru) · [Telegram](https://t.me/samoylov_av)

