
import axios from "axios";
export const newUser=async({UserName,Passwords})=>{
    let data="UserName="+UserName+"&Passwords="+Passwords;
    let response=await axios.post("http://localhost:8084/xenonstack_ass/signin?"+data,{
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }
    });
    return response.data;
}
export const login=async({UserName,Passwords})=>{
    let data="UserName="+UserName+"&Passwords="+Passwords;
    let response=await axios.post("http://localhost:8084/xenonstack_ass/ReiceveServlets?"+data,{
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }
    });
    return response.data;
}