package com.androidmads.kotlinsqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_principal.*

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        Nombre.text = getIntent().getExtras().getString("Id1")
        Especialidad.text = getIntent().getExtras().getString("Id")
        Apellido.text = getIntent().getExtras().getString("Id2")
        Semestre.text = getIntent().getExtras().getString("Id3")
        Fecha.text = getIntent().getExtras().getString("Id4")









        nuevoElemento.setOnClickListener { view: View ->
            enviarCorreo()
        }

    }


    fun irAEditar() {
        val intent = Intent(this, AddOrEditActivity::class.java)
        startActivity(intent)
    }

    fun enviarCorreo() {
        val addressees = arrayOf("direccion@uno.com", "direccion@dos.com")
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sujeto")
       // intent.putExtra(Intent.EXTRA_TEXT, "Texto.")
        intent.putExtra(Intent.EXTRA_TEXT, "${Nombre.toString()}")
        startActivity(intent)
    }



}
