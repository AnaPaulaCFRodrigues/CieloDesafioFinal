import { Routes, Route } from 'react-router-dom';
import PaginaBaseAdmin from './paginas/Administracao/PaginaBaseAdmin';
import AdministracaoPessoa from './paginas/Administracao/PessoaPF/AdministracaoPessoas';
import FormularioPessoa from './paginas/Administracao/PessoaPF/FormularioPessoa';
import Home from './paginas/Home';

import VitrinePessoaFisica from './paginas/VitrinePessoaFisica';
import VitrinePessoaJuridica from './paginas/VitrinePessoaJuridica';

function App() {

  return (
    
    <Routes>
      
      <Route path="/" element={<Home />} />
      <Route path="/pessoafisica" element={<VitrinePessoaFisica />} />
      <Route path="/pessoajuridica" element={<VitrinePessoaJuridica />} />
      

      <Route path='/admin' element={<PaginaBaseAdmin />}>

        <Route path="pessoafisica/adm" element={<AdministracaoPessoa />} />
        <Route path="pessoafisica/novo" element={<FormularioPessoa />} />
        <Route path="pessoafisica/:id" element={<FormularioPessoa />} />


      </Route>

    </Routes>
  );
}

export default App;
