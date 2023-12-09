import ComponentSkeleton from "../../components/ComponentSkeleton";
import Title from "../../components/Title";
import {LoadingContext} from "../../context/WrapperContext/WrapperContext.tsx";
import Grid from "@mui/material/Grid";
import Card from "../../components/Card";
import Template from "../Template.tsx";
import Button from "../../components/Button/button.tsx";
import {useShopCar} from "./hook.ts";
import CustomBoxOne_Line from "../../components/Styled/CustomBox/CustomBoxOne_Line.tsx";
import Typography from "@mui/material/Typography";
import ShoppingCartCheckoutIcon from '@mui/icons-material/ShoppingCartCheckout';

export default function ShopCar() {
    const {shopCar, dispatcher} = useShopCar()
    return (
        <Template>
            <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={12} gridTemplateColumns={'1fr 1fr 1fr'}>
                <Title>Products</Title>
                <CustomBoxOne_Line>
                    <Button text={"Order"}/>
                </CustomBoxOne_Line>
                {
                    shopCar.length !== 0 ? <LoadingContext>
                            {shopCar.map(product => (
                                <Grid key={product.nombre}>
                                    <Card product={product} dispatcher={dispatcher} children={<ShoppingCartCheckoutIcon/>}/>
                                </Grid>))}
                        </LoadingContext> :
                        <>
                            <CustomBoxOne_Line>
                                <Typography paddingTop={4}>
                                    Parece que aun no has hecho algun pedido. En productos puedes seleccionar tus items.
                                </Typography>
                            </CustomBoxOne_Line>
                        </>
                }
            </ComponentSkeleton>
        </Template>
    )
}