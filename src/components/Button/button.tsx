import MUIButton from '@mui/material/Button';

export default function Button({text}: { text: string }) {
    return <MUIButton variant="contained">{text}</MUIButton>;
}