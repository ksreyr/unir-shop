import {performFetch} from "../useFetch.tsx";


export const getOneProduct = () => {
    return (id: string) => performFetch("products/" + id).get()
}