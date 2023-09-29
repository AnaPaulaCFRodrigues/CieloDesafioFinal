import axios from 'axios';
import { useState, useEffect } from 'react';
import IPessoaF from '../../../interfaces/IPessoaF';
import IListaPF from '../../../interfaces/IListaPF';
import Pessoa from '../Pessoa';
import estilos from './ListaPF.module.scss';


interface ListaPFProps {
  lista: IListaPF
}

const ListaPF = () => {
  const [pessoas, setPessoas] = useState<IPessoaF[]>()
  useEffect(() => {
    axios.get<IPessoaF[]>('http://localhost:8080/api/pessoaPF')
      .then(resposta => {
        setPessoas(resposta.data)
      })
     
  }, [])

  return (<section className={estilos.ListaPF}>
    <div className={estilos.Titulo}>
      <h2>Pessoa Física</h2>
    </div>
    <div>
      {pessoas?.map(item => <Pessoa pf={item} key={item.id} />)}
    </div>  

  </section>)
}

export default ListaPF
