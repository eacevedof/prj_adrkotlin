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

    private var sMensaje: String? = null

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
        //this.operacion_2()
        this.operacion_3()
    }//onCreate

    private fun toast_it(sMessage:String?)
    {
        Toast.makeText(this,sMessage,Toast.LENGTH_LONG).show()
    }//toast_it

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

        //Radios
        rdbGender1!!.setOnCheckedChangeListener(this)
        rdbGender2!!.setOnCheckedChangeListener(this)
        rdbGender1!!.setOnClickListener(this)
        rdbGender2!!.setOnClickListener(this)


        btnGo!!.setOnClickListener(this)
    }//add_listeners

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        var sMessage: String ? = ""

        when(buttonView!!.id){
            R.id.rdbGender1 ->
                if(isChecked) sMessage = "Ha seleccionado Femenino"
            R.id.rdbGender2 ->
                if(isChecked) sMessage = "Ha seleccionado Masculino"

        }
        //if(sMessage!="") toast_it(sMessage)
    }//onCheckedChanged

    override fun onClick(v: View?) {
        when(v!!.id)
        {
            R.id.btnGo -> operacion_3()
            R.id.rdbGender1 -> toast_it("Ha seleccionado Femenino")
            R.id.rdbGender2 -> toast_it("Ha seleccionado Masculino")
        }//when(v.id)

        //this.operacion()
    }//view.onclick

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()
    }//onTextChanged

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }//beforeTextChanged

    override fun afterTextChanged(s: Editable?) {

    }//afterTextChanged

    //video: [tipos de array](https://youtu.be/PE22BxijE7M?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
    private fun operacion_3()
    {
        var arInts = IntArray(10)
        var arDoubles = DoubleArray(size = 10)
        var arChars = CharArray(10)
        var arBools = BooleanArray(10)
        var arFloats = FloatArray(10)
        var arBites = ByteArray(10)

        var sData = ""
        val arString = arrayOf("Alex","Aj","Eaf","PDHN")
        arString[1] = "hola mundo"
        sData = arString[1]
        arString.set(1,"Posicion Uno")
        sData = arString.get(1)


        for( s in arString) sData = s
        for(i in 0..3) sData = arString.get(i)

        var iString = arString.count()
        for(i in 0..iString) sData =  arString.get(i)

        var arStrings2 = Array<String>(3){""}
        var arStrings3 = Array(3){""}
        var arInts1 = Array<Int>(3){0}
        var arInts2 = Array(3){0}

        //forEach https://youtu.be/KUgzw_I8uqg?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=866
        arString.forEach {
            sItem -> sData = sItem
        }//froeach


    }//operacion_3

    private fun operacion()
    {
        toast_it("this.operacion()")
        sName = edtName?.text.toString()
        val sAge =  edtAge?.text.toString()

        //si sname==""
        if( !(sName?.equals("") ?: false) )
            txtName?.text = sName
        if(sAge != "")
            txtAge?.text = sAge

    }//operacion

    private fun operacion_2()
    {
        var sValue = "Java"
        var iEntero = 1

        when{
            1 == iEntero ->
                sMensaje = sValue
            2 < iEntero
                -> sMensaje = sValue
            else ->
                sMensaje = "No es correcto"
        }//when

    }//operacion_2

}//MainActivity
