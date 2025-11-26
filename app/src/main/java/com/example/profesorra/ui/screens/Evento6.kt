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
import androidx.compose.ui.unit.sp

@Composable
fun Evento6(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val imgRes = context.resources.getIdentifier("old_book", "drawable", context.packageName)

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
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                "Biblioteca",
                fontSize = 28.sp,
                color = Color(0xFFEDEDED)
            )

            Spacer(Modifier.height(18.dp))

            if (imgRes != 0) {
                Image(
                    painter = painterResource(id = imgRes),
                    contentDescription = "Libro viejo",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(Modifier.height(14.dp))
            }

            Text(
                "Dentro de este libro hay una hoja firmada por RA.\nPista: Siguiente ubicación: patio central.",
                color = Color(0xFFCCCCCC),
                fontSize = 18.sp,
                lineHeight = 22.sp
            )

            Spacer(Modifier.height(32.dp))

            Button(
                onClick = onSiguiente,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666),
                    contentColor = Color.White
                )
            ) {
                Text("Ir al patio central", fontSize = 18.sp)
            }
        }
    }
}
