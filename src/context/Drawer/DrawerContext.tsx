import {createContext, Dispatch, useReducer} from "react";

type DRAW_STATE = {
    isOpen: boolean,
}
type DISPATCH_ACTION = {
    changeState: Dispatch<ACTION_TYPE>
} & DRAW_STATE

export const DrawContext = createContext({} as DISPATCH_ACTION)

type ACTION_TYPE = { type: 'CHANGE' }
type STATE_TYPE = { open: boolean }

const drawReducer = (state: STATE_TYPE, action: ACTION_TYPE) => {
    switch (action.type) {
        case "CHANGE":
            return {...state, open: !state.open}
        default:
            return state
    }
}
const INITIAL_STATE: STATE_TYPE = {
    open: true
}
export const DrawProvider = ({children}: { children: React.ReactNode }) => {
    const [drawState, setDrawState] = useReducer(drawReducer, INITIAL_STATE)
    return (
        <DrawContext.Provider value={{isOpen: drawState.open, changeState: setDrawState}}>
            {children}
        </DrawContext.Provider>
    )
}


