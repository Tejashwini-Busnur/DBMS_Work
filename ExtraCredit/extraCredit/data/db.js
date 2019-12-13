module.exports = function () {
    const mongoose = require('mongoose');
    mongoose.connect('mongodb://localhost:27017/extraCredit', {
        useNewUrlParser: true,
        useUnifiedTopology: true
    });
    var express = require('express');
    var route = express();
    var bodyParser = require('body-parser');
    route.use(bodyParser.urlencoded({extended: false}));
    route.use(bodyParser.json());
    const ecController = require('./controller');

    ecController(route);
    route.listen(3000, () => {
        console.log("Server running")
    });

};
