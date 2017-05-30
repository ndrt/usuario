var pg = require('pg');

var dbparams={
    host : 'localhost',
    port : '5432',
    user : 'postgres',
    password : 'avatar',
    database : 'idioma',
};

var client = new pg.client(dbparams);
client.connect();

client.query("SELECT * FROM traslada",function(error, result){
    console.log(result.rows[0].campo_tabla);
}
console.log(error);             
);