import LinearProgress from "@mui/material/LinearProgress";
import {createContext, PropsWithChildren, useContext} from "react";
import CustomBoxOne_Line from "../../components/Styled/CustomBox/CustomBoxOne_Line.tsx";

const WrapperContext = createContext({})
export const WrapperProvider = WrapperContext.Provider;

export const LoadingContext = ({children}: PropsWithChildren) => {
    const context = useContext(WrapperContext)
    return context ?
        (<>{children}</>) :
        (<CustomBoxOne_Line>
            <LinearProgress />
        </CustomBoxOne_Line>)
}
