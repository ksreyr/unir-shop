import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import {PRODUCT_TYPE} from "../../models/models.tsx";
import Grid from "@mui/material/Grid";
import {useSearch} from "./hook.ts";


export default function Search({products, filterHandler}:
                                   {
                                       products: PRODUCT_TYPE[],
                                       filterHandler: (filterProcess: (products: PRODUCT_TYPE[]) => PRODUCT_TYPE[]) => void
                                   }) {

    const {handleChange} = useSearch(filterHandler)

    return (
        <Grid container spacing={1} direction={"row"}>
            <Grid item lg={6} sm={6} md={6} xs={6}>
                <Autocomplete
                    disablePortal
                    id="category"
                    autoHighlight
                    options={[...(new Set(products.map(products => products.categoria)))]}
                    onChange={(event, value) => handleChange(event, value, "category")}
                    getOptionLabel={(option) => option}
                    renderInput={(params) => <TextField {...params} label="Categorias"/>}
                />
            </Grid>
            <Grid item lg={6} sm={6} md={6} xs={6}>
                <Autocomplete
                    disablePortal
                    id="name-containar"
                    autoHighlight
                    options={[...(new Set(products.map(products => products.nombre)))]}
                    onChange={(event, value) => handleChange(event, value, "name")}
                    getOptionLabel={(option) => option}
                    renderInput={(params) => <TextField {...params} label="Products"/>}
                />
            </Grid>
        </Grid>
    )
}