import React from "react";
import MasterPage from "../../../components/MasterPage";
import NavTabMenu from "../../../components/NavTabMenu";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';


export default function SuppView() {
    return (
        <>
            <MasterPage />
            <NavTabMenu />
            <h1 style={{ marginLeft: 600 }}>Bienvenido @user</h1>

            <div style={{ float: "right", marginTop: 100, marginRight: 500, width: 300 }}>
                <h2>Detalles del producto</h2>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Title</Form.Label>
                        <Form.Control type="text" placeholder="Enter text" />
                        <Form.Text className="text-muted">

                        </Form.Text>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Title</Form.Label>
                        <Form.Control type="text" placeholder="Enter text" />
                        <Form.Text className="text-muted">

                        </Form.Text>
                    </Form.Group>
                    <Button variant="primary" type="submit" style={{ marginLeft: 220, padding: 10}}>
                        Dar de baja
                    </Button>
                </Form>
            </div>
            <div style={{ float: "left", marginTop: 100, marginLeft: 300, width: 300 }}>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <h3>Selecciona la clave del producto</h3>
                        <Form.Select aria-label="Default select example">
                            <option>Open this select menu</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </Form.Select>
                    </Form.Group>

                </Form>
            </div>

        </>
    )
}