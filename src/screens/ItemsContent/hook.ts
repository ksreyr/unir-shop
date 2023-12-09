import fetchAllProducts from "../../request/productsRequest/getAllProduct.tsx";
import {Dispatch, useContext, useEffect, useState} from "react";
import {PRODUCT_TYPE} from "../../models/models.tsx";
import validateData from "../../request/errorHandler.tsx";
import {ACTION_TYPE, ShopCarContext} from "../../context/ShopCar/ShopCar.tsx";

type FILTER_TYPE = (products: PRODUCT_TYPE[]) => PRODUCT_TYPE[];

type Dispatcher = (type: ("ADD" | "DELETE")) => (dispatch: Dispatch<ACTION_TYPE>) => void;

export const useItemsContent = () => {
    const fetchProduct = fetchAllProducts()
    const [products, setProducts] = useState<PRODUCT_TYPE[]>([])
    const fetchData = async () => validateData(fetchProduct, setProducts)
    const {changeState} = useContext(ShopCarContext)

    useEffect(() => {
        fetchData()
    }, [])


    const filterHandler = (filterProcess: FILTER_TYPE) => fetchProduct()
        .then((res: PRODUCT_TYPE[]) => filterProcess(res))
        .then(res => setProducts(res))

    const dispatcher = (dispatchAction: Dispatcher) =>
        dispatchAction("ADD")(changeState)

    return {
        products,
        filterHandler,
        dispatcher
    }
}