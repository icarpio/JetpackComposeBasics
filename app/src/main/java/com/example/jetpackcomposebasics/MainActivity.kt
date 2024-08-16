package com.example.jetpackcomposebasics

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                window.statusBarColor = MaterialTheme.colorScheme.primary.toArgb() // Cambiar el color de la barra de estado
                Scaffold {
                    var show by remember { mutableStateOf(false) }
                    var selectedOption by remember { mutableStateOf("") }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center // Centra el contenido en la caja
                    ) {
                        Button(onClick = {show = true}) {
                            Text(text = "Mostrar Dialogo")
                        }
                        ConfirmationDialog(
                            show = show,
                            onDismiss = {show = false},
                            onConfirm = { selected ->
                                selectedOption = selected // Manejar el valor seleccionado
                                show = false // Cerrar el diálogo
                            })
                    }
                }
            }
        }
    }
}




