import {PropsWithChildren} from "react";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";

type TYPE_SCRIPT = {
    paddingTop: number,
    paddingBottom: number,
    spacing?: number,
    lg: number,
    gridTemplateColumns: string
}

export default function ComponentSkeleton({
                                     children,
                                     paddingTop,
                                     paddingBottom,
                                     spacing,
                                     lg,
                                     gridTemplateColumns
                                 }: PropsWithChildren<TYPE_SCRIPT>) {
    return (
        <Grid item className="dashboard-grid"
              lg={lg}
              paddingBottom={paddingBottom}
              paddingTop={paddingTop}
              spacing={spacing}
        >
            <Paper
                sx={{
                    gridTemplateColumns: {md: gridTemplateColumns},
                }}
            >
                {children}
            </Paper>
        </Grid>
    )
}