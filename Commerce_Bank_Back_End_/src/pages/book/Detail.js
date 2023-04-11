 
import React, { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';
 
function Detail(props) {

const id= props.match.params.id;

const [book, setBook] = useState({
  id:"",
  title:"",
  author:""
});


const deleteBook =()=>{

  console.log("id " +   id)
  fetch('http://localhost:8080/book/'+ id,{
    method:'DELETE',
  })
  
  .then(res=>res.text()
  )

  .then(res=>{
    if(res==='ok'){
      props.history.push("/");
    }else{
    alert('fail');  
    }
  });

}


useEffect(()=>{ 
  fetch("http://localhost:8080/book/" + id, {method:"GET"})
  .then(res =>res.json())
  .then(res=>{
    setBook(res)});
},[])



const updateBook=()=>{
  props.history.push('/update/'+id)

}


  return (
    <div>
        <h1> Book Info. </h1>
        <Button variant="warning" onClick={updateBook}>update</Button>
        {' '}
        <Button variant="danger" onClick={()=>deleteBook()}>delete</Button>
        <hr/>
        <h3>{book.author}</h3>
        <h1>{book.title}</h1>
    </div>
  );
}

export default Detail;
