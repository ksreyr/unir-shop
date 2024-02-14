import {performFetch} from "../FetchRequest.ts";
export type ORDERS_TYPE = {
    id: string;
    dateInfo: {
        creationDate: string;
    };
    booksID: string[];
}[];
export type ORDER_TYPE = {
    id: string;
    dateInfo: {
        creationDate: string;
    };
    booksID: string[];
};

export const fetchAllOrder:()=>Promise<ORDERS_TYPE> = ()=> performFetch("/requests", "8081").get()
