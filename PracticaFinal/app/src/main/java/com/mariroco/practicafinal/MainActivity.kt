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
        /*
        val txt_nombre:TextView = findViewById(R.id.txt_nombre)
        val txt_comida = findViewById<TextView>(R.id.txt_comida)
        val txt_edad = findViewById<TextView>(R.id.txt_edad)
        val txt_especie = findViewById<TextView>(R.id.txt_especie)

        var btn_accion = findViewById<Button>(R.id.btn_accion)
        var btn_comer = findViewById<Button>(R.id.btn_comer)
        var btn_sonido = findViewById<Button>(R.id.btn_sonido)
        var btn_nuevo = findViewById<Button>(R.id.btn_nuevo)
        var btn_anterior = findViewById<Button>(R.id.btn_anterior)
        var btn_siguiente = findViewById<Button>(R.id.btn_siguiente)

        btn_accion.setOnClickListener{
            Toast.makeText(this, animales[contador].accion(), Toast.LENGTH_LONG).show()
        }
        btn_comer.setOnClickListener{
            Toast.makeText(this, animales[contador].comer(), Toast.LENGTH_LONG).show()
        }

        /*btn_sonido.setOnClickListener{
            Toast.makeText(this, animales[contador].hablar(), Toast.LENGTH_LONG).show()
        }*/

        btn_nuevo.setOnClickListener{
            var nuevo = animal()
            when ((0..2).random()){
                0-> nuevo=perro()
                1-> nuevo=gato()
                2-> nuevo=pajaro()
            }
            txt_nombre.setText(nuevo.nombre)
            txt_edad.setText(nuevo.edad.toString())
            txt_comida.setText(nuevo.comidafav)
            txt_especie.setText(nuevo.especie)
            animales.add(nuevo)
            contador = animales.size-1
        }

        btn_anterior.setOnClickListener{
            contador--
            if (animales.size>0) {
                if (contador < 0) {
                    contador = animales.size-1
                }
                txt_nombre.setText(animales[contador].nombre)
                txt_edad.setText(animales[contador].edad.toString())
                txt_comida.setText(animales[contador].comidafav)
                txt_especie.setText(animales[contador].especie)
            }else{}
        }

        btn_siguiente.setOnClickListener{
            contador++
            if(animales.size>0){
                if (contador==animales.size){
                    contador=0
                }
                txt_nombre.setText(animales[contador].nombre)
                txt_edad.setText(animales[contador].edad.toString())
                txt_comida.setText(animales[contador].comidafav)
                txt_especie.setText(animales[contador].especie)
            }else{}
        }*/


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
        cargar_animal(nuevo)
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
        if(contador>=animales.size){ contador=0 }else if(contador<0){contador = animales.size-1}
        cargar_animal(animales[contador])
    }


    fun btn_siguiente_click(view: View) {

        if(animales.size>0){
            contador++
            cambio()
        }else{
            Toast.makeText(this, "no hay animales, crea uno nuevo!", Toast.LENGTH_LONG).show()
        }
    }

    fun cargar_animal(a:animal?){
        val txt_nombre:TextView = findViewById(R.id.txt_nombre)
        val txt_comida = findViewById<TextView>(R.id.txt_comida)
        val txt_edad = findViewById<TextView>(R.id.txt_edad)
        val txt_especie = findViewById<TextView>(R.id.txt_especie)

        if (a != null) {
            txt_nombre.setText(a.nombre)
            txt_edad.setText(a.edad.toString())
            txt_comida.setText(a.comidafav)
            txt_especie.setText(a.especie)
            animales.add(a)
        }

        return
    }

    fun vacio():Boolean{
        if(animales.size>0) { return false }
            return true
    }


}