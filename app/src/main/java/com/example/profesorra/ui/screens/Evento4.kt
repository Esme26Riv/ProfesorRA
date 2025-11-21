package com.example.profesorra.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.profesorra.util.SoundVibrateHelper

@Composable
fun Evento4(onSiguiente: () -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val res = context.resources.getIdentifier("whispers", "raw", context.packageName)
        if (res != 0) SoundVibrateHelper.playSound(context, res)
        SoundVibrateHelper.vibrateShort(context, 300L)
    }

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cafetería", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        Text("El profesor RA solía venir aquí a medianoche. ¿Escuchas eso?", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Ir al laboratorio de cómputo")
        }
    }
}
