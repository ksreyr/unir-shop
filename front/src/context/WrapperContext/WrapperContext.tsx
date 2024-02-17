import LinearProgress from "@mui/material/LinearProgress";
import {createContext, PropsWithChildren, useContext} from "react";
import {CustomBoxOne_Template} from "../../components/Styled/CustomBox/UnirBox.tsx";

const WrapperContext = createContext({})
export const WrapperProvider = WrapperContext.Provider;

export const LoadingContext = ({children}: PropsWithChildren) => {
    const value = useContext(WrapperContext)
    return value ?
        (<>{children}</>) :
        (<CustomBoxOne_Template>
            <LinearProgress/>
        </CustomBoxOne_Template>)
}
