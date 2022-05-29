package com.example.modi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.modi.Chatting.ChattingFragment
import com.example.modi.Member.MemberFragment
import com.example.modi.Project.ProjectFragment
import com.example.modi.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 상단 툴바
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false) // 왼쪽버튼 사용 여부

        // 하단 프래그먼트
        var btn_main = findViewById<BottomNavigationView>(R.id.bnv_main)

        btn_main.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.first -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val memberFragment = MemberFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, memberFragment).commit()
                }
                R.id.second -> {
                    val projectFragment = ProjectFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, projectFragment).commit()
                }
                R.id.third -> {
                    val chattingFragment = ChattingFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, chattingFragment).commit()
                }
            }
            true
        }
            selectedItemId = R.id.second
        }
    }

    // 상단 툴바
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.action_search -> {
                Toast.makeText(applicationContext, "검색 이벤트 실행", Toast.LENGTH_LONG).show()
                return super.onOptionsItemSelected(item)
            }
            R.id.action_info -> {
                val intent = Intent(this, MyinfoActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

