package br.com.appmobile.econmarket.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.appmobile.econmarket.R
import br.com.appmobile.econmarket.viewmodels.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        //Esconder ProgressBar
        layout_register_progressBar.visibility = View.GONE

        //Evento de click no botão de registrar usuário
        register_button.setOnClickListener {

            //Exibir ProgressBar
            layout_register_progressBar.visibility = View.VISIBLE

            //Obter dados digitados nos EditTexts
            val name = layout_register_text_input_edit_text_name.text.toString()
            val email = layout_register_text_input_edit_text_email.text.toString()
            val password = layout_register_text_input_edit_text_password.text.toString()

            //fazer o registro no banco de dados
            registerViewModel.registerUser(name, email, password)
        }

        //Observar o registro do User
        registerViewModel.observerRegisterUser().observe(this, Observer {

            if(it != null){

                Toast.makeText(this, R.string.register_success, Toast.LENGTH_LONG).show()
                //Fechar activity de registro
                finish()
            }else{

                Toast.makeText(this, R.string.register_fail, Toast.LENGTH_LONG).show()
            }
        })
    }
}