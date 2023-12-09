import {createTheme} from "@mui/material/styles";
import {colors} from "@mui/material";

 const baseTheme = createTheme({
    palette: {
            mode: 'dark',
    },
});

export const theme = () =>createTheme(baseTheme,{

    components: {
        MuiButtonBase: {
            defaultProps: {
                disableRipple: false,
            },
        },
        MuiAvatar: {
            styleOverrides: {
                root: {
                    width: '70',
                    height: '70',
                },
            },
        },
        MuiToolbar:{
            styleOverrides: {
                root: {
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'flex-end',
                    px: [1],
                },
            },
        },
        MuiCardHeader: {
            styleOverrides: {
                root: {
                    height: '110px',
                },
            },
        },
        MuiCardContent: {
            styleOverrides: {
                root: {
                    padding: '70',
                    height: '100',
                },
            },
        },
        MuiCard: {
            styleOverrides: {
                root: {
                    backgroundColor: colors.grey[900],
                    margin:'10px',
                    marginLeft:'0px',
                    gridAutoFlow:'1'
                },
            },
        },
        MuiPaper: {
            styleOverrides: {
                root: {
                    padding: '16px',
                    bgcolor: 'background.default',
                    gap: "0px",
                    borderRadius: "7px",
                    display: 'grid',
                },
            },
        },
    },
});