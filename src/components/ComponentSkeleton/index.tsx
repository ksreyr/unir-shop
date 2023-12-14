import {PropsWithChildren} from "react";
import Grid, {GridProps} from "@mui/material/Grid";
import Paper from "@mui/material/Paper";

type TYPE_SCRIPT = {
    paddingTop: number,
    paddingBottom: number,
    gridTemplateColumns: string
} & GridProps

export default function ComponentSkeleton({
                                     children,
                                     paddingTop,
                                     paddingBottom,
                                     spacing,
                                     gridTemplateColumns,
                                     ...props
                                 }: PropsWithChildren<TYPE_SCRIPT>) {
    return (
        <Grid item className="dashboard-grid"
              {...props}
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