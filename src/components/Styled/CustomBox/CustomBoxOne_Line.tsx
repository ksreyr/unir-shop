import { styled } from '@mui/material/styles';

const CustomBoxOne_Line = styled('div')(() => ({
    width: '100%',
    gridColumn: '1 / -1',
}));

export const CustomBox_Main = styled('div')(() => ({
    flexGrow: 1,
    height: '100vh',
}));
export const CustomBox = styled('div')(() => ({
    display: 'flex'
}));

export  const CustomBox_Card_Image = styled('img')(() => ({
    width: 60,
    height: 60,
    objectFit: 'cover',
}));

export default CustomBoxOne_Line;
