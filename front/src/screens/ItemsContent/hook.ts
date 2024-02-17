import fetchAllProducts from "../../request/productsRequest/getAllProduct.tsx";
import {Dispatch, useContext, useEffect, useState} from "react";
import {BOOK_TYPE} from "../../models/models.tsx";
import validateData from "../../request/ErrorHandler.ts";
import {ACTION_TYPE_SHOPCAR, ShopCarContext} from "../../context/ShopCar/ShopCar.tsx";

type FILTER_TYPE = (products: BOOK_TYPE[]) => BOOK_TYPE[];

type Dispatcher = (dis: (type: ("ADD" | "DELETE")) => (dispatch: Dispatch<ACTION_TYPE_SHOPCAR>) => void) => void;

export const useItemsContent = () => {
    const fetchProduct = fetchAllProducts()
    const [products, setProducts] = useState<BOOK_TYPE[]>([])
    const fetchData = async () => validateData(fetchProduct, setProducts)
    const {changeState} = useContext(ShopCarContext)

    useEffect(() => {
        fetchData()
    }, [])

    const filterHandler = (filterProcess: FILTER_TYPE) => fetchProduct()
        .then((res: BOOK_TYPE[]) => filterProcess(res))
        .then(res => setProducts(res))

    const dispatcher: Dispatcher = (dispatchAction) =>
        dispatchAction("ADD")(changeState)

    return {
        products,
        filterHandler,
        dispatcher: dispatcher
    }
}