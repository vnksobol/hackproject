CREATE TABLE IF NOT EXISTS question
(
    id         INT GENERATED ALWAYS AS IDENTITY,
    title      VARCHAR(255),
    definition TEXT
);

INSERT INTO question (title, definition)
SELECT '@font-face',
       'Позволяет определить настройки шрифтов, а также загрузить специфичный шрифт на компьютер пользователя'
WHERE NOT EXISTS(SELECT 1 FROM question WHERE title = '@font-face');

INSERT INTO question (title, definition)
SELECT 'font-stretch', 'Устанавливает более широкое или узкое начертание шрифта'
WHERE NOT EXISTS(SELECT 1 FROM question WHERE title = 'font-stretch');


