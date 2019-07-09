// console.log('hello world!');
// document.write("WElcOME To JS!!!<br>");

// var uid = 12;
// console.log("uid is ",uid);
// uid = "sana"
// console.log(`uid is ${uid}`);
// // let vals=[14,"hello"]
// // document.write(vals[2])

// // let user1{
// // 	id=1,
// // 	name:"sanga"
// // }


// // let user2{
// // 	id=2,
// // 	name:'sanga'
// // 	}
// // let users
// let m=60;
// let e =40;
// let c = 90;
// let marks=m+e+c;






// var even = [2,3,5,2];
// even.push(12);

// var od = [21,3,13,4,12,4,23,45,234,4643]
// od=od.concat(even);
// console.log(od);

// // for loop
// // for (var i = 10; i >= 0; i--) {
// // 	console.log(i);
// // 	}
// //  fibonacci number
// a=1;
// b=1;
// console.log(1);
// console.log(1);
// for(var i =a+b;i<100;i=a+b){
// 	console.log(i);
// 	var t=a;
// 	a=b;
// 	b= t+a;
// }

// // for in loop
// var messages=['hello','WElcOME','dafd'];
// for(let m of messages){
// 	console.log(m);
// }

// let a1={
// 	onme:"as it is",
// 	ibs:21
// };
// console.log(Object.keys(a1));


function check_marks() {
	
	let m = document.getElementById('mat');
	let e = document.getElementById('eng');
	let c = document.getElementById('cse');
	m= m.value;
	e=e.value;
	c=c.value;
	let marks=parseInt(m)+parseInt(c)+parseInt(e); 	
if(m<60 || e<60 || c <60){

  let mm= "sorry you have failed ";
  	if(m<60){
  		 mm +="in maths ,";
  	}
  	if(e<60){
  		mm +="in  english ,";
  	}if(c<60){
  		 mm +="in computer science";
  	}
	  alert(mm);
	 
}else if(marks<240){
    alert("passed with good marks");
}else{
   alert("passed with distiction marks");
}
	let tbl = `<table><tr><th>subject name</th><th>max marks</th><th>marks scored</th></tr>
				<tr><td>english</td><td>100</td><td>${e}</td></tr>
				<tr><td>mathematics</td><td>100</td><td>${m}</td></tr>
				<tr><td>computer science</td><td>100</td><td>${c}</td></tr>
				<tr><td>total</td><td>300</td><td>${parseInt(m)+parseInt(c)+parseInt(e)}</td></tr>
				
	</table>`
	document.getElementById("table").innerHTML=tbl;
}
