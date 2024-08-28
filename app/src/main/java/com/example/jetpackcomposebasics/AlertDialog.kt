package com.example.jetpackcomposebasics

import android.graphics.drawable.BitmapDrawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo Dialogo") },
            text = { Text(text = "Descripcion Dialogo :)") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancel")
                }
            })
    }
}

/* var show by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center // Centra el contenido en la caja
                    ) {
                        Button(onClick = {show = true}) {
                            Text(text = "Mostrar Dialogo")
                        }
                        MyDialog(
                            show = show,
                            onDismiss = {show = false},
                            onConfirm = { Log.i("AlertDialog","Click in Confirm")} )
                    }
* */

@Composable
fun SimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ))
        {
            //Contenido
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Titulo Dialogo Simple")
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit){
    if(show){
        Dialog(onDismissRequest = {onDismiss()}) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            )
            {
                MyTitleDialog(text = "Set backup account")
                AccountItem(email = "MargaritaIlla@gmail.com", drawable = R.drawable.avatar1)
                AccountItem(email = "Mariademont@gmail.com", drawable = R.drawable.avatar2)
                AccountItem(email = "Add new account", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun MyTitleDialog(text:String,modifier: Modifier = Modifier.padding(bottom = 12.dp)){
    Text(
        text = text, 
        fontWeight = FontWeight.SemiBold, 
        fontSize = 20.sp, 
        modifier = modifier
    )
}

@Composable
fun AccountItem(email:String,@DrawableRes drawable: Int){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable), 
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp,color=Color.Gray, modifier = Modifier.padding(8.dp))
    }
}


/*
                        var show by remember { mutableStateOf(false) }
                        var selectedOption by remember { mutableStateOf("") }
                        Button(onClick = {show = true}) {
                            Text(text = "Mostrar Dialogo")
                        }
                        ConfirmationDialog(
                            show = show,
                            onDismiss = {show = false},
                            onConfirm = { selected ->
                                selectedOption = selected // Manejar el valor seleccionado
                                show = false // Cerrar el diálogo
                            })*/
@Composable
fun ConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit // Añadir un callback para el botón OK
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    MyTitleDialog(text = "Phone Ringtone")
                    Divider(color = Color.DarkGray, thickness = 1.dp)

                    var status by remember { mutableStateOf("") }

                    MyRadioButtonList(status) { status = it }

                    Divider(color = Color.DarkGray, thickness = 1.dp)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = {
                            onDismiss() // Cerrar el diálogo
                        }) {
                            Text(text = "Cancel")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        TextButton(onClick = {
                            onConfirm(status) // Pasar el valor seleccionado
                            onDismiss() // Cerrar el diálogo
                        }) {
                            Text(text = "OK")
                        }
                    }
                }
            }
        }
    }
}