package com.example.asyncstorageapp

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        // Nombre del archivo de preferencias locales
        private const val PREF_NAME = "MisPreferenciasApp"
        private const val KEY_DATO = "clave_dato_guardado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Evita que el contenido quede debajo de la barra de estado / navegación
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, bars.top, v.paddingRight, bars.bottom)
            insets
        }

        val etDato = findViewById<EditText>(R.id.etDato)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnLeer = findViewById<Button>(R.id.btnLeer)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // 1. Cargar automáticamente el dato si ya existía previamente al abrir la app
        cargarDatoGuardado(tvResultado)

        // 2. Botón para Guardar el dato localmente
        btnGuardar.setOnClickListener {
            val textoAIngresar = etDato.text.toString()

            if (textoAIngresar.isNotBlank()) {
                // Obtenemos instancia de SharedPreferences y guardamos con la clave KEY_DATO.
                // edit { } usa .apply() por defecto: guarda de forma asíncrona en segundo plano
                getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit {
                    putString(KEY_DATO, textoAIngresar)
                }

                Toast.makeText(this, R.string.guardado_ok, Toast.LENGTH_SHORT).show()
                etDato.text.clear()

                // Actualizamos la vista previa
                cargarDatoGuardado(tvResultado)
            } else {
                Toast.makeText(this, R.string.escribe_algo, Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Botón para Leer el dato manualmente
        btnLeer.setOnClickListener {
            cargarDatoGuardado(tvResultado)
        }
    }

    // Función auxiliar para leer desde el almacenamiento local
    private fun cargarDatoGuardado(textView: TextView) {
        val sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        // Recuperamos el valor asociado a la clave. Si no existe, devuelve "Ninguno"
        val datoRecuperado = sharedPreferences.getString(KEY_DATO, null)
            ?: getString(R.string.valor_por_defecto)

        textView.text = getString(R.string.dato_almacenado, datoRecuperado)
    }
}
