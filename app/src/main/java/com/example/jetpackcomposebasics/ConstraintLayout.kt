package com.example.jetpackcomposebasics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Green)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter) {
            Text(text = name) // Add some content to the inner Box
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MyColumn(){
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text("Ejemplo1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo2",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp))
        Text("Ejemplo1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo2",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp))
    }
}


@Composable
fun MyRow(){
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())) {
        Text("Ejemplo1",
            Modifier
                .background(Color.Red)
                .width(100.dp))
        Text(text = "Ejemplo2",
            Modifier
                .background(Color.Blue)
                .width(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Cyan)
                .width(100.dp))
        Text(text = "Ejemplo4",
            Modifier
                .background(Color.Cyan)
                .width(100.dp))
        Text(text = "Ejemplo4",
            Modifier
                .background(Color.Magenta)
                .width(100.dp))
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red), contentAlignment = Alignment.TopCenter){
            Text(text = "Texto 1")
        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)){
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center){
                Text(text = "Texto 2")
            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Magenta), contentAlignment = Alignment.Center){
                Text(text = "Texto 3")
            }
        }
        MySpacer(size = 30)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow), contentAlignment = Alignment.BottomCenter){
            Text(text = "Texto 4")
        }
    }
}

@Composable
fun MySpacer(size:Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Preview(showBackground = true)
@Composable
fun MyStateExample(){
    var counter by rememberSaveable { mutableIntStateOf(0) }
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter += 1 }) {
            Text(text = "+")
        }
        Button(onClick = { counter -= 1 }) {
            Text(text = "-")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MyText() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = colorResource(id = R.color.teal_700))
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.Underline)
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)

        //TextField
        var myText by remember { mutableStateOf("") }
        TextField(value = myText, onValueChange = { myText = it })

        //TextFieldAdavance
        var myTextAd by remember { mutableStateOf("") }
        TextField(
            value = myTextAd,
            onValueChange = {
                myTextAd =
                    if (it.contains("a")) {
                        it.replace("a", "")
                    } else {
                        it
                    }
            },
            label = { Text(text = "Introduce un texto") })

        //Outlined Text
        var myOutlined by remember { mutableStateOf("") }
        OutlinedTextField(
            value = myOutlined,
            onValueChange = { myOutlined = it },
            Modifier.padding(24.dp),
            label = { Text(text = "Text Outlined")},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Blue
            )
        )
    }
}

@Composable
fun MyTextWithParameters(name:String, onValueChanged:(String) -> Unit) {
    TextField(value = name, onValueChange = {onValueChanged(it)})
}

@Composable
fun MyButton(){
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        Button(
            onClick = {enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, // Cambia el color de fondo del botón
                contentColor = Color.White   // Cambia el color del contenido (texto o íconos)
            ),
            border = BorderStroke(5.dp, Color.Yellow)
        ) {
            Text(text = "Click")
        }

        //Outlined Button
        OutlinedButton(
            onClick = {},
            Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,  // Fondo cuando el botón está deshabilitado
                disabledContentColor = Color.DarkGray, // Texto cuando el botón está deshabilitado
            ),
            border = BorderStroke(2.dp, Color.Yellow), // Borde rojo

        ) {
            Text(text = "Click Outlined")
        }

        //Text Button
        TextButton(onClick = {  }) {
            Text(text = "Text Button")
        }
    }
}

// Imágenes apiladas verticalmente (una sobre la otra)
@Composable
fun MyImages() {
    Column(
        modifier = Modifier.fillMaxSize(), // Llenar toda la pantalla
        horizontalAlignment = Alignment.CenterHorizontally, // Centrar horizontalmente
        verticalArrangement = Arrangement.Center // Centrar verticalmente
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Imagen 1",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Imagen 2",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
    }
}

//Imágenes colocadas horizontalmente (una al lado de la otra)
@Composable
fun MyImages2() {
    Row(
        modifier = Modifier.fillMaxSize(), // Llenar toda la pantalla
        horizontalArrangement = Arrangement.Center, // Centrar horizontalmente
        verticalAlignment = Alignment.CenterVertically // Centrar verticalmente
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Imagen 1",
            modifier = Modifier
                .padding(16.dp)
                .weight(1f), // Tomar espacio proporcional
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Imagen 2",
            modifier = Modifier
                .padding(16.dp)
                .weight(1f), // Tomar espacio proporcional
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MyIcon(){
    Icon(contentDescription = "Image Icon", imageVector = Icons.Rounded.Star, tint = Color.Blue)
}
@Composable
fun MyImageCircle(){
    Image(
        painter = painterResource(id = R.drawable.image),
        contentDescription = "Imagen 1",
        modifier = Modifier
            .padding(16.dp)
            .clip(
                //RoundedCornerShape(50f)
                CircleShape
            )
            .border(30.dp, Color.Red, CircleShape),
        contentScale = ContentScale.Crop
    )
}