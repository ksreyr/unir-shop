import Template from "../Template.tsx";
import ComponentSkeleton from "../../components/ComponentSkeleton";
import Title from "../../components/Title";
import Typography from "@mui/material/Typography";
import ListItemButton from "@mui/material/ListItemButton";
import {ListItem} from "@mui/material";
import {Link} from "react-router-dom";
import ListItemIcon from "@mui/material/ListItemIcon";
import GitHubIcon from "@mui/icons-material/GitHub";
import ListItemText from "@mui/material/ListItemText";
import LinkedInIcon from '@mui/icons-material/LinkedIn';

export default function Contact(){
    return(<Template>
        <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={12} sm={12} md={12} xs={12} gridTemplateColumns={'1fr'}>
            <Title>
                Contacto
            </Title>
            <Typography>
                Santiago Rey
            </Typography>
            <ListItemButton>
                <ListItem component={Link} to={'https://github.com/ksreyr'} disablePadding={true} sx={{color: 'text.primary'}}>
                    <ListItemIcon>
                        <GitHubIcon/>
                    </ListItemIcon>
                    <ListItemText primary="Github"/>
                </ListItem>
            </ListItemButton>
            <ListItemButton>
                <ListItem component={Link} to={'https://www.linkedin.com/in/santiago-rey/'} disablePadding={true} sx={{color: 'text.primary'}}>
                    <ListItemIcon>
                        <LinkedInIcon/>
                    </ListItemIcon>
                    <ListItemText primary="linkedin"/>
                </ListItem>
            </ListItemButton>
        </ComponentSkeleton>
    </Template>)
}