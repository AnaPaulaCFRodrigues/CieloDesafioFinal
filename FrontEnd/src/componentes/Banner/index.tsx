import estilos from './Banner.module.scss';

const Banner = () => {
  return (<section className={estilos.BannerArea}>
    <div className={estilos.Container}>
      <h1 className={estilos.Titulo}>Desafio Final</h1>
      <p>Consumo de API em Java Spring Boot.</p>
    </div>
  </section>)
}

export default Banner