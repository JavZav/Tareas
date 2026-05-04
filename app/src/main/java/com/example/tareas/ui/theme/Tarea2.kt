package com.example.tareas.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.example.tareas.R

@Composable
fun pantallaCafe() {
    var cafeCount by remember { mutableStateOf(0) }

    CafeCounter(
        count = cafeCount,
        onAddCup = { cafeCount++ },
        onReset = { cafeCount = 0 }
    )
}
@Composable
fun CafeCounter(
    count: Int,
    onAddCup: () -> Unit,
    onReset: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.cafe_fondo),
            contentDescription = "Fondo de granos de café",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x88000000)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {
            Text(
                text = "Tazas de café: $count",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Cambiamos el texto a blanco para que se lea mejor
                modifier = Modifier.padding(bottom = 16.dp)
            )

            if (count >= 10) {
                Text(
                    text = "¡Demasiada cafeína!",
                    color = Color.Red,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(onClick = onAddCup) {
                    Text(text = "Añadir taza")
                }

                Button(onClick = onReset) {
                    Text(text = "Reiniciar")
                }
            }
        }
    }
}