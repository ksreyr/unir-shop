import * as React from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import ListSubheader from '@mui/material/ListSubheader';
import DashboardIcon from '@mui/icons-material/Dashboard';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import PeopleIcon from '@mui/icons-material/People';
import {ListItem} from "@mui/material";
import {Link} from 'react-router-dom';
import AddBusinessIcon from '@mui/icons-material/AddBusiness';
import GitHubIcon from '@mui/icons-material/GitHub';
import AllInboxIcon from '@mui/icons-material/AllInbox';

export const mainListItems = (
    <>
        <ListItemButton>
            <ListItem component={Link} to={'/'} disablePadding={true} sx={{color: 'text.primary'}}>
                <ListItemIcon>
                    <DashboardIcon/>
                </ListItemIcon>
                <ListItemText primary="Home"/>
            </ListItem>
        </ListItemButton>
        <ListItemButton>
            <ListItem component={Link} to={'/products'} disablePadding={true} sx={{color: 'text.primary'}}>
                <ListItemIcon>
                    <AddBusinessIcon/>
                </ListItemIcon>
                <ListItemText primary="Products"/>
            </ListItem>
        </ListItemButton>
        <ListItemButton>
            <ListItem component={Link} to={'/shopcar'} disablePadding={true} sx={{color: 'text.primary'}}>
                <ListItemIcon>
                    <ShoppingCartIcon/>
                </ListItemIcon>
                <ListItemText primary="Shop-Car"/>
            </ListItem>
        </ListItemButton>
        <ListItemButton>
            <ListItem component={Link} to={'/orders'} disablePadding={true} sx={{color: 'text.primary'}}>
                <ListItemIcon>
                    <AllInboxIcon/>
                </ListItemIcon>
                <ListItemText primary="Orders"/>
            </ListItem>
        </ListItemButton>
        <ListItemButton>
            <ListItem component={Link} to={'/contact'} disablePadding={true} sx={{color: 'text.primary'}}>
                <ListItemIcon>
                    <PeopleIcon/>
                </ListItemIcon>
                <ListItemText primary="Contact"/>
            </ListItem>
        </ListItemButton>
    </>
);

export const secondaryListItems = (
    <React.Fragment>
        <ListSubheader component="div" inset>
            Repository
        </ListSubheader>
        <ListItemButton>
            <ListItem component={Link} to={'https://github.com/ksreyr/unir-shop'} disablePadding={true}
                      sx={{color: 'text.primary'}}>
                <ListItemIcon>
                    <GitHubIcon/>
                </ListItemIcon>
                <ListItemText primary="Github"/>
            </ListItem>
        </ListItemButton>
    </React.Fragment>
);