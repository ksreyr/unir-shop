import {useContext} from "react";
import {ACTION_TYPE, OrderContext} from "../../context/Orders/OrdersContext.tsx";
import {PRODUCT_TYPE} from "../../models/models.tsx";

type Dispatchevent = (type: ("MAKE" | "REVERT")) => (dispatch: React.Dispatch<ACTION_TYPE>) => void;

export const useOrders = () => {
  const {orders, dispatch} = useContext(OrderContext)
  const dispatcher = (dispatchAction: Dispatchevent) => dispatchAction("REVERT")(dispatch)
  const onClick = (order:PRODUCT_TYPE[]) => ()=>{
    dispatcher(type => dispatch1 => dispatch1({
      type: type, payload: order
    }))
  }
  return{
      orders,
      onClick
  }
}