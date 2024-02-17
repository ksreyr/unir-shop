import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import {Button, CardActionArea, CardActions} from '@mui/material';
import Title from "../../Title";
import {ORDER_TYPE} from "../../../request/requestRequest/getAllProduct.ts";

export default function OrderComponent({onClick, products}: { onClick: () => void, products: ORDER_TYPE }) {

    return (
        <Card sx={{maxWidth: 345}}>
            <CardActionArea>
                <Title>Order</Title>
                <Typography variant={"caption"} paddingBottom={2}>Orders-ID</Typography>
                <CardContent>
                        <Typography variant="body2" color="text.secondary">
                            {products.id}
                        </Typography>
                </CardContent>
            </CardActionArea>
            <CardActions>
                <Button size="small" color="primary" onClick={() => onClick()}>
                    Return Order
                </Button>
            </CardActions>
        </Card>
    );
}