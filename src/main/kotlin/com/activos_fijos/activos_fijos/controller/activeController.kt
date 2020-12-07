package com.uniajc.actives.controller

import co.edu.uniajc.fixedAsset.exception.ResourceNotFoundException
import com.uniajc.actives.model.Active
import com.uniajc.actives.model.Responsable
import com.uniajc.actives.model.User
import com.uniajc.actives.repository.ActivesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList

//@Api(value = "actives", tags = ["actives"])
//@CrossOrigin(origins = {"http://192.168.1.10:8090"})
@RestController
@RequestMapping("/api/v1")
class activeController {


    @Autowired
    private val activesRepository: ActivesRepository? = null

    @GetMapping("/loginUser")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun login(nickname :String, password: String): User? {
        return    activesRepository!!.login(nickname , password)
    }

    @PostMapping("/registerUser")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun register(nickname :String, password: String): String? {
        val user = User()
        user.nickname = nickname
        user.password = password
        return  activesRepository!!.register(user)

    }







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





    @GetMapping("/getAllActive")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun getAllActive(): ArrayList<Active>? {
        return    activesRepository!!.getAllActives()
    }

    @GetMapping("/getActive")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun getActive(codigo: String): Active? {
        return    activesRepository!!.getActive(codigo)
    }


    @PostMapping("/registerActive")
    @Throws(NoSuchMethodException::class, ResourceNotFoundException::class)
    fun registerActive(codigo :String, nombre: String, descripcion: String, estado: String, fechaAsignacion: String, fechaDevolucion: String): String? {
        val active = Active()
        active.codigo = codigo
        active.nombre = nombre
        active.descripcion = descripcion
        active.estado = estado
        active.fechaAsignacion = fechaAsignacion
        active.fechaDevolucion = fechaDevolucion
        return  activesRepository!!.registerActive(active)

    }




}