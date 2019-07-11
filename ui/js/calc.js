class number{
    bufferval1; 
    bufferval2;
    operator1;
    operator2;
    resetz(){
        this.bufferval2=undefined;
        this.bufferval1=undefined;
        this.operator1=undefined;
        this.operator2=undefined;
    }

    perform(){
        
        if(this.operator2=="="){
            this.arth(this.operator2);
           
        }else{
            this.arth(this.operator1);
        }

       
        this.operator1=this.operator2;
        // document.getElementById("buf1").value=this.bufferval1;
    }
    arth(){
         switch(this.operator1){
        case "+":this.bufferval1=this.bufferval1+this.bufferval2;
                console.log("inn +",this.bufferval1);
                 break;
        case "-":this.bufferval1=this.bufferval1-this.bufferval2;
        break;

        case "*":this.bufferval1=this.bufferval1*this.bufferval2;
        break;

        case "/":this.bufferval1=this.bufferval1/this.bufferval2;
        break;
        default:break;
      
    }}
}
let obj = new number();
function onload(){
   document.getElementById("entry").readOnly=true;
}

const setval=(val)=>{
    if(!operator(val))
   { 
       curval = document.getElementById("entry").value;
       value = curval+val;
        document.getElementById("entry").value = value;
}
else{  
        
        if(obj.bufferval1==undefined){
            // console.log("in undefined");
        obj.bufferval1=parseInt(document.getElementById("entry").value);
        console.log(obj.bufferval1);
        obj.operator1=val;
        }else{
            obj.bufferval2=parseInt(document.getElementById("entry").value);
            obj.operator2=val;
            obj.perform();
        }
        
            
    if(val=="="){
        document.getElementById("entry").value=obj.bufferval1;
    }else
    document.getElementById("entry").value='';
}
}


operator=(val)=>{
if(val=="/"||val=="+"||val=="-"||val=="*"||val=="=")
return true;
}

reset =()=>{
   obj.resetz();
   document.getElementById('entry').value='';
//    document.getElementById('buf1').value='';    
}