import {PRODUCT_TYPE} from "../../models/models.tsx";
import {createContext, Dispatch, PropsWithChildren, useReducer} from "react";

type STATE_TYPE = {
    orders: PRODUCT_TYPE[][];
};
type OrderType = {
    dispatch: Dispatch<ACTION_TYPE>;
} & STATE_TYPE;


export type ACTION_TYPE = { type: "MAKE" | "REVERT", payload: PRODUCT_TYPE[] }


export const OrderContext = createContext({} as OrderType)

const orderReducer = (state: STATE_TYPE, action: ACTION_TYPE) => {
    switch (action.type) {
        case "MAKE":
            return {
                ...state, orders: [...state.orders, action.payload]
            }
        case "REVERT":
            return {
                ...state, orders: state.orders
                    .filter((value: PRODUCT_TYPE[]) =>
                        !action.payload.every(item => value.includes(item)))
            }
        default:
            return state
    }
}

export const OrdersProvider = ({children}: PropsWithChildren) => {
    const [state, dispatch] = useReducer(orderReducer, {orders: []});
    return (
        <OrderContext.Provider value={{dispatch, orders: state.orders}}>
            {children}
        </OrderContext.Provider>
    )
}
