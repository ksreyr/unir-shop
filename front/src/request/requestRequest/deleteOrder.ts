import {performFetch} from "../FetchRequest.ts";

export const deleteOrder= ()=>(orderID:string)=> performFetch("/requests/"+orderID, "8081").delete()
