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
fun Evento9(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val imgRes = context.resources.getIdentifier("robot_image", "drawable", context.packageName)

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

            Text("Laboratorio de robótica", fontSize = 28.sp, color = Color(0xFFEDEDED))
            Spacer(Modifier.height(14.dp))

            if (imgRes != 0) {
                Image(
                    painter = painterResource(id = imgRes),
                    contentDescription = "Robot",
                    modifier = Modifier.size(220.dp)
                )
                Spacer(Modifier.height(14.dp))
            }

            Text(
                "El proyecto RA-01 podía pensar por sí mismo.\nPista: Busca al guardia viejo (estacionamiento).",
                color = Color(0xFFCCCCCC),
                fontSize = 18.sp,
                lineHeight = 22.sp
            )

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = onSiguiente,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF666666))
            ) {
                Text("Ir al estacionamiento", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
