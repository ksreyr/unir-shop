import {useContext} from "react";
import {ACTION_TYPE_SHOPCAR, ShopCarContext} from "../../context/ShopCar/ShopCar.tsx";
import {ACTION_TYPE, OrderContext} from "../../context/Orders/OrdersContext.tsx";

type DispatcheventCar = (type: ("ADD" | "DELETE")) => (dispatch: React.Dispatch<ACTION_TYPE_SHOPCAR>) => void;
type Dispatchevent = (type: ("MAKE" | "REVERT")) => (dispatch: React.Dispatch<ACTION_TYPE>) => void;


export const useShopCar = () => {
    const {shopCar, changeState} = useContext(ShopCarContext)
    const deleteDispatcher = (dispatchAction: DispatcheventCar) => dispatchAction("DELETE")(changeState)
    const {dispatch} = useContext(OrderContext)
    const dispatcherOrder = (dispatchAction: Dispatchevent) => dispatchAction("MAKE")(dispatch)

    const getOnClick = () => {
        dispatcherOrder(type => dispatch1 => dispatch1({type: type, payload: shopCar}));
        shopCar.map(value => deleteDispatcher(type => dispatch1 => dispatch1(
            {type: type, payload: value}
        )))
    }

    return {
        shopCar,
        deleteDispatcher,
        dispatcherOrder,
        getOnClick
    }
}