import ComponentSkeleton from "../../components/ComponentSkeleton";
import Title from "../../components/Title";
import {LoadingContext} from "../../context/WrapperContext/WrapperContext.tsx";
import Grid from "@mui/material/Grid";
import Card from "../../components/Card";
import Template from "../Template.tsx";
import Button from "../../components/Button/button.tsx";
import {useShopCar} from "./hook.ts";
import {CustomBoxOne_Template} from "../../components/Styled/CustomBox/UnirBox.tsx";
import Typography from "@mui/material/Typography";
import ShoppingCartCheckoutIcon from '@mui/icons-material/ShoppingCartCheckout';


export default function ShopCar() {
    const {shopCar, deleteDispatcher, getOnClick} = useShopCar()

    return (
        <Template>
            <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={12} md={12} xs={12}
                               gridTemplateColumns={'1fr 1fr 1fr'}>
                <Title>Shop-Car</Title>
                <CustomBoxOne_Template onClick={getOnClick}>
                    <Button text={"Order"}/>
                </CustomBoxOne_Template>
                {
                    shopCar.length !== 0 ? <LoadingContext>
                            {shopCar.map(product => (
                                <Grid key={product.bookId}>
                                    <Card product={product} dispatcher={deleteDispatcher}
                                          children={<ShoppingCartCheckoutIcon/>}/>
                                </Grid>))}
                        </LoadingContext> :
                        <>
                            <CustomBoxOne_Template>
                                <Typography paddingTop={4}>
                                    Parece que aun no has hecho algun pedido. En productos puedes seleccionar tus items.
                                </Typography>
                            </CustomBoxOne_Template>
                        </>
                }
            </ComponentSkeleton>
        </Template>
    )
}