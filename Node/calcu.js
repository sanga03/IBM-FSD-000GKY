const actionlistner = require('events').EventEmitter;

class Clacul{
    _add(a,b){
        return a+b;
    }
    _diff(a,b){
        return a-b;
    }
    _mult(a,b){
        return a*b;
    }
    _div(a,b){
        return a/b;
    }
}
function passz() {
    console.log("please");
}

class CalculatorListner{

    _execute(request){
        let obja=JSON.parse(request);
        const  obj = new Clacul();
        switch(obja['method']){
            case '+':console.log(obj._add(a,b))
                    break;
            case '-':console.log(obj._diff(a,b))
                break;
            case '*':console.log(obj._mult(a,b))
                    break;
            case '/':console.log(obj._div(a,b))
            break;
            default:break;
        }
    }
}

actionlistner.AddListner()
module.exports={
    calc:Clacul,
    pas :passz
} 