package es.theframework.adrkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.text.TextWatcher
import android.widget.Toast

class MainActivity() : AppCompatActivity(),TextWatcher {

    private var edtName: EditText? = null
    private var edtAge: EditText? = null
    private var txtName: TextView? = null
    private var txtAge: TextView? = null
    private var btnGo: Button? = null

    private var sName: String? = null
    private var iAge = 0

    constructor(parcel: Parcel) : this() {
        sName = parcel.readString()
        iAge = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //R.layout.activity_main: app/res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        this.load_inputs()
        this.add_listeners()
        this.operacion()
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

    private fun add_listeners()
    {
        edtName!!.addTextChangedListener(this)
    }//add_listeners

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()
    }//onTextChanged

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }//beforeTextChanged

    override fun afterTextChanged(s: Editable?) {

    }//afterTextChanged

    private fun operacion()
    {

    }//operacion

}//MainActivity
