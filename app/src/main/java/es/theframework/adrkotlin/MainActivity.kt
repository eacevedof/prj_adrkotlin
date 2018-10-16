package es.theframework.adrkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //R.layout.activity_main: app/res/layout/activity_main.xml
        setContentView(R.layout.activity_main)
    }

}//MainActivity
