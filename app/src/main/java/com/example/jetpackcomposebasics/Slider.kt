package com.example.jetpackcomposebasics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SliderBasic(){
    Column{
        var sliderPos by remember { mutableFloatStateOf(0f) }
        Slider(value = sliderPos, onValueChange = {sliderPos = it })
        Text(text = sliderPos.toString())
    }
}

@Composable
fun SliderAdvanced(){
    Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally){
        var sliderPos by remember { mutableFloatStateOf(0f) }
        var valueCompleted by remember { mutableStateOf("") }
        Slider(
            value = sliderPos,
            onValueChange = {sliderPos = it },
            onValueChangeFinished = {valueCompleted = sliderPos.toString()},
            valueRange = 0f..10f,
            steps = 9
            //enabled = false
        )
        Text(text = valueCompleted)
    }
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..10f) } // Mantiene el rango como un estado mutable

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Range: ${sliderPosition.start} to ${sliderPosition.endInclusive}")

        Spacer(modifier = Modifier.height(16.dp))

        RangeSlider(
            value = sliderPosition, // Utiliza el rango actual como valor
            onValueChange = { sliderPosition = it }, // Actualiza el rango cuando cambia
            valueRange = 0f..10f, // Define el rango de valores permitidos
            steps = 9 // Define el número de pasos
        )
    }
}
        