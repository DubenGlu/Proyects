import React from "react";
import { Table } from "react-bootstrap";

export default function TableBooks(props) {
    const { libros } = props;

    return (
        <Table>
            <thead>
                <tr>
                    <th>Id_libro</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Foto</th>
                    <th>Editorial</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Descuento</th>
                    <th>Stock</th>
                </tr>
            </thead>
            <tbody>
                {libros.map((fila, indice) => (
                    <tr key={indice}>
                        <td>{fila.id_libro}</td>
                        <td>{fila.titulo}</td>
                        <td>{fila.autor}</td>
                        <td><img src={fila.foto} alt={fila.titulo} width={"60%"} /></td>
                        <td>{fila.editorial}</td>
                        <td style={{ display: "flex", height: "100vh", maxHeight: '13vh', overflow: 'hidden'}}>{fila.descripcion}</td>
                        <td>{fila.precio}</td>
                        <td>{fila.descuento}</td>
                        <td>{fila.stock}</td>
                    </tr>
                ))}
            </tbody>
        </Table>
    )
}