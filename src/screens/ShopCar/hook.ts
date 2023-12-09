import {useContext} from "react";
import {ACTION_TYPE, ShopCarContext} from "../../context/ShopCar/ShopCar.tsx";

type Dispatchevent = (type: ("ADD" | "DELETE")) => (dispatch: React.Dispatch<ACTION_TYPE>) => void;


export const useShopCar = () => {
    const {shopCar, changeState} = useContext(ShopCarContext)
    const dispatcher = (dispatchAction: Dispatchevent) => dispatchAction("DELETE")(changeState)
    return {
        shopCar,
        dispatcher
    }
}