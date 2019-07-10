class data{
    constructor(name,email,org){
        this.email=email;
        this.name=name;
        this.org=org;
    }
   static store(email,dataObj){
        let flag =0;
        if(localStorage.length>0){
            Object.keys(localStorage).forEach((key)=>{
                if(email == key){
                    alert("sorry user already found");
                    flag=1;
                }
            });}
            if(flag==0) localStorage.setItem(email,JSON.stringify(dataObj));  
    }
   static display(){
       let rows='';
       if(localStorage.length<=0){
           alert("no user database");
       }
       else{
             Object.keys(localStorage).forEach((key)=>{
               let item = localStorage.getItem(key);
               let dat = JSON.parse(item);
                console.log(dat);
                rows +=`<tr>    <td> ${dat.name} </td>           <td> ${key}</td>            <td> ${dat.org} </td></tr>`
             }) ;
            }
let table=`<table> <tr><th> Name </th><th> email </th><th> Organizarion </th></tr>${rows}</table>`
document.getElementById('table-div').innerHTML=table;
      
   }
}
const onload=()=>{
    data.display();
}
const storeTolocal=()=>{
    let name=document.getElementById("name").value;
    let email=document.getElementById("email").value;
    let org=document.getElementById("org").value;
    let d1= new data(name,email,org);
data.store(email,d1);
data.display();
}
const deleteLocal=()=>{
  let emap =new Map();
    let delemail = document.getElementById("emsearch").value;
    Object.keys(localStorage).forEach((key)=>{
       emap.set(key,localStorage.getItem(key));
        // console.log(key,localStorage.getItem(key));
});
if(emap.has(delemail)){
    emap.delete(delemail);
} else{
alert("id not found");
}
localStorage.clear();
for([key,val] of emap.entries()){
    data.store(key,JSON.parse(val));
}
data.display();
}

const deleteall=()=>{
localStorage.clear();
data.display();
}