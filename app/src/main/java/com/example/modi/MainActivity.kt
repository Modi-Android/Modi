package com.example.projectcollaboration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.modi.Chatting.ChattingFragment
import com.example.modi.Member.MemberFragment
import com.example.modi.Project.ProjectFragment
import com.example.modi.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 상단 툴바
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        // 하단 프래그먼트
        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView


        bnv_main.run { setOnNavigationItemSelectedListener {
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
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.action_search -> {
                Toast.makeText(applicationContext, "검색 이벤트 실행", Toast.LENGTH_LONG).show()
                return super.onOptionsItemSelected(item)

            }
            R.id.action_info -> {
                Toast.makeText(applicationContext, "정보 이벤트 실행", Toast.LENGTH_LONG).show()
                return super.onOptionsItemSelected(item)
            }
            R.id.home -> {
                Toast.makeText(applicationContext, "뒤로 가기", Toast.LENGTH_LONG).show()
                finish()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}

