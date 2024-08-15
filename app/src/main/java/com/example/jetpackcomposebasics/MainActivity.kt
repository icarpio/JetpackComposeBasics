package com.example.jetpackcomposebasics

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                //window.statusBarColor = Color.Magenta.toArgb()
                window.statusBarColor =
                    MaterialTheme.colorScheme.primary.toArgb() // Cambiar el color de la barra de estado
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    //var myTextParams by remember { mutableStateOf("") }
                    //MyTextWithParameters(myTextParams) { myTextParams = it }
                    val myOptions = getOptions(listOf("Option 1","Option 2","Option 3"))
                    Column {
                        MyTriStatusCheckBox()
                        myOptions.forEach{
                            MyCheckBoxWithTextCompleted(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getOptions(titles:List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = {newStatus -> status = newStatus}
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


        ))
}


@Composable
fun MyCheckBoxBasic() {
    var state by rememberSaveable { mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = {state = !state},
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Green
        ))
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
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), // Opcional: Para que el Row ocupe todo el ancho disponible
        verticalAlignment = Alignment.CenterVertically // Alinea el Checkbox y el Text verticalmente en el centro
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(it) } // Cambiar al nuevo valor de estado
        )
        Spacer(modifier = Modifier.width(8.dp)) // Espacio entre Checkbox y Text
        Text(text = checkInfo.title)
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



