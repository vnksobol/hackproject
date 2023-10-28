CREATE TABLE IF NOT EXISTS question
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255),
    definition TEXT
);

-- DROP SEQUENCE QUESTION_SEQ;
CREATE SEQUENCE IF NOT EXISTS QUESTION_SEQ START WITH 200 INCREMENT BY 1;

-- INSERT INTO question (title, definition)
-- SELECT '@font-face',
--        'Позволяет определить настройки шрифтов, а также загрузить специфичный шрифт на компьютер пользователя'
-- WHERE NOT EXISTS(SELECT 1 FROM question WHERE title = '@font-face');
--
-- INSERT INTO question (title, definition)
-- SELECT 'font-stretch', 'Устанавливает более широкое или узкое начертание шрифта'
-- WHERE NOT EXISTS(SELECT 1 FROM question WHERE title = 'font-stretch');


