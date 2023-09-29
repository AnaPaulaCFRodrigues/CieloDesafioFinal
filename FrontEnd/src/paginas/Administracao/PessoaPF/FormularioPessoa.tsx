import { Box, Button, FormControl, InputLabel, MenuItem, Select, TextField, Typography } from "@mui/material"
import { useEffect, useState } from "react"
import http from "../../../http"
import { useParams } from "react-router-dom"
import IListaPF from "../../../interfaces/IListaPF"

const FormularioPessoa = () => {

    const [nomePF, setNomePF] = useState('')
    const [MCC, setMCC] = useState('')
    const [CPF, setCPF] = useState('')
    const [emailPF, setemailPF] = useState('')
    const [pessoa, setPessoa] = useState<IListaPF[]>([])

    const parametros = useParams()

    useEffect(() => {
        if (parametros.id) {
            http.get(`http://localhost:8080/api/pessoaPF/${parametros.id}`)
                .then(resposta => {
                    console.log(resposta.data)
                    setPessoa(resposta.data)
                })
        }
    }, [parametros])

    const aoSubmeterForm = (evento: React.FormEvent<HTMLFormElement>) => {
        evento.preventDefault()

        const formData = new FormData();

        formData.append('nomePF', nomePF)
        formData.append('MCC', MCC)
        formData.append('CPF', CPF)
        formData.append('emailPF', emailPF)

        const data = {
            nomePF: nomePF,
            MCC: MCC,
            CPF: CPF,
            emailPF: emailPF
        }
        console.log(data)

        if (parametros.id) {

            http.put(`pessoaPF/${parametros.id}`, 
                data
            )
                .then(() => {
                    alert("Cliente atualizado com sucesso!")
                })
        }
        else {

            http.request({
                url: 'pessoaPF',
                method: 'POST',
                data: data
            })
                .then(() => {
                    setNomePF('')
                    setCPF('')
                    setMCC('')
                    setemailPF('')

                    alert('Cliente cadastrado com sucesso!')
                })
                .catch(erro => console.log(erro))
        }

    }

    return (
        <Box sx={{ display: 'flex', flexDirection: "column", alignItems: "center", flexGrow: 1 }}>
            <Typography component="h1" variant="h6">Formulário de Pessoas Físicas</Typography>
            <Box component="form" sx={{ width: '100%' }} onSubmit={aoSubmeterForm}>
                <TextField
                    value={nomePF}
                    onChange={evento => setNomePF(evento.target.value)}
                    label="Nome do Cliente"
                    variant="standard"
                    fullWidth
                    required
                    margin="dense"
                />
                <TextField
                    value={CPF}
                    onChange={evento => setCPF(evento.target.value)}
                    label="CPF:"
                    variant="standard"
                    fullWidth
                    required
                    margin="dense"
                />
                <TextField
                    value={MCC}
                    onChange={evento => setMCC(evento.target.value)}
                    label="MCC:"
                    variant="standard"
                    fullWidth
                    required
                    margin="dense"
                />
                <TextField
                    value={emailPF}
                    onChange={evento => setemailPF(evento.target.value)}
                    label="Email:"
                    variant="standard"
                    fullWidth
                    required
                    margin="dense"
                />

                <Button sx={{ marginTop: 1 }} type="submit" fullWidth variant="outlined">Salvar</Button>
            </Box>
        </Box>
    )
}

export default FormularioPessoa