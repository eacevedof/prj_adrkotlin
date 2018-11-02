package es.theframework.adrkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import android.widget.*

class MainActivity() : AppCompatActivity(),TextWatcher
    , OnClickListener, CompoundButton.OnCheckedChangeListener {

    private var edtName: EditText? = null
    private var edtAge: EditText? = null
    private var txtName: TextView? = null
    private var txtAge: TextView? = null
    private var rdbGender1: RadioButton? = null
    private var rdbGender2: RadioButton? = null
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
        //this.operacion()
    }//onCreate

    private fun load_inputs()
    {
        //cajas input
        edtName = findViewById(R.id.edtName) as EditText
        edtAge = findViewById(R.id.edtAge) as EditText
        //labels
        txtName = findViewById(R.id.txtName) as TextView
        txtAge = findViewById(R.id.txtAge) as TextView
        //gender
        rdbGender1 = findViewById(R.id.rdbGender1) as RadioButton
        rdbGender2 = findViewById(R.id.rdbGender2) as RadioButton

        //buttons
        btnGo = findViewById(R.id.btnGo) as Button
    }//load_inputs

    private fun add_listeners()
    {
        edtName!!.addTextChangedListener(this)
        rdbGender1!!.setOnCheckedChangeListener(this)
        rdbGender2!!.setOnCheckedChangeListener(this)
        btnGo!!.setOnClickListener(this)
    }//add_listeners

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Toast.makeText(this,"Ha seleccionado una opcion",Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        this.operacion()
    }//view.onclick

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()
    }//onTextChanged

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }//beforeTextChanged

    override fun afterTextChanged(s: Editable?) {

    }//afterTextChanged

    private fun operacion()
    {
        sName = edtName?.text.toString()
        val sAge =  edtAge?.text.toString()

        //si sname==""
        if( !(sName?.equals("") ?: false) )
            txtName?.text = sName
        if(sAge != "")
            txtAge?.text = sAge

    }//operacion

}//MainActivity
