import React from "react";

import MasterPage from "../../components/MasterPage";
import NavTabMenu from "../../components/NavTabMenu";
import { Button, Form, InputGroup } from "react-bootstrap";

export default function Payment() {
    return (
        <>
            <MasterPage />
            <NavTabMenu />
            <div style={{ width: "100%", display: "flex" }}>
                <div style={{ width: "50%" }}>
                    <h2>Datos de la operación</h2>
                    <Form>
                        <Form.Group>
                            <Form.Label>Importe: </Form.Label>
                            <Form.Control type="number"></Form.Control>
                            <Form.Label>No. Pedido: </Form.Label>
                            <Form.Control type="number"></Form.Control>
                            <Form.Label>Fecha: </Form.Label>
                            <Form.Control type="number"></Form.Control>
                        </Form.Group>
                    </Form>
                </div>
                <div style={{ width: "50%" }}>
                    <Form>
                        <Form.Group>
                            <Form.Label>No. Tarjeta </Form.Label>
                            <Form.Control type="number"></Form.Control>
                            <Form.Label>Caducidad: </Form.Label>
                            <Form.Control type="number"></Form.Control>
                            <Form.Label>CVV: </Form.Label>
                            <Form.Control type="number"></Form.Control>
                            <Button>Cancelar</Button>
                            <Button>Pagar</Button>
                        </Form.Group>
                    </Form>
                </div>
            </div>
        </>
    )
}