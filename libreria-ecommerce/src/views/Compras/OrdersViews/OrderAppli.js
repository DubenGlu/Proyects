import React from "react";
import MasterPage from "../../../components/MasterPage";
import NavTabMenu from "../../../components/NavTabMenu";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';


export default function OrderAppli() {
    return (
        <>
            <MasterPage />
            <NavTabMenu />
            <h1 style={{ marginLeft: 600 }}>Bienvenido @user</h1>

            <div style={{ float: "center", margin: 100}}>
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

                    <Button variant="primary" type="submit">
                        Crear Propuesta
                    </Button>

                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>No. Autorización</Form.Label>
                        <Form.Control type="text" placeholder="Enter number" />
                        <Form.Text className="text-muted">
                           
                        </Form.Text>
                    </Form.Group>

                    <Button variant="primary" type="submit">
                        Crear
                    </Button>
                    
                </Form>
            </div>

        </>
    )
}