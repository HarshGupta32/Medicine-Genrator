package com.example.medicine_generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Showmedicine : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    private var adapter:MedicineAdapter?=null
    private var list: ArrayList<Medicine>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showmedicine)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        list = ArrayList()


        val pref = getSharedPreferences("My", MODE_PRIVATE)
        val name = pref.getString("address", "")
        Toast.makeText(applicationContext,name.toString(), Toast.LENGTH_LONG).show()
        database = FirebaseDatabase.getInstance()


        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("medicine")

        val query: Query = mDatabaseRef.orderByChild("address").equalTo(name)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                print(dataSnapshot)


                for (data in dataSnapshot.children) {
                    println(data)




                    val models: Medicine? = data.getValue(Medicine::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }

                }

                adapter = MedicineAdapter(list,applicationContext)
                recyclerView.adapter = adapter

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}