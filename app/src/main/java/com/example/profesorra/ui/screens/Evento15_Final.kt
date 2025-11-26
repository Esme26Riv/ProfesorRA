package com.example.profesorra.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.profesorra.util.SoundVibrateHelper
import androidx.compose.ui.graphics.Color

@Composable
fun Evento15_Final(onReiniciar: () -> Unit) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        SoundVibrateHelper.playSound(context, context.resources.getIdentifier("boom", "raw", context.packageName))
        SoundVibrateHelper.vibrateShort(context, 800L)
    }

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

            Text(
                "Has liberado al Profesor RA",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            Spacer(Modifier.height(20.dp))

            Text(
                "O tal vez... lo despertaste.",
                color = Color(0xFFCCCCCC)
            )

            Spacer(Modifier.height(40.dp))

            Button(
                onClick = onReiniciar,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666),
                    contentColor = Color.White
                )
            ) {
                Text("Reiniciar historia")
            }
        }
    }
}