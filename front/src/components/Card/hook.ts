import * as React from "react";
import {Dispatch, useState} from "react";
import {ACTION_TYPE_SHOPCAR} from "../../context/ShopCar/ShopCar.tsx";
import {PRODUCT_TYPE} from "../../models/models.tsx";

export const useCard = (
    product: PRODUCT_TYPE,
    dispatcher: (dispatchAction: (type: "ADD" | "DELETE") => (dispatch: Dispatch<ACTION_TYPE_SHOPCAR>) => void) => void) => {
    const [expanded, setExpanded] = React.useState(false);
    const [isLoading, setIsLoading] = useState(true);

    const handleImageLoad = () => {
        setIsLoading(false);
    };

    const handleClick = (event: React.SyntheticEvent) => {
        event.preventDefault();
        dispatcher(
            type => dispatch => dispatch({type: type, payload: product})
        )
    }

    const handleExpandClick = () => {
        setExpanded(!expanded);
    };
    return {
        handleExpandClick,
        handleClick,
        expanded,
        isLoading,
        handleImageLoad
    }
}