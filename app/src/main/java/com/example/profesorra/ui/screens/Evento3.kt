package com.example.profesorra.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profesorra.util.SoundVibrateHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evento3(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val imgRes = context.resources.getIdentifier("chip_burned", "drawable", context.packageName)

    // efecto linterna: vibración breve para simular
    LaunchedEffect(Unit) {
        SoundVibrateHelper.vibrateShort(context, 200L)
    }

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Laboratorio de electrónica", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        if (imgRes != 0) {
            Image(painter = painterResource(id = imgRes), contentDescription = "Chip quemado", modifier = Modifier.size(220.dp))
            Spacer(Modifier.height(12.dp))
        }
        Text("Encuentras una imagen de un chip quemado. RA estaba experimentando con energía mental.", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Siguiente pista")
        }
    }
}
