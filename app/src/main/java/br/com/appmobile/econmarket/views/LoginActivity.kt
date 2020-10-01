package br.com.appmobile.econmarket.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.appmobile.econmarket.R
import br.com.appmobile.econmarket.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object{

        fun getKeyUserExtra(): String = "USER_EXTRA"
    }

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        //Esconder ProgressBar
        layout_login_progressBar.visibility = View.GONE

        //Evento de click no botão de login
        login_button.setOnClickListener {

            //Exibir ProgressBar
            layout_login_progressBar.visibility = View.VISIBLE
            //Obter os dados digitados nos EditText
            var email = layout_login_text_input_edit_text_email.text.toString()
            var password = layout_login_text_input_edit_text_password.text.toString()
            //Fazer o login no banco de dados
            loginViewModel.login(email, password)
        }

        //Evento de click no botão de cadastrar
        register_button.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //Observar o login
        loginViewModel.observerLoginUser().observe(this, Observer {

            //Esconder ProgressBar
            layout_login_progressBar.visibility = View.GONE

            if(it != null){//Login ok

                val intent = Intent(this, ShowListsActivity::class.java)
                //Enviar o User para próxima activity
                intent.putExtra(getKeyUserExtra(), it)
                startActivity(intent)
            }else{//Login fail

                Toast.makeText(this, R.string.user_not_found, Toast.LENGTH_LONG).show()
            }
        })
    }
}