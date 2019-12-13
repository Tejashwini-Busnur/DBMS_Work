var schema = new mongoose.Schema({}, {bool: false});

var findById = function (table, predicate, fetch) {
    var Model = mongoose.model('Model', schema, table);
    Model.find(predicate).exec(function (error, docs) {
        fetch(docs);
    });
};
var createTable = function (doc, table, fetch) {
    var Model = mongoose.model('Model', schema, table);
    Model.create(doc, function (error, doc) {
        fetch(doc);
    });
};

var updateTable = function (table, id, alter, fetch) {
    var Model = mongoose.model('Model', schema, table);
    Model.update({_id: id}, {$set: alter}, function (error, doc) {
        fetch(doc);
    });
};

var deleteAll = function (table) {
    var Model = mongoose.model('Model', schema, table);
    Model.deleteMany(function (error, doc) {
    });
};

var deleteById = function (table, id, fetch) {
    var Model = mongoose.model('Model', schema, table);
    Model.findByIdAndRemove(id, function (error, doc) {
        fetch(doc);
    });
};

module.exports = {createTable, findById, updateTable, deleteById, deleteAll}
