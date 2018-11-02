package es.theframework.adrkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import android.widget.AdapterView.OnItemClickListener

class MainActivity() : AppCompatActivity(),TextWatcher
    , OnClickListener, CompoundButton.OnCheckedChangeListener
    , OnItemClickListener{

    private var edtName: EditText? = null
    private var edtAge: EditText? = null
    private var txtName: TextView? = null
    private var txtAge: TextView? = null
    private var rdbGender1: RadioButton? = null
    private var rdbGender2: RadioButton? = null
    private var btnGo: Button? = null
    private var ltvGrid: ListView? = null

    private var sName: String? = null
    private var sAge: String? = null
    private var sGender: String? = null

    private var iItemPos = 0
    private var sItemAction: String? = null

    private var sMensaje: String? = null

    private var iNum = 10

    internal var arNames: Array<String>? = null
    internal var arAges: Array<String>? = null
    internal var arGenders: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //R.layout.activity_main: app/res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        this.load_inputs()
        this.add_listeners()

        this.edtName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        this.arNames = Array(this.iNum){""}
        this.arAges = Array(this.iNum){""}
        this.arGenders = Array(this.iNum){""}

        //this.operacion()
        //this.operacion_2()
        //this.operacion_3()
        //this.operacion_4()
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

        ltvGrid = findViewById(R.id.ltvGrid) as ListView
    }//load_inputs

    private fun add_listeners()
    {
        edtName!!.addTextChangedListener(this)

        //Radios
        rdbGender1!!.setOnCheckedChangeListener(this)
        rdbGender2!!.setOnCheckedChangeListener(this)
        rdbGender1!!.setOnClickListener(this)
        rdbGender2!!.setOnClickListener(this)

        //Botón
        btnGo!!.setOnClickListener(this)

        //Lista
        ltvGrid!!.setOnItemClickListener(this)

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
            R.id.btnGo -> operacion_5()
            R.id.rdbGender1 -> toast_it("Ha seleccionado Femenino")
            R.id.rdbGender2 -> toast_it("Ha seleccionado Masculino")
        }//when(v.id)

        //this.operacion()
    }//view.onclick

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        edtName!!.setText(arNames?.get(position))
        edtAge!!.setText(arAges?.get(position))

        when(arGenders!!.get(position)){
            "Man" -> rdbGender2!!.isChecked = true
            "Woman" -> rdbGender1!!.isChecked = true
        }//when

        this.iItemPos = position
        this.sItemAction = "update"
    }//onItemClick

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()
    }//onTextChanged

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }//beforeTextChanged

    override fun afterTextChanged(s: Editable?) {

    }//afterTextChanged

    //video26 - listView: https://youtu.be/7Hl24amE8lo?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=437
    private fun operacion_5()
    {
        this.sName = edtName?.text.toString()
        this.sAge = edtAge?.text.toString()

        if(sAge?.equals("")?:false)
        {
            edtAge!!.requestFocus()
            toast_it("Missing Age")
            return
        }

        if(sName?.equals("")?:false)
        {
            edtName!!.requestFocus()
            toast_it("Missing Name")
            return
        }

        if(!(rdbGender1!!.isChecked || rdbGender2!!.isChecked))
        {
            toast_it("Choose Gender")
            return
        }
        else
            sGender = (if(rdbGender1!!.isChecked) rdbGender1!!.text.toString() else rdbGender2!!.text.toString())

        //array que se vinculará al adapter que se pasará al listview grid
        var arAdapter: Array<String>
        var iNames = this.arNames?.size as Int

        for(i in 0..(iNames-1))
        {
            //si no se ha guardado un nombre en esa posición
            if(arNames?.get(i).equals(""))
            {
                //guardo el nuevo nombre
                arNames?.set(i, sName as String)
                arAges?.set(i, sAge as String)
                arGenders?.set(i, sGender as String)

                //creo el adapter con el tamaño de arNames
                arAdapter = Array<String>(iNames,{ "" })
                //recargo el array del adapter con todo lo que hubiera en names
                for(j in 0..i)
                    arAdapter[j] = arNames?.get(j).toString()

                val oAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arAdapter)
                ltvGrid!!.adapter = oAdapter
                break
            }//endif(nombre en blanco)
        }//for i .. iNum

    }//operacion_5

    //video:25 https://youtu.be/XNkohi44ghA?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=313
    private fun operacion_4()
    {
        var sData = ""
        var arNames = arrayOf("Alex","AJ","PDHN")
        var arNulls = Array<String?>(3){null}
        arNulls = arrayOfNulls<String>(3)

        var iNulls = arNames.size
        iNulls--

        for(i in 0..iNulls)
            arNulls.set(i,arNames.get(i))

        arNulls.forEach {
            sItem -> sData = sItem.toString()
        }
    }//operacion_4

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

        var iString = arString.count()-1
        for(i in 0..iString) sData =  arString.get(i)

        var arStrings2 = Array<String>(3){""}
        var arStrings3 = Array(3){""}
        var arInts1 = Array<Int>(3){0}
        var arInts2 = Array(3){0}

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
