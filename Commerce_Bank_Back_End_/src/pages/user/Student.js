import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import { propTypes } from 'react-bootstrap/esm/Image';
import { Link } from 'react-router-dom';
 
function Student(props) {

  const[account, setAccount] = useState({
    firstName:'',
    lastName:'',
    ssn:0,
    password:'',
  });


  const changeValue=(e)=>{
    console.log(e);
    setAccount({
     ...account, [e.target.name]:e.target.value  
    });
    console.log(e.target.name + " name "  );
    console.log(e.target.value + " value " );
  }

  const submitAccount =(e)=>{
    e.preventDefault();
    fetch("http://localhost:8081/student", {
      method:"POST",
      headers:{
        "Content-Type" : "application/json"
      },
      body: JSON.stringify(account)
    }) 
    .then(res => res.json())
    .then(data => {
        setAccount(data);
      });
  }

  return (
    <div>
<Form onSubmit = {submitAccount}>
  <Form.Group controlId="formBasicEmail">
    <Form.Label>Lastname</Form.Label>
    <Form.Control type="text" placeholder="Enter lastname" onChange = {changeValue} name="lastName" />
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label>SSN</Form.Label>
    <Form.Control type="text" placeholder="Enter ssn" onChange = {changeValue} name="ssn"/>
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label>Password</Form.Label>
    <Form.Control type="text" placeholder="Enter password" onChange = {changeValue} name="password"/>
  </Form.Group>


  <Button variant="primary" type="submit">
    Submit  
  </Button>
</Form>

    <div className="text-center">
                FirstName: {account.firstName};
                LastName: {account.lastName};
    </div>

    <Link to={{pathname: "/Result", state: {account}}}>
   <button>Go to my other page</button>
   </Link>



    </div>

  );
}

export default Student;
