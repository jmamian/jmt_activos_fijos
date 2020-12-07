package com.uniajc.actives.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.IOException
import javax.annotation.PostConstruct


@Service
class FirebaseInitialize {

    @PostConstruct
    public fun initialize()
    {
        var serviceAccount = FileInputStream("./serviceAccount.json")

        //var options: FirebaseOptions
        try {

            /*
            options = FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://registroactivosfijos.firebaseio.com")
                    .build()


             */

            val serviceAccount = FileInputStream("./serviceAccount.json")

            val options = FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://ticketcinema.firebaseio.com")
                    .build()

            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

        }catch (e: IOException) {
            e.printStackTrace()
        }


    }

    public fun getFirebase(): Firestore? {
        return FirestoreClient.getFirestore();
    }

}