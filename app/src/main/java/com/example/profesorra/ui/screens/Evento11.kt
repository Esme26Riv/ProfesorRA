package com.example.profesorra.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Evento11(onSiguiente: () -> Unit) {

    val context = LocalContext.current
    val docRes = context.resources.getIdentifier("doc_confidencial", "drawable", context.packageName)

    // 🔹 Fondo igual que PantallaInicio
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF000000), Color(0xFF0B1F3D))
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

            // 🔹 Título
            Text(
                "Dirección de IADA",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(20.dp))

            // 🔹 Imagen
            if (docRes != 0) {
                Image(
                    painter = painterResource(docRes),
                    contentDescription = "Documento",
                    modifier = Modifier.size(260.dp)
                )
                Spacer(Modifier.height(20.dp))
            }

            // 🔹 Texto descriptivo
            Text(
                "Proyecto RA-01 — Confidencial.\nEl experimento se salió de control.",
                color = Color(0xFFCCCCCC),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(40.dp))

            // 🔹 Botón estilo misterioso
            Button(
                onClick = onSiguiente,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666),
                    contentColor = Color.White
                )
            ) {
                Text("Continuar")
            }
        }
    }
}

