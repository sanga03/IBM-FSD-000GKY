

    item_id=[]
    onloadz=()=>{
        console.log('here in onload')
        url = "http://localhost:8800/products/all"
        products_all = []
        data=''
        fetch(url).then(res=>res.json()).then(products=>{
            products.datas.forEach(element => {
                
                ez=JSON.parse(element);
                console.log(element);
                products_all.push(ez)
                console.log(ez.name)
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

                    find_url = `http://localhost:8800/products/search/${id}`
                    fetch(find_url).then(res=>res.json()).then(res=>{
                       
                        item =JSON.parse(res.mes);
                        item.qty = 1;
                        console.log(item);
                        fetch(cart_url,
                            { headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                          },
                            method:'POST',
                            body:JSON.stringify(item)
                        }).then(resp=>resp.json()).then((resp)=>{
                            console.log('success');
                            console.log(resp);

                        $('#cart').click(()=>{
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





