package com.example.jetpackcomposebasics
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                //window.statusBarColor = Color.Magenta.toArgb()
                window.statusBarColor = MaterialTheme.colorScheme.primary.toArgb() // Cambiar el color de la barra de estado
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    //var myTextParams by remember { mutableStateOf("") }
                    //MyTextWithParameters(myTextParams) { myTextParams = it }
                    MyProgressBarAd()
                }
            }
        }
    }
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