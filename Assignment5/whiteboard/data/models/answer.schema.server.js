const mongoose = require('mongoose');
const studentSchema = require('./student.schema.server');
const questionSchema = require('./question.schema.server');
const answerSchema = mongoose.Schema({
    _id: Number,
    trueFalseAnswer: Boolean,
    multipleChoiceAnswer: Number,
    student: {
        type: mongoose.Schema.Types.Number,
        ref: 'StudentModel'
    },
    question: {
        type: mongoose.Schema.Types.Number,
        ref: 'QuestionModel'
    }
}, {collection: 'answer'});
module.exports = answerSchema;