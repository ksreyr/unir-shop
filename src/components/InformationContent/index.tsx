import * as React from 'react';
import {PropsWithChildren} from "react";


export default function InformationContent({children}:PropsWithChildren) {
    return (
        <React.Fragment>
            {children}
        </React.Fragment>
    );
}