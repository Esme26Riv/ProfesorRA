package com.example.profesorra.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
        delay(1500)
        showing = false
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Pasillo lateral",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            Spacer(Modifier.height(20.dp))

            if (showing && glitchRes != 0) {
                Image(
                    painter = painterResource(glitchRes),
                    contentDescription = "Glitch",
                    modifier = Modifier.size(260.dp)
                )
                Spacer(Modifier.height(20.dp))
            }

            Text(
                "El celular empieza a escribir solo:\n 'Yo sigo aquí…'",
                color = Color(0xFFCCCCCC),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(Modifier.height(40.dp))

            Button(
                onClick = onSiguiente,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666),
                    contentColor = Color.White
                )
            ) {
                Text("Seguir")
            }
        }
    }
}