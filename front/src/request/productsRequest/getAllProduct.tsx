import {performFetch} from "../useFetch.tsx";

export default function fetchAllProducts() {
    return () => performFetch("products").get()
}