
  const emps=[
    {
        id:1,
        name: "sangamesh",
        email:"sangu@a.com"
    },
    {
        id:2,
        name: "sangu",
        email:"sangu@a.com"
    },
    {
        id:3,
        name: "maru",
        email:"sangu@a.com"
    },
    {
        id:4,
        name: "sanjay",
        email:"sangu@a.com"
    }
];
const loaddata =()=>{
  
    let rows=' ';
    emps.forEach((employee)=>{
        rows+=` 
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name} </td>
            <td>${employee.email}</td>
        </tr>
    `
    });
let table=` <table>
<tr>
    <td>S no</td>
    <td>name </td>
    <td>email</td>
</tr>
${rows}
</table>`
document.getElementById('table-div').innerHTML=table;
}


const findbyname=()=>{
    // alert("hey");
    let namez = document.getElementById('org').value;
    // alert(name);
    console.log(emps);
	console.log(emps.find(()=>{
        return emps.name == namez;
    }));
    // console.log(ee);
    // ee.forEach((e)=>{
    //     // alert(e);
    //     console.log(e);
    // });
}

const findbyid=()=>{
    
}