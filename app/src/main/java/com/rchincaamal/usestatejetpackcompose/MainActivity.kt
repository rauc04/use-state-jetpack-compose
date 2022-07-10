package com.rchincaamal.usestatejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UseStateSample()
        }
    }
}

@Composable
fun UseStateSample() {
    var counter by rememberSaveable { mutableStateOf(0) }

    Column {
        Text(
            text = "Count: $counter",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Divider(thickness = 20.dp, color = Color.Transparent)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CounterButton(
                text = "Add",
                updateCount = {
                    counter++
                }
            )

            CounterButton(
                text = "Subtract",
                updateCount = {
                    counter--
                }
            )
        }
    }
}

@Composable
fun CounterButton(text: String, updateCount: () -> Unit) {
    Button(onClick = { updateCount() }) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UseStateSample()
}