package edu.temple.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var fragment1: MyFragment
    lateinit var displayFragment: DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment1 = MyFragment.getInstance(1)
        displayFragment = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container1, fragment1)
            .add(R.id.container2, displayFragment)
            .commit()

        //fragment1.changeColor(4)


        findViewById<Button>(R.id.changeColorButton).setOnClickListener{
            //fragment1.changeColor(3)
            //displayFragment.changeColor("blue")
        }
    }

}