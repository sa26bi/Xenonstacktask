import {React,useState} from 'react';

import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.css';
import { Link } from 'react-router-dom';
import { newUser } from './auth';
export default function SigninForm() {
    const [UserName,setUsername]=useState(" ");
    const [Passwords,setPasswords]=useState(" ");
    const data={UserName,Passwords};
    const handleSubmit=async(e)=>{
        e.preventDefault();
        window.location.reload(false);
        console.log(data);
        let response=await newUser(data);
        console.log(response);
    }
  return (
    <div className='container'>
    
    <Container className="small-container">
      {/* <Helmet> */}
        <title>Sign In</title>
      {/* </Helmet> */}
      <h1 className="my-3">Sign In</h1>
      <Form>
        <div className='email'>
        <Form.Group className="mb-2" controlId="email">
          <Form.Label>Email</Form.Label>
          <Form.Control type="email"value={UserName} 
                    onChange={(e)=>{setUsername(e.target.value)}} required/>
        </Form.Group>
        </div>
        <Form.Group className="mb-2" controlId="password">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" value={Passwords} 
                    onChange={(e)=>{setPasswords(e.target.value)}} required />
        </Form.Group>
        <div className="mb-3">
          <Button type="submit" onClick={handleSubmit}>Sign In</Button>
        </div>
        <div className="mb-3" >
          Have an account?{' '}
          
          <Link to={`/`}>login</Link>
        </div>
      </Form>
    </Container>
    </div>
  );
  
}

