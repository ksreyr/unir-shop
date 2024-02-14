import {performFetch} from "../FetchRequest.ts";

type Created = { booksID: string[] };
export  const requestProducts = () =>(body:Created) => performFetch("/books/requests", "8082").post(body)
