package com.mariroco.practica

class Persona() {
    /*var id : Int
    get() { return id } set(_id:Int) {id=_id}*/
    private var Nombre=""
    private var Apellido=""
    private var Personalidad=""

    var nombre: String
        get() { return Nombre } set(_nombre:String) {Nombre=_nombre}

    var apellido: String
        get() { return Apellido } set(_apellido:String) {Apellido=_apellido}

    var personalidad : String
        get() { return Personalidad } set(_personalidad:String) {Personalidad=_personalidad}

    constructor (_nombre:String, _apellido:String, _personalidad:String) : this() {
        Nombre=_nombre
        Apellido=_apellido
        Personalidad=_personalidad
    }

    fun aleatorio(){
        var nombres= listOf("Karen","Jeffrey","Steven","Amauri")
        var apellidos = listOf("Bezos","Universe","Guzmán","Rionda")
        var personalidades = listOf("serio","malvado","carismático","no tiene personalidad")
        Nombre = nombres.random()
        Apellido = apellidos.random()
        Personalidad = personalidades.random()
    }


}



