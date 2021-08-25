package com.mariroco.practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var animales: MutableList<animal> = ArrayList()
    var contador:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn_sonido_click(view: View) {
        if(vacio()){
            Toast.makeText(this, "no hay animales, crea uno nuevo!", Toast.LENGTH_LONG).show()
        }else{
        Toast.makeText(this, animales[contador].hablar(), Toast.LENGTH_LONG).show()}
    }
    fun btn_accion_click(view: View) {
        if(vacio()){
            Toast.makeText(this, "no hay animales, crea uno nuevo!", Toast.LENGTH_LONG).show()
        }else{
        Toast.makeText(this, animales[contador].accion(), Toast.LENGTH_LONG).show()}
    }
    fun btn_comer_click(view: View) {
        if(vacio()){
            Toast.makeText(this, "no hay animales, crea uno nuevo!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, animales[contador].comer(), Toast.LENGTH_LONG).show()
        }

    }

    fun btn_nuevo_click(view: View) {
        var nuevo: animal?= null
        when ((0..2).random()){
            0-> nuevo=perro()
            1-> nuevo=gato()
            2-> nuevo=pajaro()
        }

        cargar_animal(nuevo,true)
        contador = animales.size-1
    }

    fun btn_anterior_click(view: View) {
        if (animales.size>0) {
            contador--
            cambio()
        }else{
            Toast.makeText(this, "no hay animales, crea uno nuevo!", Toast.LENGTH_LONG).show()
        }
    }

    fun cambio(){
        when(contador){
            -1 -> contador = animales.size-1
            animales.size -> contador=0
        }
        cargar_animal(animales[contador],false)
    }


    fun btn_siguiente_click(view: View) {

        if(animales.size>0){
            contador++
            cambio()
        }else{
            Toast.makeText(this, "no hay animales, crea uno nuevo!", Toast.LENGTH_LONG).show()
        }
    }

    fun cargar_animal(a:animal?,b:Boolean){
        val txt_nombre:TextView = findViewById(R.id.txt_nombre)
        val txt_comida = findViewById<TextView>(R.id.txt_comida)
        val txt_edad = findViewById<TextView>(R.id.txt_edad)
        val txt_especie = findViewById<TextView>(R.id.txt_especie)

        if (a != null) {
            txt_nombre.setText(a.nombre)
            txt_edad.setText(a.edad.toString())
            txt_comida.setText(a.comidafav)
            txt_especie.setText(a.especie)
            if (b){ animales.add(a)}
        }

        return
    }

    fun vacio():Boolean{
        if(animales.size>0) { return false }
            return true
    }


}