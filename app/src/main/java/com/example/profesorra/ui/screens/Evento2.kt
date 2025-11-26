package com.example.profesorra.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profesorra.util.SoundVibrateHelper

@Composable
fun Evento2(onSiguiente: () -> Unit) {
    val context = LocalContext.current

    // 🔹 Reproducir sonido de pasos al mostrar la pantalla (opcional)
    LaunchedEffect(Unit) {
        val res = context.resources.getIdentifier("steps", "raw", context.packageName)
        if (res != 0) SoundVibrateHelper.playSound(context, res)
    }

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
                "Pasillo principal",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Se escuchan pasos detrás de ti… pero el pasillo está vacío.\nPista: Busca el laboratorio de electrónica.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFCCCCCC),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(36.dp))

            Button(
                onClick = onSiguiente,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666),
                    contentColor = Color.White
                )
            ) {
                Text("Ir al laboratorio de electrónica", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            }
        }
    }
}
