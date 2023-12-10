import AppBar from "../components/AppBar";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Drawer from "../components/Drawer";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import Divider from "@mui/material/Divider";
import List from "@mui/material/List";
import {mainListItems, secondaryListItems} from "../components/Drawer/MenuList/listItems.tsx";
import {PropsWithChildren, useContext} from "react";
import Container from "@mui/material/Container/Container";
import Copyright from "../components/Copyright/index..tsx";
import Grid from "@mui/material/Grid/Grid";
import Header from "../components/Header/index.tsx";
import {DrawContext} from "../context/Drawer/DrawerContext.tsx";
import {CustomBox, CustomBox_Main} from "../components/Styled/CustomBox/CustomBoxOne_Line.tsx";

function Template({children}: PropsWithChildren) {

    const {isOpen, changeState} = useContext(DrawContext);

    const toggleDrawer = () => {
        changeState({type: "CHANGE"})
    }

    return (
        <CustomBox>
            <AppBar position="absolute" open={isOpen} sx={{padding:0,borderRadius:'0px'}}>
                <Header isOpen={isOpen} toggleDrawer={toggleDrawer} />
            </AppBar>
            <Drawer variant="permanent" open={isOpen}>
                <Toolbar>
                    <IconButton onClick={toggleDrawer}>
                        <ChevronLeftIcon/>
                    </IconButton>
                </Toolbar>
                <Divider/>
                <List component="nav" >
                    {mainListItems}
                    <Divider/>
                    {secondaryListItems}
                </List>
            </Drawer>
            <CustomBox_Main >
                <Toolbar/>
                <Container maxWidth="lg">
                    <Grid container className="dashboard-grid" paddingBottom={2} paddingTop={4} spacing={3}>
                        {children}
                    </Grid>
                    <Copyright sx={{pt: 4}}/>
                </Container>
            </CustomBox_Main>
        </CustomBox>

    )
}

export default Template
