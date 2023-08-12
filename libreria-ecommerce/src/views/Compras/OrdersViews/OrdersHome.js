import React from "react";
import MasterPage from "../../../components/MasterPage";
import NavTabMenu from "../../../components/NavTabMenu";
import { Button } from "react-bootstrap";
import Table from 'react-bootstrap/Table';

export default function OrdersHome() {
    return (
        <>
            <MasterPage />
            <NavTabMenu />
            <h1 style={{ marginLeft: 600 }}>Bienvenido @user</h1>

            <div style={{ float: "left", marginLeft: 100, marginTop: 100 }}>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Username</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td colSpan={2}>Larry the Bird</td>
                            <td>@twitter</td>
                        </tr>
                    </tbody>
                </Table>
            </div>
            <div style={{ float: "right", marginRight: 100, marginTop: 100 }}>
                <h3>Crear nuevo pedido</h3>
                <Button variant = "info" size="lg" style={{marginLeft: 80}}>Creaer</Button> 
                <h3>Modificar pedido</h3>
                <Button variant = "info" size="lg" style={{marginLeft: 80}}>Modificar</Button> 
                <h3>Visualizar pedido</h3>
                <Button variant = "info" size="lg" style={{marginLeft: 80}}>Ver</Button> 

            </div>
        </>
    )
}