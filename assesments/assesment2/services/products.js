const pdb = require('../db/products').static_products
all_products=[]

class products{
    constructor(id,name,price,src,qty,category){
        this.id = id;
        this.name=name;
        this.price=price;
        this.src=src;
        this.qty=qty;
        this.category=category;
    }
    get_detail(){
       return JSON.stringify({
            id:this.id,
            name:this.name,
            price:this.price,
            src:this.src,
            qty:this.qty,
            category:this.category
        })
    }

   

}

function add_all_products_once(){
    pdb.forEach(element => {
        data_obj = new products(element.id,element.name,element.price,element.src,element.qty,element.category);
        // console.log(data_obj.get_detail())
        all_products.push(data_obj.get_detail())
    });
    return all_products;
}

function return_products(){
    return all_products;
}
function serach_detail(id){
    // console.log(id);
    // console.log(all_products)
  return  all_products.find((element)=>{
      ele= JSON.parse(element);
    //   console.log(id,ele.id)
       return  parseInt(id) == parseInt(ele.id)
    })
}

module.exports={
    add_all_products_once,
    all_products,
    return_products,
    serach_detail
}