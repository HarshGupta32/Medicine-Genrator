package com.example.medicine_generator

import android.annotation.SuppressLint
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import java.io.IOException

class Addmedicine : AppCompatActivity() {

    var edname: EditText?=null
    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var edtime: EditText?=null
    var edmedicine: EditText?=null
    var edcontact: EditText?=null
    var edaddress: EditText?=null

    var lati:String?=null
    var longi:String?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addmedicine)

        edname = findViewById<EditText>(R.id.edtype)
        edprofile = findViewById<EditText>(R.id.edname)
        edcriteria = findViewById<EditText>(R.id.eddes)
        edmedicine = findViewById<EditText>(R.id.edprice)
        edtime = findViewById(R.id.edtime)


    }
    fun UploadData(view: View?) {
        val category = edname!!.text.toString()
        val address = edprofile!!.text.toString()
        val number = edcriteria!!.text.toString()
        val time = edtime!!.text.toString()
        val medicine = edmedicine!!.text.toString()


        val coder = Geocoder(applicationContext)

        try {
            val adresses = coder.getFromLocationName(address, 50) as ArrayList<Address>?
            for (add in adresses!!) {
                val longitude = add.longitude
                val latitude = add.latitude
                lati = latitude.toString()
                longi = longitude.toString()
                //                        Toast.makeText(getApplicationContext(),lati.toString(),Toast.LENGTH_LONG).show();
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val data = FirebaseDatabase.getInstance().reference.child("medicine")
        val service = Medicine(category,number,address,time,medicine,lati,longi)


        data.push().setValue(service)

        Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()



    }
}