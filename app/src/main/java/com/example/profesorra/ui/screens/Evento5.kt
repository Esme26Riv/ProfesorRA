package com.example.profesorra.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Evento5(onSiguiente: () -> Unit) {
    var descifrado by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Laboratorio de cómputo", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        Text("Encuentras un monitor encendido con texto parcialmente oculto: 'RA-01 conectado...' ", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))

        if (!descifrado) {
            Button(onClick = { descifrado = true }, modifier = Modifier.fillMaxWidth()) {
                Text("Descifrar mensaje")
            }
        } else {
            Text("Mensaje descifrado: Ve a la biblioteca.", style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(12.dp))
            Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
                Text("Ir a la biblioteca")
            }
        }
    }
}
