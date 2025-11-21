package com.example.profesorra.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.profesorra.util.SoundVibrateHelper

@Composable
fun Evento2(onSiguiente: () -> Unit) {
    val context = LocalContext.current

    // reproducir sonido de pasos al mostrar la pantalla (opcional)
    LaunchedEffect(Unit) {
        val res = context.resources.getIdentifier("steps", "raw", context.packageName)
        if (res != 0) SoundVibrateHelper.playSound(context, res)
    }

    Column(
        Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pasillo principal", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        Text("Se escuchan pasos detrás de ti… pero el pasillo está vacío.\nPista: Busca el laboratorio de electrónica.", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(30.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Ir al laboratorio de electrónica")
        }
    }
}
