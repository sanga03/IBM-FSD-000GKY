const actionlistner = require('events').EventEmitter;
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  })
//var readline = require('readline');
function justify(rq){
    req = JSON.parse(rq);
    if(req.type == "ANIM"){
        console.log(req.id+" is a animal");
    }else if(req.type=="HUM"){
        if(req.age > 17){
            console.log(req.id+" is aadult");
        }else{
            console.log(req.id+" is not an adult");
        }
    }
}
function getAge(min, max) {
    return Math.random() * (max - min) + min;
  }
console.log(Math.round(Math.random(2)))

function makeid(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
 }
 
 function createData(){
    datas=[]
    
    console.log("do you have a tail");
    readline.question('tail?',(name)=>{
        console.log(name);
    });
     typez = ['ANIM','HUM'];
     for(let i=0;i<100;i++){
        dataz = {
            id:makeid(5),
            type:typez[Math.round(Math.random(2))],
            age:Math.round(getAge(10,100))
        }
     
     datas.push(dataz);
 }
 return datas;
}
dataa= createData();
// console.log(dataa);
let emitter = new actionlistner();
emitter.addListener('listen',justify);
dataa.forEach((data)=>{
    emitter.emit('listen',JSON.stringify(data));
})

