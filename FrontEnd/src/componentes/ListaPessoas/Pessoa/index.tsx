import IPessoaF from '../../../interfaces/IPessoaF';
import estilos from './PessoaF.module.scss';

interface PFProps {
  pf: IPessoaF
}

const PF = ({ pf }: PFProps) => {
  return (<div className={estilos.Conteudo}>
    <div className={estilos.Conteudo}>
      <h3>{pf.nomePF}</h3>
      <div className={estilos.Tag}>
        {pf.CPF}
      </div>
      <div>
        {pf.emailPF} - {pf.MCC}
      </div>
    </div>
  </div>)
}

export default PF