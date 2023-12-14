import {createContext, Dispatch, PropsWithChildren, useReducer} from "react";
import {PRODUCT_TYPE} from "../../models/models.tsx";

type SHOP_TYPE = { shopCar: PRODUCT_TYPE[] }
type SHOP_DISPATCHER = { changeState: Dispatch<ACTION_TYPE_SHOPCAR> } & SHOP_TYPE
export type ACTION_TYPE_SHOPCAR = { type: 'ADD' | 'DELETE', payload: PRODUCT_TYPE }


export const ShopCarContext = createContext({} as SHOP_DISPATCHER)

const shopReducer = (state: SHOP_TYPE, action: ACTION_TYPE_SHOPCAR) => {
    switch (action.type) {
        case "ADD":
            return (state.shopCar.includes(action.payload))? state: {...state, shopCar: [...state.shopCar, action.payload]}
        case "DELETE":
            return {
                ...state, shopCar: state.shopCar.filter(value => value.id != action.payload.id)
            }
        default:
            return state
    }
}

const INICTIAL_STATE: SHOP_TYPE = {
    shopCar: []
}

export const ShopCarProvider = ({children}: PropsWithChildren) => {
    const [state, setState] = useReducer(shopReducer, INICTIAL_STATE)
    return (<ShopCarContext.Provider value={{shopCar: state.shopCar, changeState: setState}}>
        {children}
    </ShopCarContext.Provider>)
}
