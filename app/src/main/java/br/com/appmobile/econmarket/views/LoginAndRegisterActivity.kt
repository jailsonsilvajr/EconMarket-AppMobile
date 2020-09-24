package br.com.appmobile.econmarket.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.appmobile.econmarket.R

class LoginAndRegisterActivity : AppCompatActivity() {

    private val fragmentTransaction = this.supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_and_register)

        this.fragmentTransaction.add(R.id.layout_login_and_register_framelayout, LoginFragment())
        this.fragmentTransaction.commit()
    }
}