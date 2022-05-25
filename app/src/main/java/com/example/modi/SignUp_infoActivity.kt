package com.example.modi

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup_info.*

class SignUp_infoActivity: AppCompatActivity() {
    // 회원가입시 정보 입력

    var items = arrayOf("기획, 디자인, 프론트엔드 개발, 백엔드 개발, 서버, ")
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_info)

        val Adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        part.adapter = Adapter1
        part.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("선택 없음")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                println(p2)
            }
        }
    }
}