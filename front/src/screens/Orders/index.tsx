import ComponentSkeleton from "../../components/ComponentSkeleton";
import Title from "../../components/Title";
import {LoadingContext} from "../../context/WrapperContext/WrapperContext.tsx";
import Grid from "@mui/material/Grid";
import Template from "../Template.tsx";
import {CustomBoxOne_Template} from "../../components/Styled/CustomBox/UnirBox.tsx";
import Typography from "@mui/material/Typography";
import OrderComponent from "../../components/Card/OrderComponent";
import {useOrders} from "./hook.ts";


export default function Orders() {
    const {orders, onClick} = useOrders();
    return (
        <Template>
            <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={12} md={12} sm={12} xs={12}
                               gridTemplateColumns={'1fr 1fr 1fr'}>
                <Title>Orders</Title>
                {
                    orders.length !== 0 ?
                        <LoadingContext>
                            {orders.map(order =>
                                (<Grid key={order.toString()}>
                                    <OrderComponent onClick={onClick(order)} products={order}/>
                                </Grid>))}
                        </LoadingContext> :
                        <>
                            <CustomBoxOne_Template>
                                <Typography paddingTop={4}>
                                    Parece que aun no has hecho ninguna orden. En productos puedes seleccionar tus
                                    items.
                                </Typography>
                            </CustomBoxOne_Template>
                        </>
                }
            </ComponentSkeleton>
        </Template>
    )
}