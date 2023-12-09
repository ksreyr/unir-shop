import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import Typography from "@mui/material/Typography";
import Badge from "@mui/material/Badge";
import {useContext} from "react";
import {ShopCarContext} from "../../context/ShopCar/ShopCar.tsx";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";

export default function Header({toggleDrawer, isOpen}: {
    toggleDrawer: () => void,
    isOpen: boolean
}) {

    const {shopCar} = useContext(ShopCarContext)

    return (
        <Toolbar
            sx={{
                pr: '24px',
                padding: '0px',
            }}
        >
            <IconButton
                edge="start"
                color="inherit"
                aria-label="open drawer"
                onClick={toggleDrawer}
                sx={{
                    marginRight: '36px',
                    ...(isOpen && {display: 'none'}),
                }}
            >
                <MenuIcon/>
            </IconButton>
            <Typography
                component="h1"
                variant="h6"
                color="inherit"
                noWrap
                sx={{flexGrow: 1}}
            >
                Unir-shop
            </Typography>
            <IconButton color="inherit">
                <Badge badgeContent={shopCar.length} color="secondary">
                    <ShoppingCartIcon/>
                </Badge>
            </IconButton>
        </Toolbar>
    )
}