let emap = new Map()
emap.set("k","val");
emap.set("k2","lion");
emap.set("k3","tiger");
console.log(emap)
emap.delete('k');
console.log(emap)
// emap.set(null,"null one");
emap.set(null,null);
for(let[key,val] of emap.entries()){
    console.log(`key : ${key} val:${val}`);
}

for(keys of emap.keys()){
    console.log(`key: ${keys}`);
}

const emps = [
    {
        id : 1,
        name : 'Ram',
        email: 'ram@gg.com',
        organization: 'IBM'
    },
    {
        id : 2,
        name : 'Shyam',
        email: 'shyam@gg.com',
        organization: 'IBM'
    },
    {
        id : 3,
        name : 'Gabbar',
        email: 'gabbar@gg.com',
        organization: 'CTS'
    },
    {
        id : 4,
        name : 'Adams',
        email: 'adam@gg.com',
        organization: 'LnT'
    },
    {
        id : 5,
        name : 'John',
        email: 'john@gg.com',
        organization: 'Target'
    }
];


// map fuction
mapsa = emps.map((e)=>{
    return{
        'uname':e.name,
        'euid':`${e.id}0${e.email}`
    }
} );
console.log(mapsa);
console.log(emps);

let msgs=['hello',['hi','jjai'],[['jj'],['sad'],['kjhad']],['hero']];
msgs.flatMap(m=>{
    return m;
}).forEach(element => {
    console.log(element);
});
window.open("https://google.com");
console.log(Boolean(10>9));