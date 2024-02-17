import Card from "../../components/Card";
import Template from "../Template.tsx";
import Grid from "@mui/material/Grid";
import {LoadingContext, WrapperProvider} from "../../context/WrapperContext/WrapperContext.tsx";
import Search from "../../components/Search";
import Title from "../../components/Title";
import ComponentSkeleton from "../../components/ComponentSkeleton";
import {useItemsContent} from "./hook.ts";
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';

export default function ItemsContent() {
    const {products, filterHandler, dispatcher} = useItemsContent()
console.log(products)
    return (
        <Template>
            <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={12} sm={12} md={12} xs={12}
                               gridTemplateColumns={'1fr'}>
                <Title>Filter Product</Title>
                <Search products={products} filterHandler={filterHandler}/>
            </ComponentSkeleton>

            <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={12} sm={12} md={12} xs={12}
                               gridTemplateColumns={'1fr 1fr 1fr'}>
                <Title>Products</Title>
                <WrapperProvider value={products.length != 0}>
                    <LoadingContext>
                        {products.map(product => (
                            <Grid key={product.bookName.bookName}>
                                <Card product={product} dispatcher={dispatcher} children={<AddShoppingCartIcon/>}/>
                            </Grid>))}
                    </LoadingContext>
                </WrapperProvider>
            </ComponentSkeleton>
        </Template>)
}