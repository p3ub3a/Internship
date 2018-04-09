//importing the express modules to the app
var express = require("express");
var app = express();
var bodyParser = require('body-parser');
var cors = require('cors');
var fs = require('fs');

var json;

// add middleware
app.use(bodyParser.urlencoded({ extended: false }));

//cross origin request sharing
var corsOptions = {
  "origin": "https://localhost:3000",
  "methods": "GET,HEAD,PUT,PATCH,POST,DELETE",
  "preflightContinue": true,
  "optionsSuccessStatus": 204
};

app.use(cors(corsOptions));

app.post("/addItem", function(req, res) {
  console.log("Got the list!" + req.body["list"]);

  json = req.body["list"];
  fs.writeFile('ItemList.json', json, 'utf8', function (err) {
    if (err) {
        return console.log(err);
    }

    console.log("The file was saved!");
  });

  res.sendStatus(200);
});

app.listen(process.env.PORT || 3001, function() {
    console.log('Server started...');
});
