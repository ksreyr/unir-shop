import React, {useMemo, useState} from "react";
import {withItem} from "../../utils/filter/FilterUtils.tsx";
import {BOOK_TYPE} from "../../models/models.tsx";

export const useSearch = (filterHandler: (filterProcess: (products: BOOK_TYPE[]) => BOOK_TYPE[]) => void) => {

    const [name, setName] = useState("");
    const [category, setCategory] = useState("")

    const handleChange = useMemo(() => (event: React.SyntheticEvent,
                                        value: string | null,
                                        current: string) => {
        event.preventDefault();
        const isCategory = current === "category"
        current === "category" ? setCategory(value ?? "") : setName(value ?? "")

        filterHandler(productsArray =>
            productsArray.filter(
                product => {
                    if (isCategory && !name) {
                        return withItem(product).filterByCategoryWith(value)
                    } else if (!isCategory && category) {
                        return withItem(product).filterByCategoryOrNameWith(value, category)
                    } else if (!isCategory && !category) {
                        return withItem(product).filterByNameWith(value)
                    } else if (isCategory && name) {
                        return withItem(product).filterByCategoryAndName(value, name)
                    }
                })
        );
    }, [name, category])

    return {
        handleChange
    }
}