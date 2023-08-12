import React from "react";

import MasterPage from "../../components/MasterPage";
import NavTabMenu from "../../components/NavTabMenu";
import BannerHome from "../../components/BannerHome";
import { Button, Image } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function Cart() {
    return (
        <>
            <MasterPage />
            <NavTabMenu />
            <BannerHome />
            <div style={{ width: "100%", display: "flex", justifyContent: "center", alignItems: "center", flexDirection: "column" }}>
                <h2>Carrito de compra</h2>
                <div style={{ width: "100%", display: "flex", justifyContent: "space-around", alignItems: "center" }}>
                    <Image src={"https://imgs.search.brave.com/uM0DiOeIxHgCRaa_bKmHwkEkJB5il2OGJpA1GE_isJ8/rs:fit:1000:1200:1/g:ce/aHR0cHM6Ly9pbWFn/ZXNzbDEuY2FzYWRl/bGxpYnJvLmNvbS9h/L2wvdDAvNjEvOTc4/ODQyMDY1MTM2MS5q/cGc"} width={"8%"} height={"200vh"} style={{ borderRadius: 10 }}></Image>
                    <div>Titulo del libro</div>
                    <div>Cantidad</div>
                    <div>$$$$$$ Costo de venta</div>
                    <Button>Eliminar</Button>
                </div>
                <Link to={"/payment"}>
                    <Button>Comprar</Button>
                </Link>
            </div>
        </>
    )
}