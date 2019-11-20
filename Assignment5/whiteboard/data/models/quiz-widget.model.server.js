const mongoose = require('mongoose');
const quizWidgetSchema = require('./answer.schema.server');
module.exports = mongoose.model('QuizWidget',quizWidgetSchema);