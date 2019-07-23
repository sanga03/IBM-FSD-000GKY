

    item_id=[]
    onloadz=()=>{
        
        url = "http://localhost:8800/products/all"
        products_all = []
        data='<tr><th>id</th><th>name</th><th>image</th><th>qty</th><th>category</th><th>price</th>'
        fetch(url).then(res=>res.json()).then(products=>{
            products.datas.forEach(element => {
                ez=JSON.parse(element);
                products_all.push(ez)
                item_id.push(ez.id)
                data += `<tr>
                <td>${ez.id}</td>
                <td>${ez.name}</td>
                <td><img src=${ez.src} width="200" height="350" ></td>
                <td>${ez.qty}</td>
                <td>${ez.category}</td>
                <td>${ez.price}</td>
                <td><input type="button" value="add to cart" id="btn${ez.id}"></td>
                </tr>`
            }); 
            table = `<table>
            ${data}    </table>`
            document.getElementById('product-list').innerHTML=table;
            cart_url = "http://localhost:8800/products/tocart"
            item_id.forEach((id)=>{
                $(`#btn${id}`).click(()=>{

                    cart_get =  "http://localhost:8800/cart/getcart"
                    fetch(cart_get).then(resp=>resp.json()).then(resp=>{
                       console.log(resp.datas.length);
                       $('#lblCartCount').html(resp.datas.length);
                })
                    

                    find_url = `http://localhost:8800/products/search/${id}`
                    fetch(find_url).then(res=>res.json()).then(res=>{
                       
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
                        $('#cart').click(()=>{

                       
                            console.log('sd')
                            // console.log('clicked')
                            document.location='cart.html';
                        })

                        })
        
                    })             
                    // console.log(`btn${id}`);

                })
            })
        }) 
    }





