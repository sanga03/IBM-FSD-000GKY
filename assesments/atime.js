
  let subject=["Math","Eng","Cse","Phy","Chem","Stat"];
class trainer{
     slots;
    constructor(name,skills){
        this.name=name;
        this.skills=skills;
        this.slots=[]

    }


    addOne(){
        console.log("hey");
    }
}
class section{
        constructor(sect){
            this.class = sect;
            this.subjects=[
                {  "index":0,
                    "name":"Math",
                  "trainer":"",
                  "slot":0
            },
                {"index":1,
                    "name":"Eng",
                "trainer":"",
                "slot":0
          },
               { "index":2,
                   "name":"Cse",
                "trainer":"",
                "slot":0
          },
                {"index":3,
                    "name":"Phy",
                "trainer":"",
                "slot":0
          },
                {"index":4,
                    "name":"Chem",
                "trainer":"",
                "slot":0
          },
                {"index":5,
                    "name":"Stat",
                "trainer":"",
                "slot":0
          }];
            this.subjslots=[];
            this.trainers;
            this.sessions;
        }
        displayTable(){
           console.log("subjj",this.subjects);
        let temp=[]
            this.subjects.forEach((sub)=>{
                    
                    if(sub["slot"]!=0){
                        console.log("sub",sub);
                        temp.push(sub["slot"]);
                        document.getElementById(`slot${sub["slot"]}`).innerHTML=` <input type="button" value="${sub["name"]} by ${sub["trainer"]}" onclick="setSlot(${sub["slot"]})" >`;    
                    } 
                
            });
        for(let i =1 ; i<7;i++){
           let flag = true;
            temp.forEach((t)=>{
                if(t==i){
                    flag=false;
                }
            })
            if(flag){
                document.getElementById(`slot${i}`).innerHTML=`<input type="button" value="set" onclick="setSlot(${i})" >`;
           
            }
        }

    }
    setTrainer(subj,slot,trainer){
        console.log("subject",subj);
            let index;
                this.subjects.forEach((sub)=>{
                    if( sub["name"]==subj){
                        index = sub["index"];
                        this.subjects[index]["trainer"]=trainer;
                        this.subjects[index]["slot"]=slot;
                        console.log("found",sub);
                    }
                })

    }
}

let all_trainers=[]
let sect ;
let tmpsect;
let asect,bsect;
function onsett(){
    asect= new section("A");
    bsect=new section("B");
}
const classSelect=()=>{
 
    let select = document.getElementById("select");
    let selectVal=select.options[select.selectedIndex].value;
    // if(selectVal=='A')
    //     sect=asect;
    //     else 
    //     sect = bsect;
    
    try {
        if(selectVal=='B'&&sect.name=='A')
            tmpsect=sect;
    } catch (error) {
        console.log(error)
        sect= new section(selectVal);
    }
    try {
        if(selectVal=='A'&&sect.name=='B')
            tmpsect=sect;
    } catch (error) {
        console.log(error)
        sect= new section(selectVal);
    }
    
    
    console.log(selectVal);
    // sect.displayTable();
    let tableDisp=
    `<fieldset id="class-field">
    <legend>class ${selectVal}</legend>
    <table>
        <tr><td id="slot1" >  </td><td id="slot2"></td><td id="slot3" ></td></tr>
        <tr><td id="slot4"></td><td id="slot5"></td><td id="slot6"></td></tr>
    </table>
</fieldset>`;
document.getElementById("classes").innerHTML=tableDisp;
sect.displayTable();

}
const disptr=()=>{
    let tz=''
    all_trainers.forEach((tt)=>{
        tz+=`<tr> <td>${tt.name}</td>
        <td>${tt.skills}</td>
        <td>${tt.slots}</td>
        </tr>
        `
    })
    tt=`<fieldset>
                <legend>all Trainer</legend><table>
                <tr><th>name</th><th>skills</th><th>slots</th>
                    ${tz}
                </table>
                </fieldset>
               
                `
    document.getElementById("displaytr").innerHTML=tt;
}
const displaytrainer=()=>{
    let trainField=`<fieldset>
                <legend>Trainer</legend>
                Name:<input type="text" id="tname"><br><br>
                Skills:
                <br><br>
                 <input type="checkbox"  id="Math" > Math   
                 <input type="checkbox" id="Eng"  >English
                 <input type="checkbox" id="Cse"  >Cse <br>   
                 <input type="checkbox" id="Phy"  >Physics
                 <input type="checkbox" id="Chem" >Chem   
                 <input type="checkbox" id="Stat" >Stat
                 <br>
                 <input type="button" value="add" onclick="addtr()">
            </fieldset>`

            document.getElementById("addtrainer").innerHTML=trainField;
    
}
const setSlot=(slot)=>{
    optionrows='<option>--select--</option>'
    subject.forEach((sub)=>{
        optionrows += `<option>${sub}</option>`;
    })
    let setfield=`
    <fieldset>
    <legend>please choose</legend>
    <select id="subselect" onchange="getSub(${slot})">
    ${optionrows}
    </select>
    </fieldset>
    `
document.getElementById('editclass').innerHTML=setfield;
}

const getSub=(slot)=>{
    let select = document.getElementById("subselect");
    let selectValz=select.options[select.selectedIndex].value;
    console.log("sub select",selectValz);
    trainer_list=getTrainer(slot,selectValz);
    console.log("listz:",trainer_list);
    optionrows=''
    subject.forEach((sub)=>{
        optionrows += `<option>${sub}</option>`;
    })
    trainer_rows=''
    trainer_list.forEach((tn)=>{
        console.log(tn.name);
            trainer_rows+=`<option>${tn.name}</option>`
    })
    let setfield=`
    <fieldset>
    <legend>please choose</legend>
    <select id="subselect" onchange="getSub(${slot})">
    ${optionrows}
    </select>
    <select id="trselect" onchange="getSub(${slot})">
    ${trainer_rows}
    </select>
    <input type="button" value="update" onclick="updateSlot(${slot},'${selectValz}')">
    </fieldset>
    `
document.getElementById('editclass').innerHTML=setfield;
    console.log("after",selectValz);
}

updateSlot=(slot,subj)=>{
    console.log("in update slot",slot,subj);
    let select = document.getElementById("trselect");
    let selectVal=select.options[select.selectedIndex].value;
    sect.setTrainer(subj,slot,selectVal);
    all_trainers.forEach((te)=>{
        if(te.name==selectVal){
            te.slots.push(slot);
        }
    })
    sect.displayTable();

}


getTrainer=(slot,subject)=>{
    console.log(all_trainers);
    ts=[]
    all_trainers.forEach((tn)=>{
        slot_aval = true;
        train_aval=false;
        tn.skills.forEach((skill)=>{
            if(skill==subject){
                    train_aval=true;
                    tn.slots.forEach((slotz)=>{
                         if(slot==slotz){
                            slot_aval = false;
                         }
                    })
                    
            }
        })
        if(slot_aval&&train_aval){
            console.log("available trainer",tn.name);
            ts.push(tn);
        }
    })
        return ts;
}


const addtr=()=>{
        let skills=[]
      
        subject.forEach((sub)=>{
           if( document.getElementById(sub).checked){
                skills.push(sub);
           }
        })
        let name = document.getElementById("tname").value;
        let flag = true;
        all_trainers.forEach((tn)=>{
            if(tn.name == name){
                tn.skills=skills;
                flag = false;

            }
        }) 
        if(flag){
        let newtrainer = new trainer(name,skills);
        console.log(newtrainer.name,newtrainer.skills); 
        all_trainers.push(newtrainer);
        }
        
    }