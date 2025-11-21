package com.example.profesorra.ui.screens

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.serialization.UNKNOWN.put
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evento7_Camara(onSiguiente: () -> Unit) {

    val context = LocalContext.current

    // Guarda la URI donde se almacenará la foto
    var photoUri by remember { mutableStateOf<Uri?>(null) }

    // Launcher para abrir cámara
    val tomarFotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { seGuardoFoto ->
        // Si se tomó foto correctamente no hacemos nada extra
    }

    // Launcher para permisos
    val permisoCamaraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { permisoConcedido ->
        if (permisoConcedido) {
            // Si dio permiso, lanzar cámara
            val nuevaUri = crearUri(context)
            photoUri = nuevaUri
            tomarFotoLauncher.launch(photoUri)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Evento 7 - Cámara") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Toma una fotografía como parte del ejercicio.",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Mostrar la foto si existe
            photoUri?.let { uri ->
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Foto tomada",
                    modifier = Modifier
                        .size(280.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    permisoCamaraLauncher.launch(Manifest.permission.CAMERA)
                }
            ) {
                Text("Tomar Foto")
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = { onSiguiente() },
                enabled = photoUri != null
            ) {
                Text("Continuar")
            }
        }
    }
}

// Función para crear la URI de la imagen en la galería
fun crearUri(context: Context): Uri {
    val valores = ContentValues().apply {
        put(MediaStore.Images.Media.TITLE, "foto_evento7")
        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
    }

    return context.contentResolver.insert(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        valores
    )!!
}
