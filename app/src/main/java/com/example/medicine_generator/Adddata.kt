package com.example.medicine_generator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Adddata : AppCompatActivity() {

    var edname: EditText?=null


    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var edtemp: EditText?=null
    var edhumidity: EditText?=null
    var edph: EditText?=null
    var edrain: EditText?=null
    var edstate: EditText?=null
    var eddesiase: EditText?=null

    var acidity:String?=null
    var back:String?=null
    var cold:String?=null
    var chest:String?=null
    var breath:String?=null
    var desiase:String?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adddata)

        edtemp = findViewById<EditText>(R.id.edtemp)
        edhumidity = findViewById<EditText>(R.id.edhum)
        edph = findViewById<EditText>(R.id.edph)
        edrain = findViewById<EditText>(R.id.edrain)
        edstate = findViewById<EditText>(R.id.edstate)
//        eddesiase = findViewById<EditText>(R.id.eddesiase)
        val btnpredict = findViewById<Button>(R.id.btnpredict)

        btnpredict.setOnClickListener {
            val intent = Intent(applicationContext,predication::class.java)

            intent.putExtra("state",acidity)
            intent.putExtra("ph",cold)


            startActivity(intent)

        }
    }

    fun UploadData(view: View?) {



        acidity= edtemp!!.text.toString()
        back = edhumidity!!.text.toString()
        cold = edph!!.text.toString()
        chest = edrain!!.text.toString()
        breath = edstate!!.text.toString()
//        desiase = eddesiase!!.text.toString()

//        val data = FirebaseDatabase.getInstance().getReference().child("data")
//        val service = Data(acidity,back,cold,chest,breath,desiase)
//
//
//        data.push().setValue(service)
//


        Toast.makeText(applicationContext,"uploaded", Toast.LENGTH_LONG).show()
        //Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()



    }
}