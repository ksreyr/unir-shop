import {useParams} from "react-router-dom";
import {getOneProduct} from "../../request/productsRequest/getOneProduct.tsx";
import fetchAndSetData from "../../request/errorHandler.tsx";
import {Dispatch, useContext, useEffect, useState} from "react";
import {PRODUCT_TYPE} from "../../models/models.tsx";
import {ACTION_TYPE, ShopCarContext} from "../../context/ShopCar/ShopCar.tsx";


const initialState: PRODUCT_TYPE = {
    id: 0,
    descripcionCorta: "",
    vendedor: "",
    categoria: "",
    descripcionLarga: "",
    empresaAsociada: "",
    imagen: "",
    nombre: "",
    precio: 0
};
type Dispatcher = ((type: "ADD" | "DELETE") => (dispatch: Dispatch<ACTION_TYPE>) => void);

export const useProductDetail = () => {
    const {id} = useParams()
    const callbackFetChProduct = getOneProduct()
    const getProduct = async (productId: string) => fetchAndSetData(() => callbackFetChProduct(productId!), setProduct)

    const [product, setProduct] = useState<PRODUCT_TYPE>(initialState)
    const {changeState} = useContext(ShopCarContext)
    const dispatch = (dispatcher: Dispatcher) => dispatcher("ADD")(changeState)
    useEffect(() => {
        if (id) {
            getProduct(id!)
        }
    }, [id])

    return {
        product,
        dispatch
    }
}