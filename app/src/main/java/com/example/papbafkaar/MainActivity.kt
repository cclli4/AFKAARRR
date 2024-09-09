package com.example.papbafkaar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.papbafkaar.ui.theme.PAPBAFKAARTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAPBAFKAARTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var inputName by remember { mutableStateOf("") }
    var inputDescription by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Card with Name and Description
        if (name.isNotEmpty() && description.isNotEmpty()) {
            InfoCard(name = name, description = description)
        }
        // Input Field for Name
        TextField(
            value = inputName,
            onValueChange = { inputName = it },
            label = { Text("Masukkan Nama Kamu") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Input Field for Description
        TextField(
            value = inputDescription,
            onValueChange = { inputDescription = it },
            label = { Text("Ceritakan Hobimu") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(
            onClick = {
                name = inputName
                description = inputDescription
            }
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}

@Composable
fun InfoCard(name: String, description: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Nama: $name", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Hobi: $description", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAPBAFKAARTheme {
        MyScreen()
    }
}