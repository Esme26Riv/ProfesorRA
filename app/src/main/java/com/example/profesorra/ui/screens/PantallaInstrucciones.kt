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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInstrucciones(onSiguiente: () -> Unit) {

    // 🔹 Fondo con degradado oscuro, igual que en PantallaInicio
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

            // 🔹 Título con efecto de sombra y color claro para resaltar
            Text(
                "Cómo jugar",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFEDEDED),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(20.dp))

            // 🔹 Texto de instrucciones en color gris claro, centrado
            Text(
                "1) Muévete por el campus.\n" +
                        "2) Usa la cámara y el GPS cuando te lo indiquen.\n" +
                        "3) En cada lugar verás pistas; sigue el orden para desbloquear la historia. \n" +
                        "4) Iniciamos en el Aula 5V\n",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFCCCCCC),
                lineHeight = 22.sp
            )

            Spacer(Modifier.height(36.dp))

            // 🔹 Botón translúcido con estilo misterioso, igual que en PantallaInicio
            Button(
                onClick = onSiguiente,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666), // translúcido
                    contentColor = Color.White
                )
            ) {
                Text(
                    "Empezar aventura",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            }
        }
    }
}
