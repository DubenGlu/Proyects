import React, { useEffect, useState } from "react";
import { productos } from "../data/Products";
import { Form, Button, Image, Spinner } from "react-bootstrap";
import { colors } from "../constants/constants";
import { useNavigate } from "react-router-dom";

//Importaciones de componentes
import MasterPage from "../components/MasterPage";
import NavTabMenu from "../components/NavTabMenu";
import CardBooks from "../components/Card";
import BannerHome from "../components/BannerHome";

export default function Home() {
    const navigate = useNavigate();

    const [books, setBooks] = useState([]);

    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        fetch('http://localhost:4000/test/libros')
            .then(response => response.json())
            .then((data) => {
                setBooks(data);
                setLoading(false);
            })
            .catch((e) => {
                console.log(e);
                setLoading(false);
            })
    }, []);

    return (
        <>
            <MasterPage />
            <NavTabMenu />
            <BannerHome />
            <div style={{ backgroundColor: "#ebebeb", height: "40vh" }}>
                <div style={{ marginLeft: 40, marginRight: 40 }}>
                    <div style={{ display: "flex", alignItems: "center" }}>
                        <h2 style={{ marginRight: 20 }}>Libros</h2>
                        <div style={{ cursor: "pointer" }} onClick={() => { navigate("/books") }}>Ver más</div>
                    </div>
                    {loading && <div style={{ width: "100%", display: "flex", alignItems: "center", justifyContent: "center" }}><Spinner animation="grow" variant="warning" /></div>}
                    <div style={{ width: "100%", backgroundColor: "#ebebeb", alignItems: "center", justifyContent: "space-around", display: "flex", padding: 20 }}>
                        {books.slice(0, 6).map((book) => {
                            return (
                                <CardBooks key={book.titulo} data={book}></CardBooks>
                            )
                        })}
                    </div>
                </div>
            </div>
        </>
    )
}