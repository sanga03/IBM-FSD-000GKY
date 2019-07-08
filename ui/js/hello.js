console.log('hello world!');
document.write("WElcOME To JS!!!<br>");

var uid = 12;
console.log("uid is ",uid);
uid = "sana"
console.log(`uid is ${uid}`);
// let vals=[14,"hello"]
// document.write(vals[2])

// let user1{
// 	id=1,
// 	name:"sanga"
// }


// let user2{
// 	id=2,
// 	name:'sanga'
// 	}
// let users
let m=60;
let e =40;
let c = 90;
let marks=m+e+c;
if(m<60 || e<60 || c <60){

  document.write("sorry you have failed ");
  	if(m<60){
  		 document.write("in maths <br>");
  	}
  	if(e<60){
  		 document.write("in english<br>");
  	}if(c<60){
  		 document.write("in computer science");
  	}
}else if(marks<240){
    document.write("passed with good marks");
}else{
   document.write("passed with distiction marks");
}



var even = [2,3,5,2];
even.push(12);

var od = [21,3,13,4,12,4,23,45,234,4643]
od=od.concat(even);
console.log(od);

// for loop
// for (var i = 10; i >= 0; i--) {
// 	console.log(i);
// 	}
//  fibonacci number
a=1;
b=1;
console.log(1);
console.log(1);
for(var i =a+b;i<100;i=a+b){
	console.log(i);
	var t=a;
	a=b;
	b= t+a;
}

// for in loop
var messages=['hello','WElcOME','dafd'];
for(let m of messages){
	console.log(m);
}

let a1={
	onme:"as it is",
	ibs:21
};
console.log(Object.keys(a1));



