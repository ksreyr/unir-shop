import React from 'react'
import ReactDOM from 'react-dom/client'
import {RouterProvider} from "react-router-dom";
import router from "./routes/router.tsx";
import {DrawProvider} from "./context/Drawer/DrawerContext.tsx";
import CssBaseline from "@mui/material/CssBaseline";
import {ThemeProvider} from "@mui/material/styles";
import {ShopCarProvider} from "./context/ShopCar/ShopCar.tsx";
import {theme} from "./utils/themin/themin.ts";
import {OrdersProvider} from "./context/Orders/OrdersContext.tsx";


ReactDOM.createRoot(document.getElementById('root')!).render(
    <ThemeProvider theme={theme}>
        <CssBaseline/>
        <React.StrictMode>
            <OrdersProvider>
                <ShopCarProvider>
                    <DrawProvider>
                        <RouterProvider router={router}/>
                    </DrawProvider>
                </ShopCarProvider>
            </OrdersProvider>
        </React.StrictMode>
    </ThemeProvider>
)
