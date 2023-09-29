import estilos from './NavBar.module.scss';
import { Link } from 'react-router-dom'

const NavBar = () => {
  return (<nav className={estilos.Link}>
    <ul>
      <li>
        <Link to="/">Home</Link>
      </li>
      <li>
        <Link to="/pessoafisica">Pessoa Física</Link>
      </li>
      <li>
        <Link to="/pessoajuridica">Pessoa Jurídica</Link>
      </li>
    </ul>
  </nav>)
}

export default NavBar