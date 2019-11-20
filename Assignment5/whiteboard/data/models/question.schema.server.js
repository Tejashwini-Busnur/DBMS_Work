const mongoose = require('mongoose');
const multipleChoiceSchema = require('./multipleChoice.schema.server');
const trueFalseSchema = require('./trueFalse.schema.server');
const questionSchema = mongoose.Schema({
        _id: Number,
        question: String,
        points: Number,
        questionType: {type: String, enum: ["MULTIPLE_CHOICE", "TRUE_FALSE"]},
        multipleChoice: multipleChoiceSchema,
        trueFalse: trueFalseSchema
    },
    {collection: 'question'});
module.exports = questionSchema;