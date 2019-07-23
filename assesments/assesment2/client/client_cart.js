
function onload_checkout(currency_type){
    
    item_id =[]
    url = "http://localhost:8800/cart/getcart"
    data=`<tr><th>id</th><th>name</th><th>image</th><th>qty</th><th>category</th>
    <th>
    <select class="currency" id="currency_id">
    <option value="r">Rupee</option>
    <option value="d">Doller</option>
    <option value="e">Euro</option>
</select>
    </th>
    <th>total price</th>`
   
    total_price=0;


    fetch(url).then(res=>res.json()).then(products=>{
        products.datas.forEach(element => { 
            ez=element;
            console.log(element);
            // products_all.push(ez)
            console.log(ez.name)
            item_id.push(ez.id)
            
            price=0;
            if(currency_type=="r"){
                price=ez.price;
            }else if(currency_type=='d'){
                price=0.014*ez.price;
            }else 
            price = 0.013*ez.price;
            tp = price*ez.qty;
            total_price+=tp;
            data += `<tr>
            <td>${ez.id}</td>
            <td>${ez.name}</td>
            <td><img src=${ez.src}  width="200" height="350"></td>
            <td>
            <input type="button" value="-" id="btn${ez.id}-">
            ${ez.qty}
            <input type="button" value="+" id="btn${ez.id}plus"></td>
            <td>${ez.category}</td>
            <td>${price}</td>
            <td>${tp}</td>
            </tr>
            `
        }); 
        

        data +='</table></fieledset>'
        table = `
        <fieldset><legend>cart</legend>
        <table>
        ${data}    
        <p> total price ${total_price}</p>

        <p>
        <input type="email" id="mail">
        <input type="button" value="checkoutz" id="checkout">
        `
        document.getElementById('cart-list').innerHTML=table;

        if(currency_type=='r')
        document.getElementById("currency_id").options.selectedIndex = 0;
        else if(currency_type == 'd')
        document.getElementById("currency_id").options.selectedIndex = 1;
        else
         document.getElementById("currency_id").options.selectedIndex = 2;
    
         $("select.currency").change(function(){
            c_type =$(this).children("option:selected").val();
            onload_checkout(c_type)
            
        })
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


$('#search').click(( )=>{
    searchitem = $('#searchbar').val()

})



$(function(){
    console.log('anonynm called');
    var productsz = []
    url = "http://localhost:8800/products/all"
fetch(url).then(res=>res.json()).then(products=>{
    all_elemets=[]
    products.datas.forEach(element => {
        
        ez=JSON.parse(element);
        all_elemets.push(ez)
        productsz.push(ez.name,ez.category)
        $( "#searchbar" ).autocomplete({
            source: productsz
          });
        
    })
        $('#searchbar').change(()=>{
            console.log( $('#searchbar').val(),"changed")
            contesnt ='<table>'
            to_display=[]
            all_elemets.forEach((ez)=>{
                if(ez.name == $('#searchbar').val() ){
                    to_display.push(ez)   
                }
                else if(ez.category == $('#searchbar').val()){
                    to_display.push(ez)
                }
            })

            to_display.forEach((ez)=>{
                contesnt+=`
                <tr>
                <td>${ez.id}</td>
            <td>${ez.name}</td>
            <td><img src=${ez.src} width="200" height="350" ></td>
            <td>${ez.qty}</td>
            <td>${ez.category}</td>
            <td>${ez.price}</td>
            <td><input type="button" value="add to cart" id="btn${ez.id}"></td>
                </tr>
                
                `
            })
            contesnt +='<table>'
            document.getElementById('search-list').innerHTML=contesnt; 
            to_display.forEach((ez)=>{
            $(`#btn${ez.id}`).click(()=>{

                find_url = `http://localhost:8800/products/search/${ez.id}`
                fetch(find_url).then(res=>res.json()).then(res=>{
                    cart_url = "http://localhost:8800/products/tocart"

                    item =JSON.parse(res.mes);
                    item.qty = 1;
                    fetch(cart_url,
                        { headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                      },
                        method:'POST',
                        body:JSON.stringify(item)
                    }).then(resp=>resp.json()).then((resp)=>{
                        console.log('success');
                        console.log(resp);                        })
                        location.reload()
                })             
              
            })
        })

           
            
        })
})

})

  
}

