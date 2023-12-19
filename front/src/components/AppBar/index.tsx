import {AppBarProps as MuiAppBarProps} from "@mui/material/AppBar/AppBar";
import {styled} from "@mui/material/styles";
import MuiAppBar from "@mui/material/AppBar";

interface AppBarProps extends MuiAppBarProps {
    open?: boolean;
    width?: number;
}

const AppBar = styled(MuiAppBar, {
    shouldForwardProp: (prop) => prop !== 'open',
})<AppBarProps>(({theme, open, width = 240}) => ({
    zIndex: theme.zIndex.drawer + 1,
    padding: '7px',
    transition: theme.transitions.create(['width', 'margin'], {
        easing: theme.transitions.easing.sharp,
        duration: theme.transitions.duration.leavingScreen,
    }),
    ...(open && {
        marginLeft: width,
        padding: '7px',
        width: `calc(100% - ${width}px)`,
        transition: theme.transitions.create(['width', 'margin'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    }),
}));

export default AppBar;