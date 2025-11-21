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
import kotlinx.coroutines.delay

@Composable
fun Evento12(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val glitchRes = context.resources.getIdentifier("glitch", "drawable", context.packageName)
    var showing by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        // animación corta de "glitch"
        delay(1500)
        showing = false
    }

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pasillo lateral", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        if (showing && glitchRes != 0) {
            Image(painter = painterResource(id = glitchRes), contentDescription = "Glitch", modifier = Modifier.size(260.dp))
            Spacer(Modifier.height(12.dp))
        }
        Text("El celular empieza a escribir solo: 'Yo sigo aquí…'", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Seguir")
        }
    }
}
