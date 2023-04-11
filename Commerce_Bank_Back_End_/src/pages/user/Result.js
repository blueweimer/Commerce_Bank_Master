import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import { Form, Button } from 'react-bootstrap';

 
function Result(props) {


  const[letterNum, setletterNum]=useState(0);

  const location = useLocation();
  const {account} =  location.state;
  
  const countLetters =(e)=>{
    e.preventDefault();
    const numLetters = account.lastName.length;
    setletterNum(numLetters);

  }

  return (
    
    <div>

    <div className="text-center">
                FirstName: {account.firstName};
                LastName: {account.lastName};
                SSN: {account.ssn};
    </div>


    <Form onSubmit = {countLetters}>
        <Button variant="primary" type="submit">
         How many letters in the lastname.  
         </Button>
    </Form>


    <p> letterNum: {letterNum};</p>

    </div>

  );
}

export default Result;
