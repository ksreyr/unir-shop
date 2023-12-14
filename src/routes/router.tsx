import {createBrowserRouter} from "react-router-dom";
import ItemsContent from "../screens/ItemsContent/index.tsx";
import DashboardContent from "../screens/DashboardContent";
import ProductDetail from "../screens/ProductDetail";
import ShopCar from "../screens/ShopCar";
import Contact from "../screens/Contact";
import Orders from "../screens/Orders";

const router = createBrowserRouter([
    {
        path: "/",
        element: <DashboardContent/>,
    },
    {
        path: "/products",
        element: <ItemsContent/>,
    },
    {
        path: "/shopcar",
        element: <ShopCar/>,
    },
    {
        path: "/contact",
        element: <Contact/>,
    },
    {
        path: "/orders",
        element: <Orders/>,
    },
    {
        path: "/product/:id",
        element: <ProductDetail/>,
    }
]);
export default router;