package es.theframework.adrkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){

    private var edtName: EditText? = null
    private var edtAge: EditText? = null
    private var txtName: TextView? = null
    private var txtAge: TextView? = null
    private var btnGo: Button? = null


    private var name: String? = null
    private var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //R.layout.activity_main: app/res/layout/activity_main.xml
        setContentView(R.layout.activity_main)
        this.load_inputs()
        //edtName?.addTextChangedListener(this)
    }//onCreate

    private fun load_inputs()
    {
        //cajas input
        edtName = findViewById(R.id.edtName) as EditText
        edtAge = findViewById(R.id.edtAge) as EditText
        //labels
        txtName = findViewById(R.id.txtName) as TextView
        txtAge = findViewById(R.id.txtAge) as TextView
        //buttons
        btnGo = findViewById(R.id.btnGo) as Button
    }//load_inputs

}//MainActivity
