const login=()=>{
    const user = document.getElementById('name').value;
    const pass = document.getElementById('pass').value;
    url=`http://localhost:8800/login?user=${user}&pass=${pass}`
    fetch(url).then((resp)=>resp.json()).then((resp)=>{
        console.log(resp);
        // console.log(resp.text());
        // document.getElementById('tt')=resp;
        if(resp.status != 0){
            document.location('Home.html');
        }else{
            alert("invalid User");
        }
        
    })
}