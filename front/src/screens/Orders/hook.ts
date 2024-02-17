import { useEffect, useState} from "react";
import {fetchAllOrder} from "../../request/requestRequest/getAllProduct.ts";
import {deleteOrder} from "../../request/requestRequest/deleteOrder.ts";
import {ORDER_TYPE, ORDERS_TYPE} from "../../models/models.tsx";


export const useOrders = () => {
    const [orders, setOrders] = useState<ORDERS_TYPE>([])
    const getOrders = fetchAllOrder()
    const deleteOrders = deleteOrder()
    useEffect(() => {
        getOrders.then(value => {
                    setOrders(value)
            }
        )
    }, []);
    const onClick = (oderType:ORDER_TYPE) => () => {
        deleteOrders(oderType.id).then(value => console.log(value))
        setOrders(orders.filter(value => value!==oderType))
    }
    return {
        orders,
        onClick
    }
}