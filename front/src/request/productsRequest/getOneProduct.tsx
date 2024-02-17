import {performFetch} from "../FetchRequest.ts";

export const getOneProduct = () => {
    return (id: string) => performFetch("/books/products/" + id, "8082").get()
}