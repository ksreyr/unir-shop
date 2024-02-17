import {Dispatch, SetStateAction} from "react";

export default async function fetchAndSetData<T>(
    callback: () => Promise<T>,
    setter: Dispatch<SetStateAction<T>>) {
    try {
        const data = await callback()
        setter(data)
    } catch (error) {
        console.error('Error al realizar la peticion:', error);
    }
}
