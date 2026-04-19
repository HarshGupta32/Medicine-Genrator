package com.example.medicine_generator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class predication : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    private var list: ArrayList<Data>? = null

    var state:String?=null
    var ph:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_predication)

        val txtresult = findViewById<TextView>(R.id.txtresult)

        val bundle = intent.extras

        state = bundle?.getString("state")
        ph = bundle?.getString("ph")
        Toast.makeText(applicationContext,state.toString(),Toast.LENGTH_LONG).show()


        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("data")

        val query: Query = mDatabaseRef.orderByChild("acidity").equalTo(state)

        query.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                print(dataSnapshot)


                for (data in dataSnapshot.children) {
                    // println(data)


                    val result = data.child("breath").value.toString()
                    if(result == ph)
                    {
                        println(".................."+result)
                        val predit = data.child("desiase").value

                        println("++++++++++++++++++++++++++++++++++++++++++++"+predit)

                        txtresult.setText("Disease Predication Is: "+predit)
                    }

//                    val models: Data? = data.getValue(Data::class.java)
//                    println(models)
//                    if (models != null) {
//                        list!!.add(models)
//                    }

                }


            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })


    }
}