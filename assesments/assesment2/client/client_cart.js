function onload_checkout(){
    item_id =[]
    url = "http://localhost:8800/cart/getcart"
    // products_all = []
    data=''
    total_price=0;
    fetch(url).then(res=>res.json()).then(products=>{
        products.datas.forEach(element => { 
            ez=element;
            tp = ez.price*ez.qty;
            total_price+=tp;
            console.log(element);
            // products_all.push(ez)
            console.log(ez.name)
            item_id.push(ez.id)
            data += `<tr>
            <td>${ez.id}</td>
            <td>${ez.name}</td>
            <td><img src=${ez.src}  width="200" height="350"></td>
            <td><input type="button" value="-" id="btn${ez.id}-"></td>
            <td>${ez.qty}</td>
            <td><input type="button" value="+" id="btn${ez.id}plus"></td>
            <td>${ez.category}</td>
            <td>${ez.price}</td>
            <td>${tp}</td>
            </tr>
         
            
            `
        }); 
        table = `<table>
        ${data}    </table>
        <p> total price ${total_price}</p>

        <p>
        <input type="email" id="mail">
        <input type="button" value="checkoutz" id="checkout">
        `
        document.getElementById('cart-list').innerHTML=table;


        item_id.forEach((id)=>{
                     
               $(`#btn${id}-`).click(()=>{
                update_url = `http://localhost:8800/cart/updatecart/${id}/-`
                fetch(update_url).then(res=>res.json()).then(res=>{
                        console.log(res);
                })
                    console.log('$(`#btn${id}-`).click(()=>{})')
                    
            //   location.reload()
              onload_checkout()
            })
             $(`#btn${id}plus`).click(()=>{
                update_url = `http://localhost:8800/cart/updatecart/${id}/p`
                fetch(update_url).then(res=>res.json()).then(res=>{
                    console.log(res);
                //    location.reload()
                   onload_checkout()
            })
                console.log('$(`#btn${id}+`).click(()=>{})')
            })
      
      
            

        })

        $('#checkout').click(()=>{
            console.log('heu');
            let email = document.getElementById('mail').value;
            mail_url=`http://localhost:8800/cart//sendmail/${email}`
            fetch(mail_url).then(res=>{
                console.log("success")
            });
    })


})
}
