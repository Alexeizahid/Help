package com.appdeaiuda.help

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_callsito.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val PHONE_CALL_REQUEST_CODE = 1

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton3.setOnClickListener {
            hacerLlamada()
        }
        button.setOnClickListener {
            primerCambio()
        }

        button2.setOnClickListener {
            val intent:Intent = Intent(this, Steps::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            tercerCambio()
        }
    }

    fun hacerLlamada(){
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:911")

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            startActivity(intent)
        } else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PHONE_CALL_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PHONE_CALL_REQUEST_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                hacerLlamada()
            } else{
                Toast.makeText(this,"Debes aceptar el permiso para hacer la llamada", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.settings_action){
            val intent: Intent = Intent(this, acercade::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    //Método de botones

    fun primerCambio(){
        val intent:Intent = Intent(this, Callsito::class.java)
        startActivity(intent)
    }
    fun tercerCambio(){
        val intent:Intent = Intent(this, contact::class.java)
        startActivity(intent)
    }




}
