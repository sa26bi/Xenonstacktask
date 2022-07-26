
import './App.css';
import LoginForm from './login';
import { BrowserRouter, Switch, Route, Routes } from "react-router-dom";
import SigninForm from './signup _screen';
import Home_screen from './home_screen';
function App() {
  return (
    <div className="App">
    <BrowserRouter>
      <Routes>
         <Route path="/" element={<LoginForm />}/>
         
        <Route path="/signup" element={<SigninForm/>}/>
        <Route path="/homescreen" element={<Home_screen/>}/>
      </Routes>
    </BrowserRouter>
        {/* <LoginForm/> */}
       
     
    </div>
  );
}

export default App;
