DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnansweredQuestions`()
BEGIN
SELECT 
    temp1.questionId,
    MAX(temp1.answers) AS AnswerNumber
FROM (SELECT q.text AS question ,q.id AS questionId,
    COUNT(a.id) AS count,
    SUM(correctAnswer) AS answers,
	module FROM question q
    LEFT JOIN answer a ON q.id = a.questionID
    GROUP BY q.id
    HAVING answers = (MAX(a.correctAnswer))IS NULL) temp1  
    Group By module;
END$$
DELIMITER ;
