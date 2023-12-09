import {styled, useTheme} from "@mui/material/styles";
import MuiDrawer, {DrawerProps as MuiDrawerProps} from "@mui/material/Drawer";

interface DrawerProps extends MuiDrawerProps {
    width?: number;
    open: boolean;
}

const Drawer = styled(MuiDrawer,
    {shouldForwardProp: (prop) => prop !== 'open'})(
    ({open, width = 240}: DrawerProps) => {
        const theme = useTheme();
        return ({
            '& .MuiDrawer-paper': {
                position: 'relative',
                whiteSpace: 'nowrap',
                width: width,
                transition: theme.transitions.create('width', {
                    easing: theme.transitions.easing.sharp,
                    duration: theme.transitions.duration.enteringScreen,
                }),
                boxSizing: 'border-box',
                ...(!open && {
                    overflowX: 'hidden',
                    transition: theme.transitions.create('width', {
                        easing: theme.transitions.easing.sharp,
                        duration: theme.transitions.duration.leavingScreen,
                    }),
                    width: theme.spacing(7),
                    [theme.breakpoints.up('sm')]: {
                        width: theme.spacing(9),
                    },
                }),
            },
        })
    },
);

export default Drawer
