import React, { useEffect, useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import { propTypes } from 'react-bootstrap/esm/Image';
 
function UpdateForm(props) {

  const[book, setBook] = useState({
    title:'',
    author:'',
  });

  const id=props.match.params.id;

  const changeValue=(e)=>{
    console.log(e);
    setBook({
     ...book, [e.target.name]:e.target.value  
    });
    console.log(e.target.name + " name "  );
    console.log(e.target.value + " value " );
  }


  useEffect(()=>{ 
    fetch("http://localhost:8080/book/" + id, {method:"GET"})
    .then(res =>res.json())
    .then(res=>{
      setBook(res)});
  },[])


  const submitBook =(e)=>{
    e.preventDefault();
    fetch("http://localhost:8080/book", {
      method:"PUT",
      headers:{
        "Content-Type" : "application/json"
      },
      body: JSON.stringify(book)
    })
    .then(res=>{
        console.log(1,res);
        if(res.status === 201){
          return res.json();
        }else{
          return null;
        }
      })
    .then(res=>{
      console.log(res)
      if(res!==null){
        props.history.push('/login');
      }else{
        alert('fails');
      }
    
    });

  }

  return (
    <div>
       
      <Form onSubmit = {submitBook}>
        <Form.Group controlId="formBasicEmail">
          <Form.Label>Title</Form.Label>
          <Form.Control type="text" placeholder="Enter title" onChange = {changeValue} name="title" value={book.title}/>
        </Form.Group>

        <Form.Group controlId="formBasicEmail">
          <Form.Label>Author</Form.Label>
          <Form.Control type="text" placeholder="Enter Author" onChange = {changeValue} name="author" value={book.author}/>
        </Form.Group>

        <Button variant="primary" type="submit">
          Submit  
        </Button>
      </Form>
    </div>
  );
}

export default UpdateForm;
