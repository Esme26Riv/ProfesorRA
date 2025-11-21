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
fun Evento13(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val deskRes = context.resources.getIdentifier("desk_profesor", "drawable", context.packageName)

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Oficina del profesor RA", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        if (deskRes != 0) {
            Image(painter = painterResource(id = deskRes), contentDescription = "Escritorio", modifier = Modifier.size(260.dp))
            Spacer(Modifier.height(12.dp))
        }
        Text("Encuentras su libreta con ecuaciones y dibujos. Pista: Regresa al salón del grupo V.", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Regresar al salón")
        }
    }
}
