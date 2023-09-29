import { Link } from 'react-router-dom';
import Banner from '../../componentes/Banner';
import NavBar from '../../componentes/NavBar';
import Rodape from '../../componentes/Rodape';
import estilos from './Home.module.scss';

function App() {
  return (
    <>
      <NavBar />
      <Banner />
      <div className={estilos.Links}>
        <h1>Gerenciar API</h1>
        <p className={estilos.botao}>Clique <Link to='/admin'>aqui</Link></p>
      </div>
      <Rodape />
    </>
  );
}

export default App;
