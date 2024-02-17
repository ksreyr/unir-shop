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
import {ACTION_TYPE_SHOPCAR} from "../../context/ShopCar/ShopCar.tsx";
import {ExpandMore} from "./ExpandMore.tsx";
import {useCard} from "./hook.ts";
import QuestionMarkIcon from '@mui/icons-material/QuestionMark';
import {Box, CircularProgress} from "@mui/material";
import {useNavigate} from "react-router-dom";
import {BOOK_TYPE} from "../../models/models.tsx";

type CARD_TYPE = {
    product: BOOK_TYPE,
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
                title={product.bookName.bookName}
                subheader={ product.author.author}
            />

            {isLoading && (<Box sx={{display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
                <CircularProgress/> </Box>)}

            <CardMedia
                component="img"
                height={height ?? "290vh"}
                image={product.image.url + new Date().getTime()}
                alt="Item Foto"
                onLoad={handleImageLoad}
                sx={{display: isLoading ? 'none' : 'block'}}
            />

            <CardContent>
                <Typography variant="body2" color="text.secondary">
                    {"ISBN: "+product.isbn.isbn}
                </Typography>
                <Typography variant={"body2"}>{"Lenguaje: " + product.language.language}</Typography>
            </CardContent>
            <CardActions disableSpacing>
                <IconButton
                    aria-label="add to favorites"
                    onClick={handleClick}>
                    {children}
                </IconButton>
                <IconButton aria-label="share" onClick={() => navigate(`/product/${product.bookId}`)}>
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
                        {product.bookId}
                    </Typography>
                </CardContent>
            </Collapse>
        </MUICard>
    );
}