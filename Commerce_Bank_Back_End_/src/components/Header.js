import react from 'react';
import { Button, Container, Nav, Navbar } from 'react-bootstrap';
import {Link} from 'react-router-dom';

 
function App() {
  return (
<>
  <Navbar bg="success" variant="dark">
    <Container>
    <Link to ="/" className = "navbar-brand">Home</Link>

    <Nav className="me-auto">
      <Link to ="/LoanCalculator" className = "nav-link">Loan Calculator</Link>
    </Nav>
    </Container>
  </Navbar>
  <br />
 
 
</>
  );
}

export default App;

