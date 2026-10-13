# AsyncStorageApp

Aplicación Android nativa en **Kotlin** que guarda datos de forma local con **SharedPreferences**, el equivalente en Android nativo al *Async Storage* de React Native.

El usuario escribe un texto, lo guarda y este se mantiene aunque la app se cierre y se vuelva a abrir.

## Funcionalidad

- **Guardar Localmente**: guarda el texto del campo con la clave `clave_dato_guardado` en el archivo de preferencias `MisPreferenciasApp`. Se usa `apply()`, que escribe de forma asíncrona en segundo plano.
- **Leer Dato Guardado**: recupera el valor guardado y lo muestra en pantalla.
- **Carga automática**: al abrir la app se muestra el último dato guardado (o `Ninguno` si no hay).
- Si el campo está vacío, se muestra el aviso *"Por favor escribe algo"*.

## Archivos principales

- `app/src/main/res/layout/activity_main.xml`: interfaz (EditText, 2 botones y TextView).
- `app/src/main/java/com/example/asyncstorageapp/MainActivity.kt`: lógica con SharedPreferences.

## Requisitos

- Android Studio
- Minimum SDK: Android 7.0 (API 24)

## Cómo probarlo

1. Abre el proyecto en Android Studio y pulsa **Run (▶)**.
2. Escribe una frase, por ejemplo *"Hola, este es un dato persistente"*.
3. Pulsa **Guardar Localmente**. Aparece un Toast de confirmación y se actualiza el texto inferior.
4. Cierra la app por completo (quítala de las apps recientes) y vuelve a abrirla: el dato guardado aparece automáticamente.
