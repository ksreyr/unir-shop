import {createBrowserRouter} from "react-router-dom";
import ItemsContent from "../screens/ItemsContent/index.tsx";
import DashboardContent from "../screens/DashboardContent";
import ProductDetail from "../screens/ProductDetail";
import ShopCar from "../screens/ShopCar";

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
        path: "/product/:id",
        element: <ProductDetail/>,
    }
]);
export default router;