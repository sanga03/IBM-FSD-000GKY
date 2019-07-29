mongo = require('mongodb').MongoClient


get_users=(callback)=>{
mongo.connect('mongodb://localhost:27017',(err,conn)=>{
    conn.db('tictac').collection('statsz').find({}).toArray((error,result)=>{
        console.log(result);
       if(!error) callback(error,result);
    })
})
}
settic=(id,player,callback)=>{
    mongo.connect('mongodb://localhost:27017',(err,conn)=>{
      conn.db('tictac').collection('statsz').updateOne({_id:"current"},{$set:{current:player}})
      conn.db('tictac').collection('statsz').updateOne({_id:id},{$set:{player:player}},(rq,rs)=>{
          console.log("updated");
          callback(rq,rs);
      })
    })
}

checkit=(body,callback)=>{
    console.log(body,'body')
    mongo.connect('mongodb://localhost:27017',(err,conn)=>{
    conn.db('tictac').collection('statsz').find({_id:body._id}).toArray((error,result)=>{
        let played=0;
        console.log(result)
        if(!error){
            console.log(result);
            if(result[0].player != -1){
                played=1
            }
            callback(error,played)
        }       
    })
})
}
reset_user=(callback)=>{
    mongo.connect('mongodb://localhost:27017',(err,conn)=>{
    conn.db('tictac').collection('statsz').drop((err,delok)=>{
        if(delok){
            console.log(delok)
            console.log('collection deleted')
        }else{
            console.log(err)
            console.log('collection not deleted')
        }
    })
    // console.log('remove success');
   
    conn.db('tictac').collection('statsz').insertMany(get_content(),(err,res)=>{
        if(!err){
            console.log("insert success");
            callback(err,res)
        }
    })
})
}



get_content=()=>{
    content =[]
    content.push({
        _id:"current",
        current:-1
    })
    for(let i=0;i<3;i++){
        for(let j=0;j<3;j++){
            obj={
                _id:i.toString()+j.toString(),
                player:-1
            }
            content.push(obj)
        }
    }
    console.log(content)
    return content;
}

module.exports={
    get_users,
    reset_user,
    settic,
    checkit
}