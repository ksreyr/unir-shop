import MUIButton, {ButtonProps} from '@mui/material/Button';

export default function Button({text, ...props}: { text: string } & ButtonProps) {
    return <MUIButton variant="contained" {...props}>{text}</MUIButton>;
}