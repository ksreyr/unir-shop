import {performFetch} from "../FetchRequest.ts";

export default function fetchAllProducts() {
    return () => performFetch("/books", "8082").get()
}