package com.example.modi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.modi.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    // 로그인시 보여짐

    // lazy를 이용해 뷰바인딩 적용
    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 로그인 버튼 클릭시 로그인되면서 메인 액티비티로 전환
        binding.btnLogin.setOnClickListener { 
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // 회원가입버튼 클릭시 이메일 인증 회원가입 액티비티로 전환
        binding.btnRegister.setOnClickListener { 
            val intent = Intent(this, SignUp_emailActivity::class.java)
            startActivity(intent)
        }
        
        // 패스워드 찾기 버튼 클릭시 패스워드 찾는 액티비티로 전환

    }
}