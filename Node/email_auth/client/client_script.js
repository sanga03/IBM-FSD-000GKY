onloadz=()=>{

    $('#btnSubmit').click(()=>{
        name = $('#name').val()
        phone = $('#phone').val()
        email = $('#email').val()
        console.log(email)
        // console.log(name)
        url="http://localhost:8800/email_auth/send"
        fetch(url,{
            method:'post',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
              
            },
            body:JSON.stringify({
                name:name,
                phone:phone,
                email:email
            })
        }).then(res=>res.json()).then(res=>{
            console.log(res)
        })
    })


}