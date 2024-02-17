import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
import {SxProps} from "@mui/material";

type COPYRIGHT_TYPE = { sx?: SxProps }

export default function Copyright(props: COPYRIGHT_TYPE) {
    return (
        <Typography variant="body2" color="text.secondary" align="center" {...props}>
            {'Copyright © '}
            <Link color="inherit" href="https://github.com/ksreyr/unir-shop">
                shop-unir
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}