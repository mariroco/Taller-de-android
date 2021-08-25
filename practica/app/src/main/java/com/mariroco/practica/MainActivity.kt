package com.mariroco.practica

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val registros: MutableList<Persona> = ArrayList()
    var c:Int = 0
    var tam=registros.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txt_nombre = findViewById<EditText>(R.id.txt_nombre)
        var txt_apellido = findViewById<EditText>(R.id.txt_apellido)
        var txt_personalidad =findViewById<EditText>(R.id.txt_personalidad)


        var crear = findViewById<Button>(R.id.btn_nuevo)
        var rellenar = findViewById<Button>(R.id.btn_aleatorio)
        var siguiente = findViewById<Button>(R.id.btn_siguiente)
        var anterior = findViewById<Button>(R.id.btn_anterior)

        crear.setOnClickListener {
            var nom = txt_nombre.text.toString()
            var ap = txt_apellido.text.toString()
            var per = txt_personalidad.text.toString()

            if (txt_nombre.text.length>0 && txt_apellido.text.length>0 && txt_personalidad.text.length>0) {
                val temp = Persona(nom, ap, per)
                registros.add(temp)
                Toast.makeText(this@MainActivity, "Nuevo registro agregado!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "Error en el registro", Toast.LENGTH_SHORT).show()
            }
            txt_nombre.text.clear()
            txt_apellido.text.clear()
            txt_personalidad.text.clear()
            c=0
        }

        rellenar.setOnClickListener {
            var x=Persona()
            x.aleatorio()
            txt_nombre.setText(x.nombre)
            txt_apellido.setText(x.apellido)
            txt_personalidad.setText(x.personalidad)
            Toast.makeText(this@MainActivity, "Datos aleatorios generados", Toast.LENGTH_SHORT).show()
            c=0
        }

        siguiente.setOnClickListener {
            c++
            tam = registros.size

            if(tam>0) {
                if(c==0 || c>=tam+1){
                    txt_nombre.text.clear()
                    txt_apellido.text.clear()
                    txt_personalidad.text.clear()
                    c=0
                }else{
                    var x = registros[c-1]
                    txt_nombre.setText(x.nombre)
                    txt_apellido.setText(x.apellido)
                    txt_personalidad.setText(x.personalidad)

                }
            }else{
                Toast.makeText(this@MainActivity, "no hay registros", Toast.LENGTH_SHORT).show()
                c=0
            }
        }

        anterior.setOnClickListener{
            c--
            tam = registros.size

            if(tam>0) {
                if(c==-1){
                    var x = registros[tam-1]
                    txt_nombre.setText(x.nombre)
                    txt_apellido.setText(x.apellido)
                    txt_personalidad.setText(x.personalidad)
                    c=tam
                }else if(c==0 || c>tam){
                    txt_nombre.text.clear()
                    txt_apellido.text.clear()
                    txt_personalidad.text.clear()
                    c=0
                }else{
                    var x = registros[c-1]
                    txt_nombre.setText(x.nombre)
                    txt_apellido.setText(x.apellido)
                    txt_personalidad.setText(x.personalidad)
                }
            }else {
                Toast.makeText(this@MainActivity, "no hay registros", Toast.LENGTH_SHORT).show()
                c=0
            }
        }

        fun cargar(_c:Int){
            tam = registros.size
            if(tam>0) {
                if(_c>tam){
                    txt_nombre.setText("")
                    txt_apellido.setText("")
                    txt_personalidad.setText("")
                }else if(_c<=0){
                    txt_nombre.setText("")
                    txt_apellido.setText("")
                    txt_personalidad.setText("")
                }else{
                    var x = registros[_c]
                    txt_nombre.setText(x.nombre)
                    txt_apellido.setText(x.apellido)
                    txt_personalidad.setText(x.personalidad)
                }

            }else{
                Toast.makeText(this@MainActivity, "no hay registros", Toast.LENGTH_SHORT).show()
            }
        }


    }


}