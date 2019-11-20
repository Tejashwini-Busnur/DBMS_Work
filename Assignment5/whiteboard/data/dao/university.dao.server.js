const studentModel = require('../models/student.model.server');
const questionModel = require('../models/question.model.server');
const answerModel = require('../models/answer.model.server');

truncateDatabase = () => Promise.all([
    answerModel.deleteMany({}, (error) => {
        if (error) console.log(error);
    }),
    questionModel.deleteMany({}, (error) => {
        if (error) console.log(error);
    }),
    studentModel.deleteMany({}, (error) => {
        if (error) console.log(error);
    })
]);

CreateStudent = student => studentModel.create(student);
CreateQuestion = question => questionModel.create(question);
CreateAnswer = answer => answerModel.create(answer);

populateDatabase = () => Promise.all([

    CreateStudent({
        _id: 123,
        firstName: "Alice",
        lastName: "Wonderland",
        username: "alice",
        password: "alice",
        gradYear: 2020,
        scholarship: 15000
    }), CreateStudent({
            _id: 234,
            firstName: "Bob",
            lastName: "Hope",
            username: "bob",
            password: "bob",
            gradYear: 2021,
            scholarship: 12000
        }
    ), CreateQuestion({
        _id: 321,
        question: "Is the following schema valid?",
        points: 10,
        questionType: "TRUE_FALSE",
        trueFalse: {isTrue: false}
    }),
    CreateQuestion({
        _id: 432,
        question: "Dao stands for Dynamic Access Object.",
        points: 10,
        questionType: "TRUE_FALSE",
        trueFalse: {isTrue: false}
    }),
    CreateQuestion({
        _id: 543,
        question: "What does JPA stand for?",
        points: 10,
        questionType: "MULTIPLE_CHOICE",
        multipleChoice: {
            choices: "Java Persistence API,Java Persisted Application,avaScript Persistence API,JSON Persistent Associations",
            correct: 1
        }
    }),
    CreateQuestion({
        _id: 654,
        question: "What does ORM stand for?",
        points: 10,
        questionType: "MULTIPLE_CHOICE",
        multipleChoice: {
            choices: "Object Relational Model,Object relative Markup,Object Reflexive Model,Object Relational Mapping",
            correct: 1
        }
    }),
    CreateAnswer({
        _id: 123,
        trueFalseAnswer: true,
        student: 123,
        question: 321
    }),
    CreateAnswer({
        _id: 234,
        trueFalseAnswer: false,
        student: 123,
        question: 321
    }),
    CreateAnswer({
        _id: 345,
        multipleChoiceAnswer: 1,
        student: 123,
        question: 543
    }),
    CreateAnswer({
        _id: 456,
        multipleChoiceAnswer: 2,
        student: 123,
        question: 654
    }),
    CreateAnswer({
        _id: 567,
        trueFalseAnswer: false,
        student: 234,
        question: 321
    }),
    CreateAnswer({
        _id: 678,
        trueFalseAnswer: true,
        student: 234,
        question: 432
    }),
    CreateAnswer({
        _id: 789,
        multipleChoiceAnswer: 3,
        student: 234,
        question: 543
    }),
    CreateAnswer({
        _id: 890,
        multipleChoiceAnswer: 4,
        student: 234,
        question: 654
    })
]);

deleteStudent = studentId => studentModel.deleteOne({
    _id: studentId
})
deleteQuestion = questionId => questionModel.deleteOne({
    _id: questionId
})
answerQuestion = (studentId, questionId, answer) => {
    answer.student = studentId;
    answer.question = questionId;
    return answerModel.create(answer);
}
deleteAnswer = answerId => answerModel.deleteOne({
    _id: answerId
})

findAllStudents = () => studentModel.find()
findStudentById = studentId => studentModel.findById(studentId)
findAllQuestions = () => questionModel.find()
findQuestionById = questionId => questionModel.findById(questionId)
findAllAnswers = () => answerModel.find()
findAnswerById = answerId => answerModel.findById(answerId)
findAnswersByStudent = studentId => answerModel.find({student: studentId}).populate("student").populate("question")
findAnswersByQuestion = questionId => questionModel.find({question: questionId}).populate("student").populate("question")


module.exports = {
    truncateDatabase,
    populateDatabase,
    CreateStudent,
    CreateQuestion,
    CreateAnswer,
    deleteStudent,
    deleteQuestion,
    answerQuestion,
    deleteAnswer,
    findAllStudents,
    findStudentById,
    findAllQuestions,
    findQuestionById,
    findAllAnswers,
    findAnswerById,
    findAnswersByStudent,
    findAnswersByQuestion
}

