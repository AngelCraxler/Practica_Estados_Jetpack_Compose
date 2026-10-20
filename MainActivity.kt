package com.example.hellowordcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InstagramProfile()
                }
            }
        }
    }
}

@Composable
fun InstagramProfile() {

    // Estado reactivo para el contador de likes
    var likes by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(16.dp)
    ) {
        item {
            // Imagen de fondo
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.craxler),
                contentDescription = "logo AristiDevs"
            )

            // Fila con el corazón y el contador
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "like",
                    modifier = Modifier.clickable {
                        likes = likes + 1
                    }
                )
                Text(
                    text = likes.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            // Nombre grande y centrado
            Text(
                text = "AristiDevs",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // Descripción
            Text(
                text = "Android Dev",
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "6 años exp",
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "Stack: Java Kotlin",
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramProfilePreview() {
    MaterialTheme {
        InstagramProfile()
    }
}
