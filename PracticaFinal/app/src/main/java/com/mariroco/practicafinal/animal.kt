package com.mariroco.practicafinal
val nombres = listOf("Cookie","Bob","Sinpiernas","Demonio","Laika","Queen","Peanut","Mango","Oreo","Firulais")
val acciones = listOf("se ensució jugando en el lodo","se estrello contra una pared","se elevó a un nuevo plano astral","murió","Reestableció la unión soviética","se peleó con un cholo","ha sido encarcelado","hizo popo en tu cama")
val comida = listOf("zapato","ardilla muerta","croquetas","semillas","caguama","nuez","un cafe bien cargado","moneda","filete","calcetín","cable")
val pensamientos = listOf("te quiero","D:<","alimentame","si","no","¿qué me ves, quieres pelear?","gpi","Hola!","Te desprecio","No somos más que un simple grano de arena ante la playa de la vida","quiero galletas","te extrañe","owo","Ya callaté por favor","...","Eres perfecto")
open class animal {
    //constructor(){}
    val nombre = nombres.random()
    val edad = edad()
    val comidafav = comida.random()

    var sonido =""
    var especie=""

    fun hablar():String{
        var habla =""
        when((0..4).random()){
            0 -> habla= "${sonido}! ( ¡${pensamientos.random()}! )"
            1 -> habla= "${sonido}, ${sonido} ${sonido} ( ${pensamientos.random()} )"
            2 -> habla= "${sonido} ${sonido}... ( ${pensamientos.random()}... )"
            3 -> habla= "¿${sonido}? ( ¿${pensamientos.random()}? )"
            4 -> habla= "${sonido} ( ${sonido} )"
        }
        return habla
    }

    fun comer():String{return "${nombre} ha comido: ${comida.random()}"}
    fun accion():String{ return "${nombre} ${acciones.random()}"}
}

class perro:animal(){
    init{
        sonido="woof"
        especie="perro"
    }
}

class gato:animal(){
    init{
        sonido="meow"
        especie="gato"
    }
}

class pajaro:animal(){
    init{
        sonido="chirp"
        especie="pajaro"
    }

}

fun edad():Int{
    var x:Int = 0
    when((0..60).random()) {
        in 0..40 -> x=(0..16).random()
        in 40..55 -> x= (16..45).random()
        in 55..59 -> x= (45..56).random()
        60 -> x= 1000
    }
    return x
}
