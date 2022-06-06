package com.bob.myintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.btn_move_activity)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject:Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)


        btnIntent.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_move_activity ->{
                val intentBiasa = Intent(this@MainActivity, Move_Activity::class.java)
                startActivity(intentBiasa)
            }
            R.id.btn_move_activity_data -> run{
                val intentWithData = Intent(this@MainActivity, MoveActivityWithData::class.java)
                intentWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Native Programming")
                intentWithData.putExtra(MoveActivityWithData.EXTRA_AGE, 20)
                startActivity(intentWithData)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Andre Gunawan",
                    20,
                    "andregunawan4321@gmail.com",
                    "Pekanbaru"
                )
                val intentObjectActivity = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                intentObjectActivity.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(intentObjectActivity)
            }
        }
    }
}