package com.example.profesorra.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Evento1(onSiguiente: () -> Unit) {

    // 🔹 Fondo con degradado oscuro, igual que PantallaInicio
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
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // 🔹 Título con color blanco y negrita
            Text(
                "Aula 5V",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(16.dp))

            // 🔹 Descripción con color gris claro
            Text(
                "Encuentras una frase en la pizarra: “El proyecto RA nunca debió continuar…”",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFCCCCCC),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(36.dp))

            // 🔹 Botón con estilo oscuro translúcido
            Button(
                onClick = onSiguiente,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666),
                    contentColor = Color.White
                )
            ) {
                Text("Siguiente pista", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            }
        }
    }
}
