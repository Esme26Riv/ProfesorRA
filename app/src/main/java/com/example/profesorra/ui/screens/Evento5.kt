package com.example.profesorra.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Evento5(onSiguiente: () -> Unit) {
    var descifrado by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF000000), Color(0xFF0B1F3D))
                )
            )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Laboratorio de cómputo",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Encuentras un monitor encendido con texto parcialmente oculto: 'RA-01 conectado...' ",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFCCCCCC),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(24.dp))

            if (!descifrado) {
                Button(
                    onClick = { descifrado = true },
                    modifier = Modifier.fillMaxWidth().height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF666666),
                        contentColor = Color.White
                    )
                ) {
                    Text("Descifrar mensaje", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
            } else {
                Text(
                    "Mensaje descifrado: Ve a la biblioteca.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFFCCCCCC),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = onSiguiente,
                    modifier = Modifier.fillMaxWidth().height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF666666),
                        contentColor = Color.White
                    )
                ) {
                    Text("Ir a la biblioteca", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
            }
        }
    }
}
