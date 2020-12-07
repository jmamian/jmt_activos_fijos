package com.uniajc.actives.model

class Active (){

    var codigo: String = ""
    var nombre: String = ""
    var descripcion: String = ""
    var estado: String = ""
    var fechaAsignacion: String = ""
    var fechaDevolucion: String = ""
    lateinit var responsable: Responsable



    constructor( codigo: String,
                 nombre: String,
                 descripcion: String,
                 estado:String,
                 fechaAsignacion:String,
                 fechaDevolucion:String,
                 responsable:Responsable) : this ()
}