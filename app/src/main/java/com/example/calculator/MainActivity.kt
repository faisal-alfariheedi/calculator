package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
    lateinit var num1: ArrayList<Char>
    lateinit var num2:ArrayList<Char>
    var op:String =""
    var cont:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        disinit()
        numbut[0].setOnClickListener{addnum('0') }
        numbut[1].setOnClickListener{addnum('1') }
        numbut[2].setOnClickListener{addnum('2') }
        numbut[3].setOnClickListener{addnum('3') }
        numbut[4].setOnClickListener{addnum('4') }
        numbut[5].setOnClickListener{addnum('5') }
        numbut[6].setOnClickListener{addnum('6') }
        numbut[7].setOnClickListener{addnum('7') }
        numbut[8].setOnClickListener{addnum('8') }
        numbut[9].setOnClickListener{addnum('9') }
        opbut[0].setOnClickListener{op="/" ;num=false ;update()}
        opbut[1].setOnClickListener{op="*" ;num=false ;update()}
        opbut[2].setOnClickListener{op="-" ;num=false ;update()}
        opbut[3].setOnClickListener{op="+" ;num=false ;update()}
        res.setOnClickListener{resu() }
        pm.setOnClickListener{pmc() }
        per.setOnClickListener{addnum('.');update() }
        del.setOnClickListener{dele() }
        cl.setOnClickListener{num1.clear();num2.clear();op="";update();num=true }
//        num1.joinToString("").toFloat()


    }




    /////////////// display element initializer
    fun disinit(){
        numbut=arrayListOf()
        opbut=arrayListOf()
        num1=arrayListOf()
        num2=arrayListOf()
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


    fun addnum(nu: Char){

        if(num){
            if(num1.isNotEmpty())if(num1[0].equals('0'))num1.clear()
            num1.add(nu)

        }else{
            if(cont) {
                if(num2.isNotEmpty())if(num2[0].equals('0'))num2.clear()
                num2.add(nu)
            }else{
                Toast.makeText(this,"choose an operation first",Toast.LENGTH_SHORT).show()
            }
        }
        update()
    }

    fun pmc(){

        if(num){
            if(num1.isNotEmpty()) {
                if (num1[0].equals('-')) {
                    num1.removeAt(0)
                } else num1.add(0, '-')
            }
        }else {
            if (num2.isNotEmpty()) {
                if (num2[0].equals('-')) {
                    num2.removeAt(0)
                }else num2.add(0, '-')
            }
        }
        update()
    }
    fun dele(){
      var temp =displ.text.toString()
      if(temp[temp.count()-1].toIntOrNull()==null||temp[temp.count()-1].equals(".")){
        if(num){
          num1.removelast()
        }else{
          num2.removelast()
        }
      }else op="";num=true
      update()
    }

    fun resu(){
        var a:Int=0
        if(!num2.isEmpty()) {
            var re: String = ""
            when (op) {
                "/" -> {
                    re = (num1.joinToString("").toFloat() / num2.joinToString("")
                        .toFloat()).toString()
                }
                "*" -> {
                    re = (num1.joinToString("").toFloat() * num2.joinToString("")
                        .toFloat()).toString()
                }
                "-" -> {
                    re = (num1.joinToString("").toFloat() - num2.joinToString("")
                        .toFloat()).toString()
                }
                "+" -> {
                    re = (num1.joinToString("").toFloat() + num2.joinToString("")
                        .toFloat()).toString()
                }
            }
            op = ""
            num1.clear()
            num2.clear()
            for (i in re.toCharArray()) {
                num1.add(i)
            }
            update()
        }else{

            if(num2.isEmpty()){
                a=1
            }
            if(op.isEmpty()){
                a=2
            }
            if(num1.isEmpty()){
                a=1
            }
            when(a){
                1->Toast.makeText(this,"enter a number",Toast.LENGTH_SHORT).show()
                2->Toast.makeText(this,"choose an operation",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun update(){
//        displ.text="$num1$op$num2"
        displ.text= "${TextUtils.join("",num1)}${TextUtils.join("",op.toCharArray().toMutableList())}${TextUtils.join("",num2)}"
        if(displ.text.isNullOrEmpty()){
            displ.text="0.0"
        }
    }
}