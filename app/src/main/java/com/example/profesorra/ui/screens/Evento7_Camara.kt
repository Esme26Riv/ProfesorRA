package com.example.profesorra.ui.screens

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evento7_Camara(onSiguiente: () -> Unit) {

    val context = LocalContext.current
    var photoUri by remember { mutableStateOf<Uri?>(null) }

    val tomarFotoLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { }

    val permisoCamaraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { permisoConcedido ->
        if (permisoConcedido) {
            val nueva = crearUri(context)
            photoUri = nueva
            tomarFotoLauncher.launch(nueva)
        }
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
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                "Evento 7 - Cámara",
                fontSize = 26.sp,
                color = Color(0xFFEDEDED)
            )

            Spacer(Modifier.height(24.dp))

            if (photoUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(photoUri),
                    contentDescription = "Foto tomada",
                    modifier = Modifier.size(260.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.height(28.dp))

            Button(
                onClick = { permisoCamaraLauncher.launch(Manifest.permission.CAMERA) },
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF666666), contentColor = Color.White
                )
            ) {
                Text("Tomar Foto", fontSize = 18.sp)
            }

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = onSiguiente,
                enabled = photoUri != null,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF666666), contentColor = Color.White
                )
            ) {
                Text("Continuar", fontSize = 18.sp)
            }
        }
    }
}

fun crearUri(context: Context): Uri {
    val valores = ContentValues().apply {
        put(MediaStore.Images.Media.TITLE, "foto_evento7")
        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
    }
    return context.contentResolver.insert(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, valores
    )!!
}
