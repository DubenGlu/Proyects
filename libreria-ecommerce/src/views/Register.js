import React, { useContext, useState } from "react";
import { Button, Form } from "react-bootstrap";

import { colors, fontFamily } from "../constants/constants";
import fondo from "../assets/background1.jpg";
import { UserContext } from "../models/UserContext";
import { useNavigate } from "react-router";

export default function Register() {
    const { user, login, logout } = useContext(UserContext);
    const navigate = useNavigate();
    
    const [dataUser, setDataUser] = useState({ nombre: "", rol: "Cliente", apellido_p: "", apellido_m: "", email: "", contrasena: "" });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setDataUser({ ...dataUser, [name]: value });
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch('http://localhost:4000/test/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dataUser)
        })
            .then(response => response.json())
            .then(data => {
                if (data.code === 200) {
                    login(dataUser);
                    navigate("/");
                }
                
            })
            .catch(error => {
                console.error(error);
            });
    }

    return (
        <div style={{ textAlign: "center", display: "flex", alignItems: "center", height: "100vh", justifyContent: "center", backgroundImage: `url(${fondo})`, backgroundSize: "cover" }}>
            <div style={{ width: "50%", height: "80vh", backgroundColor: colors.white, borderRadius: 20, alignItems: "center", justifyContent: "center", display: "flex" }}>
                <div style={{ color: colors.terceary, width: "100%" }}>
                    <h4 style={{ fontFamily: fontFamily.primary }}>Registrate gratis</h4>
                    <Form style={{ marginTop: 30, width: "100%" }} onSubmit={handleSubmit}>
                        <div style={{ display: "flex", alignContent: "center", justifyContent: "space-evenly" }}>
                            <div>
                                <Form.Group >
                                    <Form.Label>Nombre</Form.Label>
                                    <Form.Control name="nombre" type="text" placeholder="Introduzca su email" onChange={handleChange}></Form.Control>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Apellido Paterno</Form.Label>
                                    <Form.Control name="apellido_p" type="text" placeholder="Introduzca su contraseña" onChange={handleChange}></Form.Control>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Apellido Materno</Form.Label>
                                    <Form.Control name="apellido_m" type="text" placeholder="Introduzca su contraseña" onChange={handleChange}></Form.Control>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Email</Form.Label>
                                    <Form.Control name="email" type="email" placeholder="Introduzca su contraseña" onChange={handleChange}></Form.Control>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Contraseña</Form.Label>
                                    <Form.Control name="contrasena" type="password" placeholder="Introduzca su contraseña" onChange={handleChange}></Form.Control>
                                </Form.Group>
                            </div>
                        </div>

                        <Button style={{ backgroundColor: colors.primary, borderColor: colors.primary, marginTop: 20 }} type="submit">
                            Registrarse
                        </Button>
                    </Form>
                </div>

            </div>
        </div >
    )
}