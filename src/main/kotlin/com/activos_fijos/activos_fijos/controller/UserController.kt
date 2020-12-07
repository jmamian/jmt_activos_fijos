package com.uniajc.ticketmovie.controller

import co.edu.uniajc.fixedAsset.exception.ResourceNotFoundException
import com.uniajc.actives.model.User
import com.uniajc.actives.repository.ActivesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/user")
class UserController {

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
}