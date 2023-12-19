import {Dispatch, PropsWithChildren} from 'react';
import MUICard from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import {PRODUCT_TYPE} from "../../models/models.tsx";
import {ACTION_TYPE_SHOPCAR} from "../../context/ShopCar/ShopCar.tsx";
import {ExpandMore} from "./ExpandMore.tsx";
import {useCard} from "./hook.ts";
import {CustomBox_Card_Image} from "../Styled/CustomBox/UnirBox.tsx";
import QuestionMarkIcon from '@mui/icons-material/QuestionMark';
import {Box, CircularProgress} from "@mui/material";
import {useNavigate} from "react-router-dom";

type CARD_TYPE = {
    product: PRODUCT_TYPE,
    height?: string,
    dispatcher: (dispatchAction: (type: "ADD" | "DELETE") => (dispatch: Dispatch<ACTION_TYPE_SHOPCAR>) => void) => void
}


export default function Card({product, height, dispatcher, children}: PropsWithChildren<CARD_TYPE>) {
    const {
        handleClick,
        handleExpandClick,
        expanded,
        isLoading,
        handleImageLoad
    } = useCard(product, dispatcher)
    const navigate = useNavigate();
    return (
        <MUICard>
            <CardHeader
                avatar={
                    <CustomBox_Card_Image
                        src={product.vendedor}
                        alt="Cat Avatar"
                    />
                }
                title={product.nombre}
                subheader={"Categoria: " + product.categoria}

            />

            {isLoading && (<Box sx={{display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
                <CircularProgress/> </Box>)}

            <CardMedia
                component="img"
                height={height ?? "290vh"}
                image={product.imagen + new Date().getTime()}
                alt="Item Foto"
                onLoad={handleImageLoad}
                sx={{display: isLoading ? 'none' : 'block'}}
            />

            <CardContent>
                <Typography variant="body2" color="text.secondary">
                    {product.descripcionCorta}
                </Typography>
                <Typography variant={"body2"}>{"Precio: " + product.precio}</Typography>
            </CardContent>
            <CardActions disableSpacing>
                <IconButton
                    aria-label="add to favorites"
                    onClick={handleClick}>
                    {children}
                </IconButton>
                <IconButton aria-label="share" onClick={() => navigate(`/product/${product.id}`)}>
                    <QuestionMarkIcon/>
                </IconButton>
                <ExpandMore
                    expand={expanded}
                    onClick={handleExpandClick}
                    aria-expanded={expanded}
                    aria-label="show more"
                >
                    <ExpandMoreIcon/>
                </ExpandMore>
            </CardActions>
            <Collapse in={expanded} timeout="auto" unmountOnExit>
                <CardContent>
                    <Typography>
                        {product.descripcionLarga}
                    </Typography>
                </CardContent>
            </Collapse>
        </MUICard>
    );
}