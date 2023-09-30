import axios from 'axios';
import { useEffect, useState } from 'react';
import IListaPF from '../../interfaces/IListaPF';
import style from './ListaPessoasF.module.scss';
import ListaPF from './ListaPF';
import http from '../../http';

const ListaPessoasF = () => {

  const [pessoas, setPessoas] = useState<IListaPF[]>([])
  const [size, setSize] = useState()
  

  useEffect(() => {
    // obter pessoas
    console.log("passei")
    http.get('http://localhost:8080/api/pessoaPF')
      .then(resposta => {
        console.log(resposta.data)
        setPessoas(resposta.data)        
      })
      .catch(erro => {
        console.log(erro)
      })
  }, [])
 

  return (<section className={style.listaPessoasF}>
    <h1>Lista de clientes!</h1>
    <ListaPF  />
   
  </section>)
}

export default ListaPessoasF