package com.example.jetpackcomposebasics

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecyclerView(){
    val myList = listOf("Item 1","Item 2","Item 3")
    LazyColumn {
        item{Text(text="Header")}
        items(myList){
            Text(text=it)
        }
        item{Text(text="Footer")}
    }
}