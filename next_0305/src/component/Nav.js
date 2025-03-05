'use client';
import { Box, Grid2 } from "@mui/material";
import { useState } from "react";



export default function Nav(){
    const navItem = ['Products','Color cosmetics', 'Skin cosmetics','About'];
    const [anchoEl,setAnchoEl]= useState(null);
    return(
        <nav id="header" style={{textAlign:'center'}}>
            <Grid2 container my={2}>
                {navItem.map((item, i)=>(
                    <Grid2 item key={i} size={{xs:12,sm:3}}>
                        <Box bgcolor='primary.light' p={2}>
                            {item}
                        </Box>
                    </Grid2>
                ))}
            </Grid2>
        </nav> 
    );
}