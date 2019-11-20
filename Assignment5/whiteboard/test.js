require('./data/db.js')();
const universityDao = require('./data/dao/university.dao.server');
const assert = require("assert");


beforeAll(() => {
    jest.setTimeout(30000);
    return universityDao.populateDatabase();
});

afterAll(() => {
    return universityDao.truncateDatabase();
});

test('testStudentsInitialCount', () => {
    return universityDao.findAllStudents()
        .countDocuments()
        .then((students => expect(students).toBe(2)))
});


test('testQuestionsInitialCount', () => {
    return universityDao.findAllQuestions()
        .countDocuments()
        .then((questions => expect(questions).toBe(4)))
});

test('testAnswersInitialCount', () => {
    return universityDao.findAllAnswers()
        .countDocuments()
        .then((questions => expect(questions).toBe(8)))
});

test('testDeleteAnswer', () => {
    return universityDao.deleteAnswer(890)
        .then(() => universityDao.findAllAnswers()
            .then(answers => assert(answers.length == 7)))
        .then(() => universityDao.findAnswersByStudent(234)
            .then(answers => assert(answers.length == 3)))
});

test('testDeleteQuestion', () => {
    return universityDao.deleteQuestion(321)
        .then(() => universityDao.findAllQuestions()
            .then(questions => assert(questions.length == 3)))

});

test('testDeleteStudent', () => {
    return universityDao.deleteStudent(234)
        .then(() => universityDao.findAllStudents()
            .then(questions => assert(questions.length == 1)))

});

