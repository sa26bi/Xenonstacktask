
import React from 'react';

import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.css';
import { Link } from 'react-router-dom';
export default function LoginForm() {
  return (
    <div className='container'>
    <Container className="small-container">
      {/* <Helmet> */}
        <title>Log In</title>
      {/* </Helmet> */}
      <h1 className="my-3">Log In</h1>
      <Form>
        <div className='email'>
        <Form.Group className="mb-2" controlId="email">
          <Form.Label>Email</Form.Label>
          <Form.Control type="email" required />
        </Form.Group>
        </div>
        <Form.Group className="mb-2" controlId="password">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" required />
        </Form.Group>
        <div className="mb-3">
          <Button type="submit">Login In</Button>
        </div>
        <div className="mb-3" >
          New customer?{' '}
          
          <Link to={`/signup`}>Create your account</Link>
        </div>
      </Form>
    </Container>
    </div>
  );
  
}

