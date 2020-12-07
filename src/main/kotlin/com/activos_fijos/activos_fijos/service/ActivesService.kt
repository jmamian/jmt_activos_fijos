package com.uniajc.actives.service

import co.edu.uniajc.fixedAsset.exception.ResourceNotFoundException
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.Query
import com.google.cloud.firestore.QuerySnapshot
import com.uniajc.actives.config.FirebaseInitialize
import com.uniajc.actives.model.Active
import com.uniajc.actives.model.Responsable
import com.uniajc.actives.model.User
import com.uniajc.actives.repository.ActivesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList


@Service
class ActivesService: ActivesRepository {

    @Autowired
    val activesRepository: ActivesRepository? = null
    @Autowired
    val db: FirebaseInitialize? = null


    @Throws(ResourceNotFoundException::class)
    fun login(nickname: String?): ArrayList<User> {

        val userLogin = arrayListOf<User>()
        val userCollection: CollectionReference? = db?.getFirebase()?.collection("User")
        val querySnapshot: ApiFuture<QuerySnapshot>
        if (userCollection != null) {
            querySnapshot = userCollection.get()


            for (docs: DocumentSnapshot in querySnapshot.get().documents){
                println(docs.get("nickname"))
                // userLogin.add(docs.toObject(User.class));
            }
        }

        return userLogin

    }

    override fun login(username: String?, password: String?): User {
        val user = User()
        val userCollection: Query? = db?.getFirebase()?.collection("User")?.whereEqualTo("nickname",username)
        val querySnapshot: ApiFuture<QuerySnapshot>
        if (userCollection != null) {
            querySnapshot = userCollection.get()

            for (docs: DocumentSnapshot in querySnapshot.get().documents){
                //user.id = docs.id.toString()
                user.nickname = docs.get("nickname").toString()
                user.password = docs.get("password").toString()
                user.token = docs.get("token").toString()
            }

        }
        return user
    }

    override fun register(user: User): String? {
        return db?.getFirebase()?.collection("User")?.add(user)?.get()?.id
    }

    override fun registerResponsable(responsable: Responsable): String? {
        return db?.getFirebase()?.collection("Assigned")?.add(responsable)?.get()?.id
    }

    override fun registerActive(active: Active): String? {
        return db?.getFirebase()?.collection("Active")?.add(active)?.get()?.id
    }

    override fun getAllResponsable(): ArrayList<Responsable>? {
        val responsableList = arrayListOf<Responsable>()
        val responsableCollection: Query? = db?.getFirebase()?.collection("assigned")
        val querySnapshot: ApiFuture<QuerySnapshot>
        if (responsableCollection != null) {
            querySnapshot = responsableCollection.get()

            for (docs: DocumentSnapshot in querySnapshot.get().documents){
                val responsable = Responsable()
                responsable.nombre = docs.get("nombre").toString()
                responsable.dependencia = docs.get("dependencia").toString()
                responsable.estado = docs.get("estado").toString()
                responsableList.add(responsable)
            }

        }

        return responsableList
    }

    override fun getResponsable(nombre: String, estado: String): Responsable? {
        val responsable = Responsable()
        val responsableCollection: Query? = db?.getFirebase()?.collection("Assigned")?.whereEqualTo("nombre",nombre)
        val querySnapshot: ApiFuture<QuerySnapshot>
        if (responsableCollection != null) {
            querySnapshot = responsableCollection.get()

            for (docs: DocumentSnapshot in querySnapshot.get().documents){
                //user.id = docs.id.toString()
                responsable.nombre = docs.get("nombre").toString()
                responsable.dependencia = docs.get("dependencia").toString()
                responsable.estado = docs.get("estado").toString()
            }

        }
        return responsable
    }

    override fun getAllActives(): ArrayList<Active>? {
        val activeList = arrayListOf<Active>()
        val activeCollection: Query? = db?.getFirebase()?.collection("Active")
        val querySnapshot: ApiFuture<QuerySnapshot>
        if (activeCollection != null) {
            querySnapshot = activeCollection.get()

            for (docs: DocumentSnapshot in querySnapshot.get().documents){
                val active = Active()
                active.codigo = docs.get("codigo").toString()
                active.nombre = docs.get("nombre").toString()
                active.descripcion = docs.get("descripcion").toString()
                active.estado = docs.get("estado").toString()
                active.fechaAsignacion = docs.get("fechaAsignacion").toString()
                active.fechaDevolucion = docs.get("fechaDevolucion").toString()
                active.responsable = docs.toObject(Responsable::class.java)!!
                activeList.add(active)
            }

        }

        return activeList
    }

    override fun getActive(codigo: String): Active? {
        val active = Active()
        val activeCollection: Query? = db?.getFirebase()?.collection("Active")?.whereEqualTo("codigo",codigo)
        val querySnapshot: ApiFuture<QuerySnapshot>
        if (activeCollection != null) {
            querySnapshot = activeCollection.get()

            for (docs: DocumentSnapshot in querySnapshot.get().documents){
                active.codigo = docs.get("codigo").toString()
                active.nombre = docs.get("nombre").toString()
                active.descripcion = docs.get("descripcion").toString()
                active.estado = docs.get("estado").toString()
                active.fechaAsignacion = docs.get("fechaAsignacion").toString()
                active.fechaDevolucion = docs.get("fechaDevolucion").toString()
                active.responsable = docs.toObject(Responsable::class.java)!!
            }

        }
        return active
    }



}