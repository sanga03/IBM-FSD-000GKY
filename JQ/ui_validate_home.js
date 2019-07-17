let flag=false;

$(document).ready(()=>{
    flag=false;
        $('#top-menu').menu({
            menu:'collapse'
        });
        $('#tabs').tabs()

    $.validator.addMethod('emailValidator',(val)=>{
         let reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
         return reg.test(val);
    })

    $.validator.addMethod('passValidator',(val)=>{
        let reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
        return reg.test(val);
    })
    $('#lsubmit').click(()=>{
         
        $('#login-form').validate({
           rules:{
                email_log:{
                required:true,
                emailValidator:true
                },
                pass:{
                    required:true,
                    passValidator:true
                }
            },
           messages:{
               email_log:'enter valid email',
               pass:'enter valid Password(min 8 char combination of small, upper and spacial character'
           }

        })

        
        console.log("heu");
        
        let users = new Map()
        Object.keys(localStorage).forEach((email)=>{
                users.set(email,localStorage.getItem(email));
        })
        console.log(users);
        // var name = readline();
        // alert($('#email_log').val());
        users.forEach((email,Map)=>{
            if(users.has($('#email_log').val())){
                // alert('Hi');
                if($('#pass').val()==JSON.parse(users.get($('#email_log').val()))['password']){
                    // alert('Login Success');
                    flag=true;
                    Log();
                    window.location.replace('new_log.html');
                }
                // alert(JSON.parse(users.get($('#email_log').val()))['password']);
            }
        })
    })
    $('#rsubmit').click(()=>{
    $('#reg-form').validate({
        rules:{
            email_reg:{
                required:true,
                emailValidator:true
            },
            pass_reg:{
                required:true,
                passValidator:true
            },
            repass_reg:{
                required:true,
                passValidator:true
            },
            name:'required',
            phone:'required'

        },
        messages:{
            email_reg:'enter valid email',
            pass_reg:'enter valid Password(min 8 char combination of small, upper and spacial character',
            repass_reg:'enter valid Password(min 8 char combination of small, upper and spacial character'
        }
    
})
let userMap = new Map();
    userMap.set($('#email_reg').val(),{'name':$('#name').val(),'phone':$('#phone').val(),'password':$('#pass_reg').val()})
    // alert("hi");
//   alert( document.getElementById('#email_reg').value);
    alert($('#email_reg').val());
    localStorage.setItem($('#email_reg').val(),JSON.stringify(userMap.get($('#email_reg').val())))
    // localStorage.setItem("sangu32984u",document.getElementById('email_reg').value);

// alert($('#email_reg').val());
   })
})

// const Reg=()=>{
//     // let userMap = new Map();
//     // userMap.set($('email_reg').val(),{'name':$('name').val(),'phone':$('phone').val(),'password':$('pass_reg').val()})
//     // alert("hi");
//     // document.getElementById('email_reg').value="Hell";
//     alert($('email_reg').val());
//     // localStorage.setItem($('email_reg').val(),JSON.stringify(userMap.get($('email_reg').val())))
//     // localStorage.setItem("sangu32984u",document.getElementById('email_reg').value);
// }
const Log=()=>{
    if(flag){
        alert("success");
        // window.location="https://developer.mozilla.org/en-US/docs/Web/API/Document/location";
    }
}