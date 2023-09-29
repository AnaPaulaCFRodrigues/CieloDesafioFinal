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
        CPF: {pf.CPF}
      </div>
      <div className={estilos.Tag}>
        MCC: {pf.MCC}
      </div>
      <div>
        Email: {pf.emailPF} - {pf.MCC}
      </div>
    </div>
  </div>)
}

export default PF