const storeTolocal=()=>{
    let name=document.getElementById("name").value;
    let email=document.getElementById("email").value;
    let org=document.getElementById("org").value;
let flag =0;
if(localStorage.length>0){
    Object.keys(localStorage).forEach((key)=>{
        if(email == key){
            alert("sorry user already found");
            flag=1;
        }
    });
}

if (flag ==0 ){
    localStorage.setItem(email,JSON.stringify([{"name":name,"org":org}]));
}
let rows='';
Object.keys(localStorage).forEach((keys)=>{
// console.log(keys+localStorage.getItem(keys));
item = JSON.parse(localStorage.getItem(keys));
console.log(Object.values(item)[0].name);
if(Object.values(item)[0].name!=''){
rows +=`<tr>
<td> ${Object.values(item)[0].name} </td>
<td> ${keys}</td>
<td> ${Object.values(item)[0].org} </td>
</tr>
`}
});

let table=`
<table>
<tr>
<th> Name </th>
<th> email </th>
<th> Organizarion </th>
</tr>
${rows}
</table>
`
document.getElementById('table-div').innerHTML=table;
}