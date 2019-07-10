const animals = [
    {
        "name": "cat",
        "size": "small",
        "weight": 5
    },
    {
        "name": "dog",
        "size": "small",
        "weight": 10
    },
    {
        "name": "lion",
        "size": "medium",
        "weight": 150
    },
    {
        "name": "elephant",
        "size": "big",
        "weight": 5000
}];
let animal_names=animals.map((animal)=>{
    return animal.name;
})
let weight=animals.reduce((weights,animal)=>{
    return weights += animal.weight;
},0);

let weight1=animals.reduce((w1,w2)=>{
    return w2.weight+w1;
},0);
console.log(weight1);
// animals.reduce()
console.log(animal_names);
console.log(weight);
