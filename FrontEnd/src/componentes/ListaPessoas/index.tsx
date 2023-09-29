import axios from 'axios';
import { useEffect, useState } from 'react';
import { IPaginacao } from '../../interfaces/IPaginacao';
import IListaPF from '../../interfaces/IListaPF';
import style from './ListaPessoasF.module.scss';
import ListaPF from './ListaPF';

const ListaPessoasF = () => {

  const [pessoas, setPessoas] = useState<IListaPF[]>([])
  

  useEffect(() => {
    // obter pessoas
    console.log("passei")
    axios.get('http://localhost:8080/api/pessoaPF')
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