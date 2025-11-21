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

@Composable
fun Evento6(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val imgRes = context.resources.getIdentifier("old_book", "drawable", context.packageName)

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Biblioteca", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        if (imgRes != 0) {
            Image(painter = painterResource(id = imgRes), contentDescription = "Libro viejo", modifier = Modifier.size(200.dp))
            Spacer(Modifier.height(12.dp))
        }
        Text("Dentro de este libro hay una hoja firmada por RA. Pista: Siguiente ubicación: patio central.", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Ir al patio central")
        }
    }
}
