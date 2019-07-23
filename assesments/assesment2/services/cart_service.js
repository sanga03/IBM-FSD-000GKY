email_class =require('./emailservices').Email;
update_product = require('./products').update_products
emailz = new email_class()
class cart_class{
   constructor(){
    this.products=[]
   }
    _addtocart(productz){
       let flag =true
        this.products.forEach((pr)=>{
            if(pr.id==productz.id){
                flag = false
            }
        })
        if(flag){
        this.products.push(productz);
        return 1;
        }
    }
    _displaycart(){
        return this.products;
    }
    refine(){
        this.products = this.products.filter(el=>el.id !== null);
    }
    _updatecart(id,sign){
       for(let i=0;i< this.products.length;i++){
           if(this.products[i].id==id){
               if( sign =='p'){
                   this.products[i].qty +=1;
                   
               }else
               this.products[i].qty -=1;
           if(this.products[i].qty==0){
               this.products[i].name=null;
               this.products[i].id=null;
               this.refine()
           }
           
            }
           
        }
    }

    _sendMail(to_email){
        console.log('hey')
           let html_body ='<table>'
           let total_price =0;
            this.products.forEach(pr=>{
              let  tp=pr.price*pr.qty;
                total_price+=tp;
               html_body += `
               <head>
               <style>
               th, td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
                color: #265050;
                font-family:Arial, Helvetica, sans-serif;
                font-size: 20px;
                border :1px solid #6b7b96;
                } 
               </style>
               </head>
               <tr><td>Name ${pr.name}
               </td><td>
                <img src=${pr.src}  width="200" height="350"></td>
                <td> Qty: ${pr.qty}</td>
                <td> price:${pr.price}</td>
                <td> total price:${tp}</td>
                </tr>
                `
               let resul = update_product({
                    id:pr.id,
                    name:pr.name,
                    price:pr.price,
                    src:pr.src,
                    qty:pr.qty,
                    category:pr.category
                })
                // console.log(resul);
            })
            html_body +=`</table> 
            <br>
            total price:${total_price}
            `
            // emailz.email_send(to_email,html_body);
         
            
    }
}

module.exports={
    cart : new cart_class()
}