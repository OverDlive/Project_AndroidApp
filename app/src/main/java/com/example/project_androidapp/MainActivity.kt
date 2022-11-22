package com.example.project_androidapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_java.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_email.imeOptions = EditorInfo.IME_ACTION_SEND
        // 마지막  에딧텍스트 완료버튼은  Log in 호출
        et_age.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                Login(v)
                true
            }
            else false
        }

        // 불러오기
        var pref = this.getPreferences(0)
        et_email.setText(pref.getString("이메일", ""))
        et_password.setText(pref.getString("비밀번호", ""))
        et_name.setText(pref.getString("이름", ""))
        et_age.setText(pref.getString("나이", ""))
    }

    fun Login(v : View) {
        //키보드 숨기기
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)

        //입력 정보 비교
        if(et_email.text.toString() == "donghyeok7312@naver.com" && et_password.text.toString() == "1234" && et_name.text.toString() == "donghyeok" && et_age.text.toString() == "22") {
            var intent = Intent(this, JavaActivity::class.java)
            intent.putExtra("이름", "Over")
            startActivity(intent)

            setContentView(R.layout.activity_java)
            tv_result.text = "Over님 환영합니다"

            //저장
            var editor = this.getPreferences(0).edit()
            editor.putString("이메일", "donghyeok7312@naver.com").apply()
            editor.putString("비밀번호", "1234").apply()
            editor.putString("이름", "donghyeok").apply()
            editor.putString("나이", "22").apply()

            Toast.makeText(this, "로그인 성공!!", Toast.LENGTH_SHORT).show()
        }
        else Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
    }
}