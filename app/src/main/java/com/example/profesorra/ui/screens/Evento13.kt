package com.example.profesorra.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun Evento13(onSiguiente: () -> Unit) {

    val context = LocalContext.current
    val deskRes = context.resources.getIdentifier("desk_profesor", "drawable", context.packageName)

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
                "Oficina del profesor RA",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(Modifier.height(20.dp))

            if (deskRes != 0) {
                Image(
                    painter = painterResource(deskRes),
                    contentDescription = "Escritorio",
                    modifier = Modifier.size(260.dp)
                )
                Spacer(Modifier.height(20.dp))
            }

            Text(
                "Encuentras su libreta con ecuaciones y dibujos.\nPista: Regresa al salón del grupo V.",
                color = Color(0xFFCCCCCC),
                textAlign = TextAlign.Center
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
                Text("Regresar al salón")
            }
        }
    }
}