import Template from "../Template.tsx";
import Title from "../../components/Title";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import Card from "../../components/Card";
import {useProductDetail} from "./hook.ts";
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';



export default function ProductDetail() {
    const {product, dispatch} = useProductDetail()
    return (
        <Template>
            <Grid item xs={12} md={12} lg={12} spacing={3}>
                <Title>Details</Title>
                <Paper
                    sx={{
                        gridTemplateColumns: {md: '1fr'},
                    }}
                >
                    <Card product={product} height={'500hv'} dispatcher={dispatch} children={<AddShoppingCartIcon/>}/>
                </Paper>
            </Grid>

        </Template>)
}