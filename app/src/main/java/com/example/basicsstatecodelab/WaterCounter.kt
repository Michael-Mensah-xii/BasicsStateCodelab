package com.example.basicsstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text


@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    // track changes made to count and add rememberSaveable to store and maintain value across recompositions
    var count by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier)
}


@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        // if statement to show text if counter is > 0
        if (count > 0) {
            Text(text = "You've had $count glasses. ")
        }


        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            // disable button if counter is less than 10
            enabled = count < 10
        ) {
            Text(text = "Add one")

        }
    }
}

