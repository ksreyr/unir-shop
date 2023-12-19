import LinearProgress from "@mui/material/LinearProgress";
import {createContext, PropsWithChildren, useContext} from "react";
import {CustomBoxOne_Template} from "../../components/Styled/CustomBox/UnirBox.tsx";

const WrapperContext = createContext({})
export const WrapperProvider = WrapperContext.Provider;

export const LoadingContext = ({children}: PropsWithChildren) => {
    const context = useContext(WrapperContext)
    return context ?
        (<>{children}</>) :
        (<CustomBoxOne_Template>
            <LinearProgress/>
        </CustomBoxOne_Template>)
}
