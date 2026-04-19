package com.example.medicine_generator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class Userdash : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userdash)

        val bottom = findViewById<BottomNavigationView>(R.id.bottom)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {


                R.id.shop ->
                {
                    val i = Intent(applicationContext,hospitallocation::class.java)
                    startActivity(i)
                    true

                }


                R.id.feedback ->
                {

                    //Toast.makeText(applicationContext,"food nutrition", Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,medicinelocation::class.java)
                    startActivity(i)
                    true
                }
                R.id.showre ->
                {

                    //Toast.makeText(applicationContext,"Upload Video",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,doctorlocation::class.java)
                    startActivity(i)
                    true
                }

                R.id.pre ->
                {

                    //Toast.makeText(applicationContext,"Upload Video",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,Adddata::class.java)
                    startActivity(i)
                    true
                }




                else -> {false}
            }
        }
    }
}