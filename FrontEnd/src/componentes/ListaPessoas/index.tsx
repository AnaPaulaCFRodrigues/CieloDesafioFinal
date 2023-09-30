import axios from 'axios';
import { useEffect, useState } from 'react';
import IListaPF from '../../interfaces/IListaPF';
import style from './ListaPessoasF.module.scss';
import ListaPF from './ListaPF';
import http from '../../http';

const ListaPessoasF = () => {

  const [pessoas, setPessoas] = useState<IListaPF[]>([])
  const [size, setSize] = useState()
  const [empty, setEmpty] = useState()


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
    http.get('http://localhost:8080/api/fila')
      .then(resposta => {
        console.log(resposta.data)
        setEmpty(resposta.data)
      })
      .catch(erro => {
        console.log(erro)
      })
    http.get('http://localhost:8080/api/fila/size')
      .then(resposta => {
        console.log(resposta.data)
        setSize(resposta.data)
      })
      .catch(erro => {
        console.log(erro)
      })
  }, [])


  return (<section className={style.listaPessoasF}>
    <h1>A Lista de clientes está vazia? {empty}</h1>
    <h1>Existem {size} clientes na fila para atendimento.</h1>
    <ListaPF />

  </section>)
}

export default ListaPessoasF