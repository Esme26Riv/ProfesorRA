package com.example.profesorra.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.profesorra.util.SoundVibrateHelper

@Composable
fun Evento15_Final(onReiniciar: () -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        // sonido y vibración final
        SoundVibrateHelper.playSound(context, context.resources.getIdentifier("boom", "raw", context.packageName))
        SoundVibrateHelper.vibrateShort(context, 800L)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Has liberado al Profesor RA", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        Text("O tal vez... lo despertaste.", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onReiniciar) {
            Text("Reiniciar historia")
        }
    }
}
