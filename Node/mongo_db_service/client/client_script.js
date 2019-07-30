onloadz=()=>{
   
    buttons=[]
    clicks = []
    player_turn=0;
    $('#turn').html(`player Turn:${player_turn+1}`)
    html_content = ''
    for (let i = 0; i < 3; i++) {
        html_content+=`<tr>`
        for (let index = 0; index < 3; index++) {
            html_content+=`<td>
                <input type="button" id="${i}${index}" value="" class="btn btn-outline-dark btn-lg">
            </td>`
            buttons.push(`${i}${index}`)
        }
        html_content +=`</tr>`        
    }

    content = `<table>
    ${html_content}
    </table>

    <input type="button" id="reset" class="btn btn-outline-danger" value="reset">
    `
      document.getElementById('tictac').innerHTML=content;
     get_url='http://localhost:8899/api/tictac/getstatus'
      fetch(get_url).then(res=>res.json()).then(res=>{
        //  console.log(res)
         player_turn=res.result[0].current
        //  console.log('----',res.result[0].current)
        if(player_turn==-1) player_turn=0;
        else player_turn=toggle(player_turn)
        $('#turn').html(`player Turn:${player_turn+1}`)
        // console.log(player_turn,'player turn')
        for(let i=0;i<3;i++){
            for(let j=0;j<3;j++){
            pl=res.result[i*3+j+1].player;
            if(pl==0){
                $(`#${i}${j}`).val('X')
            }else if(pl==1){
                $(`#${i}${j}`).val('O')
            }else{
                $(`#${i}${j}`).val('-')
            }
            }
        }

        buttons.forEach(element => {
            
            $(`#${element}`).click(()=>{
                check_url='http://localhost:8899/api/tictac/checktic'
                fetch(check_url,{
                    method:'POST',
                    body:JSON.stringify({_id:element}),
                    headers:{
                        'Content-Type': 'application/json'
                                }        
                    }).then(res=>res.json()).then(res=>{
                        // console.log('played',res)
                        if(res.played==1){
                            alert('already played')
                        }else{


                            // console.log(element,"got clicked by player",player_turn+1);
                            // console.log( $(`#${element}`).val())
                            // if(clicked_already(element,clicks)){
                                set_url="http://localhost:8899/api/tictac/settic"
                                fetch(set_url,{
                                    method:'POST',
                                    body:JSON.stringify({
                                        id:element,
                                        player:player_turn}),
                                        headers:{
                                            'Content-Type': 'application/json'
                                                    }        
                                        }).then(res=>res.json()).then(res=>{
                                            pl1=[]
                                            pl2=[]
                                            get_url='http://localhost:8899/api/tictac/getstatus'
                                             fetch(get_url).then(res=>res.json()).then(res=>{
                                                // console.log(res)
                                               player_turn=res.result[0].current
                                               for(let i=0;i<3;i++){
                                                   for(let j=0;j<3;j++){
                                                   pl=res.result[i*3+j+1].player;
                                                   id={i:i,j:j}
                                                   if(pl==0){
                                                       pl1.push(id)
                                                       $(`#${i}${j}`).val('X')
                                                       if(check_gameover(pl1)==1){
                                                        alert("game over won by player 1")
                                                    }
                                                   }else if(pl==1){
                                                       pl2.push(id)
                                                       $(`#${i}${j}`).val('O')
                                                       if(check_gameover(pl2)==1){
                                                        alert("game over won by player 2")
                                                    }
                                                   }else{
                                                       $(`#${i}${j}`).val('-')
                                                   }
                                                   }
                                                  
                                               }
                                            
                                               console.log(pl1)
                                            
                                            

                                            console.log("update success")
                                            // console.log(res)
                                            // console.log(player_turn)
                                            // player_turn=display_load()
                                            // console.log(player_turn)
                                            player_turn=toggle(player_turn);
                                            // console.log(player_turn)
                                            $('#turn').html(`player Turn:${player_turn+1}`)
                                            // console.log(`player Turn:${player_turn+1}`)
                                        })
                                    })
                        }
                    })
                
                    
               
        });
    })
})
        $('#reset').click(()=>{
            console.log('reset clicked')
            reset_url="http://localhost:8899/api/tictac/reset";
            fetch(reset_url).then(res=>res.json()).then(res=>{
                console.log(res)
                location.reload()
            })
        })


}
 async function display_load (){
    current_player=-1;
    html_content = ''
     get_url='http://localhost:8899/api/tictac/getstatus'
     await fetch(get_url).then(res=>res.json()).then(res=>{
        //  console.log(res)
        current_player=res.result[0].current
        for(let i=0;i<3;i++){
            for(let j=0;j<3;j++){
            pl=res.result[i*3+j+1].player;
            if(pl==0){
                $(`#${i}${j}`).val('X')
            }else if(pl==1){
                $(`#${i}${j}`).val('O')
            }else{
                $(`#${i}${j}`).val('-')
            }
            }
        }
     })
     return current_player;
    
}

toggle=(content)=>{
    if(content ==0){
        return 1
    }else
     return 0;
}
clicked_already=(ele,all_clicks)=>{
    
   
}



check_gameover=(pl)=>{
    gover=0;
    cond1 = 0;
    cond2 = 0;
    pl.forEach(el=>{
        if(el.i==el.j)
            cond1+=1
        if(el.i+el.j==2)
            cond2+=1
      
       
        
    })
    for (let i = 0; i <3; i++) {
        cond3=0;
        cond4 =0;
        for (let j = 0; j <3; j++) {
            pl.forEach(el=>{
            if(el.i==j && el.j==i){
                cond3 +=1;
            }
            if(el.j==j && el.i==i){
                cond4 +=1;
            }
        })
    }
        
        if(cond3 ==3 || cond4==3){
            gover= 1;
        }
    }
    if(cond1==3 || cond2==3){
        gover =1;
    }

    return gover;
}