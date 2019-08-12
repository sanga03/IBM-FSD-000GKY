// [queryParams]="{item_obj:_item_obj|json }"
interface user_structure{
    name:string
    phone:string
    email:string
}

let arr:user_structure[] = new Array()

arr.push({
    name:"sangu",
    phone:'2324',
    email:'asddsa'
})
console.log(arr)