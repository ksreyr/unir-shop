
import {createBrowserRouter} from "react-router-dom";
import Template from "../screens/Template.tsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Template />,
    },
]);
export default router;