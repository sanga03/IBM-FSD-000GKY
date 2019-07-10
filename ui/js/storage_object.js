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
                rows +=`<tr>    <td> ${dat.name} </td>           <td> ${key}</td>            <td> ${dat.org} </td>
                <td><a href='#' onclick="deleteEmployee('${key}')">Delete</a></td>
                    <td><a href='#' onclick="updateEmployee('${key}')">Update</a></td>
                </tr>`
             }) ;
            }
let table=`  <table> <tr><th> Name <input type="button" value="ascend" onclick="ascend('name')"/> <input type="button" value="desc" onclick="descend("name")/>
</th><th> email <input type="button" value="ascend" onclick="ascend('email')"/> <input type="button" value="desc" onclick="descend("email")/> </th>
<th> Organizarion<input type="button" value="ascend" onclick="ascend('org')"/> <input type="button" value="desc" onclick="descend("org")/> </th></tr>${rows}</table>`
document.getElementById('table-div').innerHTML=table;
      
   }
}
function ascend(val){
 
    let all_Emp_data=[];  
    Object.keys(localStorage).forEach((key)=>{
            all_Emp_data.push(JSON.parse(localStorage.getItem(key)));
        });
        
// console.log(all_Emp_data);
let sorted_emp=[];
    switch (val) {
       
    case "name":
          sorted_emp.push(all_Emp_data.sort((e1,e2)=>{
                if(e1.name >e2.name){return 1}else if(e1.name<e2.name) return -1; else return 0;  
            }));
            break;
    case "email":
        sorted_emp.push( all_Emp_data.sort((e1,e2)=>{
                if(e1.email >e2.email){return 1}else if(e1.email<e2.email) return -1; else return 0;  
            }));
            break;
    case "org":
        sorted_emp.push( all_Emp_data.sort((e1,e2)=>{
            if(e1.org >e2.org){return 1}else if(e1.org<e2.org) return -1; else return 0;  
        }));
        break;
        default:
            break;
    }
    console.log("sorted",sorted_emp[0]);
    localStorage.clear();
    for(emp of sorted_emp[0]){
        console.log("emp",emp);
        localStorage.setItem(emp.email,JSON.stringify(emp));
    }
    data.display();
}

const deleteEmployee=(key)=>{
    localStorage.removeItem(key);
    data.display();
}
const updateEmployee=(key)=>{

//    let ind= Object.keys(localStorage).find((keyz)=>{
//         return keyz==key;
//     });
//     console.log(ind);
    let emptemp;
   Object.keys(localStorage).forEach((keyz)=>{
        if(key==keyz){
            // let tt = 
            emptemp=JSON.parse(localStorage.getItem(keyz));
        }
   });
   document.getElementById("name").value=emptemp.name;
   document.getElementById("org").value=emptemp.org;
   document.getElementById("email").value=emptemp.email;
   console.log(emptemp);

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