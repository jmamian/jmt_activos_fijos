package com.uniajc.actives.repository

import com.uniajc.actives.model.Active
import com.uniajc.actives.model.Responsable
import com.uniajc.actives.model.User
import org.springframework.stereotype.Repository

@Repository
interface ActivesRepository {
    fun login(username: String?, password: String?): User?
    fun register(user: User): String?
    fun registerResponsable(responsable: Responsable): String?
    fun getAllResponsable(): ArrayList<Responsable>?
    fun getResponsable(nombre: String, estado: String): Responsable?
    fun registerActive(active: Active): String?
    fun getAllActives(): ArrayList<Active>?
    fun getActive(codigo: String): Active?
}