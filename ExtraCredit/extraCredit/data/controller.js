const ecDao = require("./ec")

module.exports = function (route) {
    route.post('/api/:table', function (req, res) {
        var tableData = req.params.table;
        ecDao.createTable(req.body, tableData, function (doc) {
            res.json(doc);
        });
    })
        .get('/api/:table', function (req, res) {
            var tableData = req.params.table;
            ecDao.findById(tableData, {}, function (docs) {
                res.json(docs);
            });
        })
        .get('/api/:table/:id', function (req, res) {
            var tableData = req.params.table;
            var id = req.params.id;
            ecDao.findById(tableData, {_id: id}, function (doc) {
                res.json(doc);
            });
        })
        .delete('/api/:table', function (req, res) {
            var tableData = req.params.table;
            ecDao.deleteAll(tableData, function (doc) {
                res.json(doc);
            });
        })
        .put('/api/:table/:id', function (req, res) {
            var tableData = req.params.table;
            var id = req.params.id;
            ecDao.updateTable(tableData, id, req.body, function (doc) {
                res.json(doc);
            });
        })
        .delete('/api/:table/:id', function (req, res) {
            var tableData = req.params.table;
            var id = req.params.id;
            ecDao.deleteById(tableData, id, function (doc) {
                res.json(doc);
            });
        });

}
