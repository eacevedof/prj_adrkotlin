# prj_adrkotlin

## [Youtube - Curso de Android and Kotlin desde cero - Alex Pagoada](https://www.youtube.com/playlist?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)

- [Clase Principal - adrkotlin/MainActivity.kt](https://github.com/eacevedof/prj_adrkotlin/blob/master/app/src/main/java/es/theframework/adrkotlin/MainActivity.kt)
- [15 - Operador Elvis con false](https://youtu.be/Qaa9F4Uv4E4?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=794)
- [21 - RadioButton evento onClick](https://youtu.be/wBPdVE2-aAE?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
- [22 - Tipos de array](https://www.youtube.com/watch?v=PE22BxijE7M&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&index=22)
    - No existen arrays de tipo string!!
    - se crea así: `val arString = arrayOf("Alex","Aj","Eaf","PDHN")`
- [23 - Bucle ciclo for](https://www.youtube.com/watch?v=I5SBrAXsMxw&index=23&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
    - `for( s in arString) sData = s`
    - `for(i in 0..3) sData = arString.get(i)`
    ```kotlin
    var iString = arString.count()-1
    for(i in 0..iString) sData =  arString.get(i)
    ```
- [24 - Bucle ciclo forEach](https://www.youtube.com/watch?v=KUgzw_I8uqg&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&index=24)
    ```kotlin
    var arStrings2 = Array<String>(3){""}
    var arStrings3 = Array(3){""}
    var arInts1 = Array<Int>(3){0}
    var arInts2 = Array(3){0}    
  
    //https://youtu.be/KUgzw_I8uqg?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=866
    arString.forEach {
       sItem -> sData = sItem
    }//froeach
    ```
 - [25 - Funcion arrayOfNulls](https://youtu.be/XNkohi44ghA?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
    ```kotlin
    var arNulls = Array<String?>(3){null}
    arNulls = arrayOfNulls<String>(3)
    ```
 - [26 - Control listView](https://www.youtube.com/watch?v=7Hl24amE8lo&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&index=26)
    - No se plasma los datos en el listView. Solo se agrega el control al layout
    ```kotlin
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
    ```
- [27 - Clase ArrayAdapter](https://youtu.be/X96hmJZnTX8?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
    ```kotlin
    this.edtName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
    ```
- [28 - onItemClick](https://www.youtube.com/watch?v=DpAhe20WlhI&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&index=28)
    - Se implementa la interfaz `import android.widget.AdapterView.OnItemClickListener`
    ```kotlin
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
    ```
    
## Errors
- 1 `Android resource linking failed Output: app\build\intermediates\incremental\mergeDebugResources\merged.dir\values\values.xml:646: 
     error: style attribute 'attr/colorButtonBackground (aka es.theframework.adrkotlin:attr/colorButtonBackground)' not found.`
    - Solución:
    - Quitar de values/styles.xml las propiedades name="colorButtonBackground" 