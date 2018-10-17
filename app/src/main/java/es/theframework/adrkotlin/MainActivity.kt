package es.theframework.adrkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class MainActivity : AppCompatActivity(), TextWatcher{

    private var edtName: EditText? = null
    private var edtAge: EditText? = null

    private var name: String? = null
    private var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //R.layout.activity_main: app/res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName) as EditText
        edtAge = findViewById(R.id.edtAge) as EditText

        edtName?.addTextChangedListener(this)
    }

}//MainActivity
