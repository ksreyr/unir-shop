import {PRODUCT_TYPE} from "../../models/models.tsx";

export const withItem = (product: PRODUCT_TYPE) => {
    return {
        filterByCategoryWith: (value: string | null) => value ? product.categoria === value : true,
        filterByCategoryOrNameWith: (value: string | null, category: string) => value ? product.nombre === value : product.categoria === category,
        filterByNameWith: (value: string | null) => value ? product.nombre === value : true,
        filterByCategoryAndName: (value: string | null, name: string) => value ? product.categoria === value && product.nombre === name : product.nombre === name
    }
}