package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var displ: TextView
    lateinit var numbut: ArrayList<Button>
    lateinit var opbut: ArrayList<Button>
    lateinit var res: Button
    lateinit var pm: Button
    lateinit var per: Button
    lateinit var del: Button
    lateinit var cl: Button
    var num:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        disinit()
        

    }








    /////////////// display element initializer
    fun disinit(){

        displ=findViewById(R.id.tvdisplay)
        numbut.add(findViewById(R.id.num0))
        numbut.add(findViewById(R.id.num1))
        numbut.add(findViewById(R.id.num2))
        numbut.add(findViewById(R.id.num3))
        numbut.add(findViewById(R.id.num4))
        numbut.add(findViewById(R.id.num5))
        numbut.add(findViewById(R.id.num6))
        numbut.add(findViewById(R.id.num7))
        numbut.add(findViewById(R.id.num8))
        numbut.add(findViewById(R.id.num9))
        opbut.add(findViewById(R.id.opdiv))
        opbut.add(findViewById(R.id.opmul))
        opbut.add(findViewById(R.id.opsub))
        opbut.add(findViewById(R.id.opplus))
        res=findViewById(R.id.resu)
        pm=findViewById(R.id.pm)
        per=findViewById(R.id.period)
        del=findViewById(R.id.del)
        cl=findViewById(R.id.cle)


    }

}