import axios from 'axios';
import { Button } from 'bootstrap'
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'


export default function ViewUser() {

    const[user,setUser]=useState({
        name:"",
        email:"",
        password:"",
        fileName:""
    })

    const {id}=useParams();

    useEffect(()=>{

        loadUser()

    },[])

    const loadUser=async()=>{
        const result=await axios.get(`http://localhost:8080/user/${id}`)
        console.log(result)
        setUser(result.data)
    }
  return (
    <div className="Container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">View User Details</h2>

          <div className="caed">
            <div className="card-header">
                Details of user Id:
                {user.id}

                <ul className="list-group list-group-flush">
                    <li className="list-group-item">
                        <b>Name:</b>
                        {user.name}
                    </li>
                    <li className="list-group-item">
                        <b>Email:</b>
                        {user.email}
                    </li>
                    <li className="list-group-item">
                        <b>Password:</b>
                        {user.password}
                    </li>
                    <li className="list-group-item">
                        <b>file:</b>
                        {user.fileName}
                    </li>
                    
                </ul>
            </div>
          </div>

          <Link className="btn btn-primary my-2" to={"/"}>Back to Home</Link>
        </div>
    </div>
    </div>
  )
}
