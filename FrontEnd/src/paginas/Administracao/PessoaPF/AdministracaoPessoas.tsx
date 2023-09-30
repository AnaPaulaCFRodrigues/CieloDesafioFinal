import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material"
import { useEffect, useState } from "react"
import http from "../../../http"
import IPessoa from "../../../interfaces/IPessoaF"

import { Link as RouterLink } from 'react-router-dom'

const AdministracaoPessoas = () => {

    const [pessoas, setpessoas] = useState<IPessoa[]>([])

    useEffect(() => {
        http.get<IPessoa[]>('http://localhost:8080/api/pessoaPF')
            .then(resposta => setpessoas(resposta.data))
    }, [])

    const excluir = (pessoaAhSerExcluido: IPessoa) => {
        http.delete(`pessoaPF/${pessoaAhSerExcluido.id}`)
            .then(() => {
                const listapessoas = pessoas.filter(pessoa => pessoa.id !== pessoaAhSerExcluido.id)
                setpessoas([...listapessoas])
            })
    }

    return (
        <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>
                            Nome
                        </TableCell>
                        <TableCell>
                            CPF
                        </TableCell>
                        <TableCell>
                            Email
                        </TableCell>
                        <TableCell>
                            MCC
                        </TableCell>
                        <TableCell>
                            Excluir
                        </TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {pessoas.map(pessoa => <TableRow key={pessoa.id}>
                        <TableCell>
                            {pessoa.nomePF}
                        </TableCell>
                        <TableCell>
                            {pessoa.CPF}
                        </TableCell>
                        <TableCell>
                           {pessoa.MCC} 
                        </TableCell>
                        <TableCell>
                            [ <RouterLink to={`/admin/pessoafisica/${pessoa.id}`}>editar</RouterLink> ]
                        </TableCell>
                        <TableCell>
                            <Button variant="outlined" color="error" onClick={() => excluir(pessoa)}>
                                Excluir
                            </Button>
                        </TableCell>
                    </TableRow>)}
                </TableBody>
            </Table>
        </TableContainer>
    )
}

export default AdministracaoPessoas