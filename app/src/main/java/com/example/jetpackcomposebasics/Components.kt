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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import androidx.compose.ui.state.ToggleableState
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


//var myTextParams by remember { mutableStateOf("") }
//MyTextWithParameters(myTextParams) { myTextParams = it }
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

@Composable
fun MyProgressBar(){
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(showLoading) {
            CircularProgressIndicator(color = Color.Red)
            LinearProgressIndicator(Modifier.padding(top = 32.dp), color = Color.Red, trackColor = Color.Yellow)
        }
        Button(onClick = { showLoading = !showLoading}) {
            Text(text = "Load")
        }

    }
}
@Composable
fun MyProgressBarAd(){
    var progressStatus by rememberSaveable { mutableFloatStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, progress = progressStatus)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Agrega padding para mayor estética
            horizontalArrangement = Arrangement.Center, // Centra los botones horizontalmente
            verticalAlignment = Alignment.CenterVertically // Opcional: centrar verticalmente si es necesario
        ) {
            Button(onClick = { progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(
                onClick = { progressStatus -= 0.1f },
                modifier = Modifier.padding(start = 8.dp) // Agrega espacio entre los botones
            ) {
                Text(text = "Reducir")
            }
        }
        //LinearProgressIndicator(Modifier.padding(top = 32.dp), color = Color.Red, trackColor = Color.Yellow)
    }
}

//var selectRadioButton by remember { mutableStateOf("Option") }
//MyRadioButtonList(selectRadioBut ton) { selectRadioButton = it }
@Composable
fun MyRadioButtonList(name:String, onItemSelected:(String)->Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(9.dp)) {

        // Crear una lista de opciones
        val options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4"
        )
        // Iterar sobre las opciones para crear cada RadioButton y su texto
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically // Alineación vertical
            ) {
                RadioButton(
                    selected = name == option,
                    onClick = { onItemSelected(option) }
                )
                Spacer(modifier = Modifier.width(8.dp)) // Espaciado entre RadioButton y texto
                Text(text = option)
            }
        }
    }
}



@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { newStatus -> status = newStatus }
        )
    }
}


@Composable
fun MySwich() {
    var state by rememberSaveable { mutableStateOf(true) }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green, // Color del pulgar cuando está marcado
            uncheckedThumbColor = Color.Red,  // Color del pulgar cuando no está marcado
            checkedTrackColor = Color.Blue,  // Color de la pista cuando está marcado
            uncheckedTrackColor = Color.Gray,  // Color de la pista cuando no está marcado


        )
    )
}


@Composable
fun MyCheckBoxBasic() {
    var state by rememberSaveable { mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Green
        )
    )
}


@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), // Opcional: Para que el Row ocupe todo el ancho disponible
        verticalAlignment = Alignment.CenterVertically // Alinea verticalmente al centro
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = it }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Texto 1")
    }
}


@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    // Función para obtener el texto basado en el estado del TriStateCheckbox
    fun getStatusText(status: ToggleableState): String {
        return when (status) {
            ToggleableState.On -> "Checked"
            ToggleableState.Off -> "Unchecked"
            ToggleableState.Indeterminate -> "Indeterminate"
        }
    }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), // Opcional: para que el Row ocupe el ancho disponible
        verticalAlignment = Alignment.CenterVertically // Alinea verticalmente el TriStateCheckbox con otros elementos
    ) {
        TriStateCheckbox(
            state = status,
            onClick = {
                status = when (status) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.Indeterminate
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
            }
        )
        Spacer(modifier = Modifier.width(8.dp)) // Espacio entre el TriStateCheckbox y el siguiente elemento
        Text(
            text = getStatusText(status), // Cambia el texto basado en el estado
            fontSize = 16.sp // Opcional: Cambia el tamaño de fuente del texto
        )
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = true, onClick = { }, enabled = false, colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.teal_200),
                unselectedColor = colorResource(id = R.color.teal_700),
                disabledSelectedColor = colorResource(id = R.color.purple_500)
            )
        )
        Text(text = "Radio Button Example")
    }
}


