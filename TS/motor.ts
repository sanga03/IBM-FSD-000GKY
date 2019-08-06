class motors<T>{
    id:number
    no_wheels:number
    tank_size:number
    constructor(id,no,tnk){
        this.id=id;
        this.no_wheels=no;
        this.tank_size=tnk;
    }
    get_motor_type():string{
        if(this.no_wheels==4){
            return 'car'
        }else if(this.no_wheels==2){
            return 'bike'
        }else{
            return 'havy vihicles'
        }
    }
}

interface Bike{
    abs:boolean
    cc:number
}
class bikes extends motors<Bike> implements Bike{
    abs
    cc
    constructor(id,no,tnk,abs,cc){
        super(id,no,tnk);
        // this.abs=abs;
        // this.cc=cc;
    }
}

let bb =new bikes(1,2,21,"true",23);
console.log(bb.get_motor_type())
console.log(bb.abs)