package com.uniajc.actives.controller

import co.edu.uniajc.fixedAsset.exception.ResourceNotFoundException
import com.uniajc.actives.model.Responsable
import com.uniajc.actives.repository.ActivesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/responsable")
class ResponsableController {

    @Autowired
    private val activesRepository: ActivesRepository? = null

    @GetMapping("/getAllResponsable")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun getAllResponsable(): ArrayList<Responsable>? {
        return    activesRepository!!.getAllResponsable()
    }

    @GetMapping("/getResponsable")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun getResponsable(nombre: String, estado:String): Responsable? {
        return    activesRepository!!.getResponsable(nombre, estado)
    }

    @PostMapping("/registerResponsable")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun registerResponsable(nombre :String, dependencia: String, estado: String): String? {
        val responable = Responsable()
        responable.nombre = nombre
        responable.dependencia = dependencia
        responable.estado = estado
        return  activesRepository!!.registerResponsable(responable)

    }

}