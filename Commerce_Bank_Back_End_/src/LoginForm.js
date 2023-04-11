import { waitFor } from '@testing-library/react';
import React, { useState } from 'react';
import { Form, Button, Alert } from 'react-bootstrap';
import { propTypes } from 'react-bootstrap/esm/Image';
import {BrowserRouter, Link } from 'react-router-dom';
import { useHistory } from 'react-router-dom';
import ReactDOM from 'react-dom';
import App from './App';
 
function Login(props) {

  const[account, setAccount] = useState({
    username: '',
    password:'',
    authorized: '',
  });

  const history = useHistory();

  const submitAccount =(e)=>{
    e.preventDefault();
    fetch("http://localhost:8081/login", {
      method:"POST",
      headers:{
        "Content-Type" : "application/json"
      },
      body: JSON.stringify(account)
    }) 
    .then(res => res.json())
    .then(data => {
      setAccount(data);
      if (data.authorized == "true") {
        ReactDOM.render(
          <React.StrictMode>
            <BrowserRouter>
            <App/>
            </BrowserRouter>
          </React.StrictMode>,
          document.getElementById('root')
        );
        alert("Welcome " + account.username + "!");
      } else {
        alert("Incorrect username or password");
      }
      });
  }
  
  const changeValue=(e)=>{
    console.log(e);
    setAccount({
     ...account, [e.target.name]:e.target.value
    });
    console.log(e.target.name + " name "  );
    console.log(e.target.value + " value " );
  }

  return (
    <div>

<Form onSubmit = {submitAccount}>
  <Form.Group controlId="formBasicEmail">
    <Form.Label>Username: </Form.Label>
    <Form.Control type="text" placeholder="Enter username" onChange = {changeValue} name="username" />
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label>Password: </Form.Label>
    <Form.Control type="text" placeholder="Enter password" onChange = {changeValue} name="password"/>
  </Form.Group>

  <Button variant="primary" type="submit">
    Submit  
  </Button>
</Form>

    <div className="text-center">
                Username: {account.username}
                <br></br>
                Password: {account.password}
                <br></br>
                Authorized: {account.authorized}
    </div>

    <Link to={{pathname: "/Result", state: {account}}}>
   <button>Go to my other page</button>
   </Link>
    </div>

  );
}

export default Login;