import React from "react";

import { useLocation } from "react-router-dom";

//Importación de componentes
import MasterPage from "../../components/MasterPage";
import NavTabMenu from "../../components/NavTabMenu";
import { Button, Image } from "react-bootstrap";
import { colors, fontFamily } from "../../constants/constants";
import { BsCartPlus } from "react-icons/bs";
import BannerHome from "../../components/BannerHome";


export default function Book() {
    const { state } = useLocation();
    const { foto, titulo, autor, descripcion, precio, stock } = state?.book;
    return (
        <>
            <MasterPage />
            <NavTabMenu />
            <BannerHome />>
            <div style={{ alignItems: "center", justifyContent: "center", display: "flex" }}>
                <div style={{ margin: 20, width: "60%", padding: 20, height: "80vh", display: "flex" }}>
                    <div style={{ width: "20%" }}>
                        <Image src={foto} width={"100%"} height={"280vh"} style={{ borderRadius: 10 }}></Image>
                    </div>
                    <div style={{ width: "80%", display: "flex", flexDirection: "column", alignItems: "center" }}>
                        <h4 style={{ fontFamily: fontFamily.primary }}>{titulo}</h4>
                        <h5 style={{ fontFamily: fontFamily.primary }}>Autor: {autor}</h5>
                        <h5>Stock: {stock}</h5>
                        <h5>Precio: ${precio}</h5>
                        <Button style={{ backgroundColor: colors.primary, borderColor: colors.primary, marginTop: 40 }}>
                            <BsCartPlus size={24} style={{ marginRight: 12 }}></BsCartPlus>
                            Comprar
                        </Button>
                        <br />
                        <span>Sipnosis: </span>
                        <p style={{ margin: 24, fontFamily: fontFamily.primary }}>{descripcion}</p>

                    </div>
                </div>
            </div>
        </>
    )
}