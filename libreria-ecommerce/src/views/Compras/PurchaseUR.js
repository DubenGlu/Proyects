import React from "react";
import MasterPage from "../../components/MasterPage";
import NavTabMenu from "../../components/NavTabMenu";
import { Button } from "react-bootstrap";

export default function PurchaseUR() {
    return (
        <>
            <MasterPage/>
            <NavTabMenu/>
            <h1 style={{marginLeft:600}}>Bienvenido @user</h1>
            <div style={{float: "left"}}>

            <div style={{ width: "100%", padding: 50, paddingLeft:250, alignItems: "center"}}>
            <h1>Visualizar</h1>
            <div style={{paddingLeft: 35}}>
            <Button variant = "info" size="lg" style={{ padding: 15}}>Pedidos</Button>  
            </div>
           
            </div>
            
            <div style={{ width: "100%", padding: 50, paddingLeft:350 }} >
            <h1>Visualizar</h1>
            <div style={{paddingLeft: 15}}>
            <Button variant = "info" size="lg">Proveedores</Button> 
            </div>
            </div>

            </div>
            <div style={{float: "right", marginTop: 100}}>   
            
            <div style={{float: "left", marginRight: 50}}>
            <h1>Altas</h1>
            <Button variant = "info" size="lg" style={{ padding: 15}}>Producto</Button>
            <div style={{marginTop: 50}}>
            <Button variant = "info" size="lg" style={{ padding: 15}}>Proveedor</Button>  
            </div>  
            
            </div>
            <div style={{float: "right", marginRight: 100}}>
            <h1>Bajas</h1> 
            <Button variant = "info" size="lg" style={{ padding: 15}}>Producto</Button> 

            <div style={{marginTop: 50}}>
            <Button variant = "info" size="lg" style={{ padding: 15}}>Proveedor</Button>  
            </div>                
            </div>

            </div>
        </>
    )
}