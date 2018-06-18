package com.androidmads.kotlinsqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import com.androidmads.kotlinsqlite.adapter.TaskRecyclerAdapter
import com.androidmads.kotlinsqlite.db.DatabaseHandler
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)



        button__verlista.setOnClickListener { view: View ->
            irAEstudiantes()
        }

        buttonnuevoestudiante.setOnClickListener { view: View ->
            irANuevoEstudiante()
        }
    }


    fun irAEstudiantes() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun irANuevoEstudiante() {
        val intent = Intent(this, AddOrEditActivity::class.java)
        startActivity(intent)
    }
}
