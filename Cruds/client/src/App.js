import './App.css';
import { useState } from 'react';
import Axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

import Swal from 'sweetalert2'





function App() {

  

  const [id, setId] = useState("");
  const [nombre, setNombre] = useState("");
  const [edad, setEdad] = useState();
  const [pais, setPais] = useState("");
  const [cargo, setCargo] = useState("");
  const [anios, setAnios] = useState();

  const [editar, setEditar] = useState(false);
  
  const [empleadosList, setEmpleadosList] = useState([]);

  const validar = () => {
    if (nombre === "" || edad === "" || pais === "" || cargo === "" || anios === "") {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Todos los campos son obligatorios',
        footer: "Vuelve a intentarlo..."
      })
    }else{
      if (editar) {
        update();
      }else{
        add();
    }

    }
  }

  const add = () => {
    Axios.post("http://localhost:3001/create",{
      nombre: nombre,
      edad: edad,
      pais: pais,
      cargo: cargo,
      anios: anios
    }).then(()=>{
      getEmpleados();
      limpiar();
      Swal.fire({
        title: "<strong>Registrado!!</strong>",
        html: "<i>El empleado <strong>"+nombre+"</strong> fue registrado con exito!</i>",
        icon: 'success',
        timer: 3000
      })
    }).catch((error)=>{
      console.log(error);
    });
  }

  const update = () => {
    Axios.put("http://localhost:3001/update",{
      id: id,
      nombre: nombre,
      edad: edad,
      pais: pais,
      cargo: cargo,
      anios: anios
    }).then(()=>{
      getEmpleados();
      limpiar();
      Swal.fire({
        title: "<strong>Actualizado!!</strong>",
        html: "<i>El empleado <strong>"+nombre+"</strong> se azctualizo con exito!</i>",
        icon: 'success',
        timer: 3000
      })
    }).catch((error)=>{
      console.log(error);
    });
  }

  const deleteEmpleado = (val) => {
    Swal.fire({
      title: 'Confirmar.',
      html: "<i>Seguro que desea eliminar a  <strong>"+val.nombre+"</strong></i>",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, Eliminar!'
    }).then((result) => {
      if (result.isConfirmed) {
        Axios.delete(`http://localhost:3001/delete/${val.id}`).then(()=>{
          getEmpleados();
          limpiar();
        }).catch((error)=>{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Error al eliminar el empleado',
            footer: "Intenta mas tarde..."
          })
        });
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: val.nombre+' Ha sido eliminado!!',
          showConfirmButton: false,
          timer: 2000
        })
      }
    })
  }

  const editarEmpleado = (val)=>{
    setEditar(true);
    setId(val.id);
    setNombre(val.nombre);
    setEdad(val.edad);
    setPais(val.pais);
    setCargo(val.cargo);
    setAnios(val.anios);
  }

  const getEmpleados = () => {
    Axios.get("http://localhost:3001/empleados").then((response)=>{
      setEmpleadosList(response.data);
    }).catch((error)=>{
      console.log(error);
    });
  }

  getEmpleados();

  const limpiar = () => {
    setEditar(false);
    setId("");
    setNombre("");
    setEdad("");
    setPais("");
    setCargo("");
    setAnios("");
  }

 

  return (
  <div className="container">
    <div className="App">
      <div className="lista">
      </div>
    </div>
    <div className="card text-center">
      <div className="card-header">
        Gestion De Empleados
      </div>
      <div className="card-body">
        <div className="input-group mb-3">
          <span className="input-group-text" id="basic-addon1">Nombre:</span>
          <input type="text" 
            onChange={(e) => {
              setNombre(e.target.value);
            }}
            className="form-control" value={nombre} placeholder="Ingrese Nombre" aria-label="Username" aria-describedby="basic-addon1">
          </input>
        </div>
        <div className="input-group mb-3">
          <span className="input-group-text" id="basic-addon1">Edad:</span>
          <input type="number" 
            onChange={(e) => {
              setEdad(e.target.value);
            }}
            className="form-control" value={edad} placeholder="Ingrese Edad" aria-label="Username" aria-describedby="basic-addon1">
          </input>
        </div>
        <div className="input-group mb-3">
          <span className="input-group-text" id="basic-addon1">Pais:</span>
          <input type="text" 
            onChange={(e) => {
              setPais(e.target.value);
            }}
            className="form-control" value={pais} placeholder="Ingrese Pais" aria-label="Username" aria-describedby="basic-addon1">
          </input>
        </div>
        <div className="input-group mb-3">
          <span className="input-group-text" id="basic-addon1">Cargo:</span>
          <input type="text" 
            onChange={(e) => {
              setCargo(e.target.value);
            }}
            className="form-control" value={cargo} placeholder="Ingrese Cargo" aria-label="Username" aria-describedby="basic-addon1">
          </input>
        </div>
        <div className="input-group mb-3">
          <span className="input-group-text" id="basic-addon1">Anios:</span>
          <input type="number" 
            onChange={(e) => {
              setAnios(e.target.value);
            }}
            className="form-control" value={anios} placeholder="Ingrese Anios" aria-label="Username" aria-describedby="basic-addon1">
          </input>
        </div>
      </div>
      <div className="card-footer text-muted">
        {
          editar ?
          <div>
          <button className="btn btn-warning" onClick={validar}>Actualizar</button> 
          <button id='btnCancelar' className="btn btn-info" onClick={limpiar}>Cancelar</button>
          </div>
          : <button className="btn btn-success" onClick={validar}>Registrar</button>
        }
        
      </div>
    </div>
      <table className="table table-striped">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Nombre</th>
        <th scope="col">Edad</th>
        <th scope="col">Pais</th>
        <th scope="col">Cargo</th>
        <th scope="col">Experiencia</th>
        <th scope="col">Acciones</th>
      </tr>
    </thead>
    <tbody>
    {
        empleadosList.map((val,key)=>{
          return <tr key={val.id}>
                  <th scope="row">{val.id}</th>
                  <td>{val.nombre}</td>
                  <td>{val.edad}</td>
                  <td>{val.pais}</td>
                  <td>{val.cargo}</td>
                  <td>{val.anios}</td>
                  <td>
                  <div className="btn-group" role="group" aria-label="Basic example">
                    <button type="button" 
                    onClick={()=>{
                      editarEmpleado(val);
                    }}
                    className="btn btn-info">Editar</button>
                    <button type="button" onClick={()=>{
                      deleteEmpleado(val);
                    }} className="btn btn-danger">Eliminar</button>
                  </div>
                  </td>
                </tr>
        })
      }
    </tbody>
      </table>
  </div>
);
}

export default App;
