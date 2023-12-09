import * as React from 'react';
import Typography from '@mui/material/Typography';
import CustomBoxOne_Line from "../Styled/CustomBox/CustomBoxOne_Line.tsx";

interface TitleProps {
    children?: React.ReactNode;
}

export default function Title(props: TitleProps) {
    return (
        <CustomBoxOne_Line>
            <Typography component="h2" variant="h6" color="primary" gutterBottom>
                {props.children}
            </Typography>
        </CustomBoxOne_Line>
    );
}