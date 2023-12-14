import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';
import {PRODUCT_TYPE} from "../../../models/models.tsx";
import Title from "../../Title";

export default function OrderComponent({onClick, products}:{onClick:()=>void, products:PRODUCT_TYPE[]}) {

    return (
        <Card sx={{ maxWidth: 345 }}>
            <CardActionArea>
                <Title>Order</Title>
                <Typography variant={"caption"} paddingBottom={2}>Products</Typography>
                <CardContent>
                    {products.map(value => (
                        <Typography variant="body2" color="text.secondary">
                        {value.nombre}
                        </Typography>))}
                </CardContent>
            </CardActionArea>
            <CardActions>
                <Button size="small" color="primary" onClick={()=>onClick()}>
                    Return Order
                </Button>
            </CardActions>
        </Card>
    );
}