import React from 'react';
import Banner from '../../componentes/Banner';
import ListaPessoas from '../../componentes/ListaPessoas';
import NavBar from '../../componentes/NavBar';
import Rodape from '../../componentes/Rodape';

function App() {
  return (
    <>
      <NavBar />
      <Banner />
      <ListaPessoas />
      <Rodape />
    </>
  );
}

export default App;
