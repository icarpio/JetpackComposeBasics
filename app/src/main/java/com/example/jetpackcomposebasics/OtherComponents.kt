package com.example.jetpackcomposebasics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(18.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.teal_200),
            contentColor = Color.White
        ),
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Texto 1")
            Text(text = "Texto 2")
            Text(text = "Texto 3")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier.padding(20.dp),
        badge = {
            Badge(modifier = Modifier.offset(x = (-2).dp, y = 8.dp)) {
                Text("15") // Puedes poner el contenido del badge aquí
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.Star, contentDescription = "")
            Text(text = "Texto")
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), color = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("Select a dessert") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("Brownie", "Panacota", "Natillas", "Arroz con leche", "Fruta")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { }, // El campo es solo lectura
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = !expanded } // Alterna el menú desplegable
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }, // Cierra el menú
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = { Text(text = dessert)},
                    onClick = {
                        expanded=false
                        selectedText=dessert})
            }
        }
    }
}


