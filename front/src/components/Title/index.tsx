import * as React from 'react';
import Typography from '@mui/material/Typography';
import {CustomBoxOne_Template} from "../Styled/CustomBox/UnirBox.tsx";

interface TitleProps {
    children?: React.ReactNode;
}

export default function Title(props: TitleProps) {
    return (
        <CustomBoxOne_Template>
            <Typography component="h2" variant="h6" color="primary" gutterBottom>
                {props.children}
            </Typography>
        </CustomBoxOne_Template>
    );
}