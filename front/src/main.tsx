import React from 'react'
import ReactDOM from 'react-dom/client'
import {RouterProvider} from "react-router-dom";
import router from "./routes/router.tsx";
import {DrawProvider} from "./context/Drawer/DrawerContext.tsx";
import CssBaseline from "@mui/material/CssBaseline";
import {ThemeProvider} from "@mui/material/styles";
import {ShopCarProvider} from "./context/ShopCar/ShopCar.tsx";
import {theme} from "./utils/themin/themin.ts";


ReactDOM.createRoot(document.getElementById('root')!).render(
    <ThemeProvider theme={theme}>
        <CssBaseline/>
        <React.StrictMode>
                <ShopCarProvider>
                    <DrawProvider>
                        <RouterProvider router={router}/>
                    </DrawProvider>
                </ShopCarProvider>
        </React.StrictMode>
    </ThemeProvider>
)
