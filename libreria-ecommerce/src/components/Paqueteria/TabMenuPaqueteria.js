import React, { useContext, useState } from "react";
import { colors } from "../../constants/constants";


//Iconos
import { BsFillBoxSeamFill, BsFillCartFill, BsFillPersonFill, BsFilePerson, BsPersonVcard } from "react-icons/bs";
import {TbPackageExport} from "react-icons/tb";
import {FaBoxOpen} from "react-icons/fa";
import {RiCheckboxMultipleFill} from "react-icons/ri";
import { Link } from "react-router-dom";
import { Button, Dropdown } from "react-bootstrap";

export default function NavTabMenu() {

    return (
        <div style={{ width: "100%", height: "5vh", backgroundColor: colors.primary, alignItems: "center", justifyContent: "space-between", display: "flex", padding: 20 }}>
            <Link to={"/homepaq"} style={{ textDecoration: "none" }}>
                <Button style={{ backgroundColor: colors.primary, borderColor: colors.primary, marginRight: 16, alignItems: "center", display: "flex" }} type="submit">
                    <BsFillBoxSeamFill size={20} style={{ marginRight: 8 }} />
                    Todos los pedidos
                </Button>
            </Link>
            <Link to={"/pedidosnenv"} style={{ textDecoration: "none" }}>
                <Button style={{ backgroundColor: colors.primary, borderColor: colors.primary, marginRight: 16, alignItems: "center", display: "flex" }} type="submit">
                    <FaBoxOpen size={24} style={{ marginRight: 8 }} />
                    Pedidos No Enviados
                </Button>
            </Link>
            <Link to={"/pedidosenv"} style={{ textDecoration: "none" }}>
                <Button style={{ backgroundColor: colors.primary, borderColor: colors.primary, marginRight: 16, alignItems: "center", display: "flex" }} type="submit">
                    <TbPackageExport size={24} style={{ marginRight: 8 }} />  
                    Pedidos Enviados
                </Button>
            </Link>
            <Link to={"/pedidosent"} style={{ textDecoration: "none" }}>
                <Button style={{ backgroundColor: colors.primary, borderColor: colors.primary, marginRight: 16, alignItems: "center", display: "flex" }} type="submit">
                    <RiCheckboxMultipleFill size={25} style={{ marginRight: 8 }} />
                    Pedidos Entegados
                </Button>
            </Link>
        </div >
    )
}