import {performFetch} from "../FetchRequest.ts";
import {ORDERS_TYPE} from "../../models/models.tsx";


export const fetchAllOrder:()=>Promise<ORDERS_TYPE> = ()=> performFetch("/requests", "8081").get()
