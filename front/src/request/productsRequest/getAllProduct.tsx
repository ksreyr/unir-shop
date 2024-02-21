import {performFetch} from "../FetchRequest.ts";

export default function fetchAllProducts(request?:string) {
    return () => performFetch("/books"+request, "8082").get()
}