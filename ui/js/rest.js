const getUser=()=>{
    let url="https://reqres.in/api/users?page=2";
    fetch(url,{
        method:'GET'}
        ).then((res)=>res.json()).then((result)=>{
        console.log(result.data);
        result.data.forEach(element => {
            
        });
    })
} 


const putUser=()=>{
    let url = "http://dummy.restapiexample.com/api/v1/create";
    fetch(url,{
        method:'POST',
        body:JSON.stringify(
            {name:"sangamesh",salary:"10000",age:"21"}
            )
    }).catch(e=>{
        console.log(e);
    })
}

const updateUser=()=>{
    let url = "http://dummy.restapiexample.com/api/v1/update/6766";
    fetch(url,{
        method:'PUT',
        body:JSON.stringify(
            {name:"sangamesh",salary:"20000",age:"23"}
            )
    }).catch(e=>{
        console.log(e);
    })
}
// getUser();
// putUser();
updateUser();