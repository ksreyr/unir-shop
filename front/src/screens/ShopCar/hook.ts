import {useContext} from "react";
import {ACTION_TYPE_SHOPCAR, ShopCarContext} from "../../context/ShopCar/ShopCar.tsx";
import {requestProducts} from "../../request/productsRequest/requestProduct.tsx";

type DispatcheventCar = (type: ("ADD" | "DELETE")) => (dispatch: React.Dispatch<ACTION_TYPE_SHOPCAR>) => void;


export const useShopCar = () => {
    const {shopCar, changeState} = useContext(ShopCarContext)
    const deleteDispatcher = (dispatchAction: DispatcheventCar) => dispatchAction("DELETE")(changeState)
    const makeRequest = requestProducts()
    const makeOrder = () => {
        const map = shopCar.map(value => value.bookId);
        makeRequest({booksID:map})
        shopCar.map(value => deleteDispatcher(
            type => dispatchDeleteItem =>
                dispatchDeleteItem({type, payload:value})
        ))
    }

    return {
        shopCar,
        deleteDispatcher,
        getOnClick: makeOrder
    }
}