import { Box, Button, Typography, AppBar, Container, Toolbar, Link, Paper } from "@mui/material"

import { Link as RouterLink, Outlet } from 'react-router-dom'

const PaginaBaseAdmin = () => {
    return (
        <>
            <AppBar position="static">
                <Container maxWidth="xl">
                    <Toolbar>
                        <Typography variant="h6">
                            Administração de Pessoas
                        </Typography>
                        <Box sx={{ display: 'flex', flexGrow: 1 }}>
                            <Link component={RouterLink} to="/pessoafisica">
                                <Button sx={{ my: 2, color: 'white' }}>
                                    Listar
                                </Button>
                            </Link>
                            <Link component={RouterLink} to="/admin/pessoafisica/novo">
                                <Button sx={{ my: 2, color: 'white' }}>
                                    Cadastrar
                                </Button>
                            </Link>
                            <Link component={RouterLink} to="/admin/pessoafisica/adm">
                                <Button sx={{ my: 2, color: 'white' }}>
                                    Pesquisar/Alterar/Excluir
                                </Button>
                            </Link>
                        </Box>
                    </Toolbar>
                </Container>
            </AppBar>
            <Box>
                <Container maxWidth="lg" sx={{ mt: 1 }}>
                    <Paper sx={{ p: 2 }}>
                        <Outlet />
                    </Paper>
                </Container>
            </Box>
        </>
    )
}

export default PaginaBaseAdmin