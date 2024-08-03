package com.example.jetpackcomposebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun ConstraintExample(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed,boxBlue,boxGreen,boxCyan) = createRefs()
        Box(Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            }){
        }
        Box(Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(boxRed.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            }){
        }
        Box(Modifier.size(125.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
            }){
        }
        Box(Modifier.size(125.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
            }){
        }
    }
}