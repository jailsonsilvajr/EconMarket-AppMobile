package br.com.appmobile.econmarket.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.appmobile.econmarket.R
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.viewmodels.AddListViewModel
import kotlinx.android.synthetic.main.activity_add_list.*

class AddListActivity : AppCompatActivity() {

    companion object{

        fun getKeyListAddExtra(): String = "LIST_ADD_EXTRA"
    }

    private lateinit var addListViewModel: AddListViewModel
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list)

        val extra = intent.extras
        if(extra != null) user = extra.get(LoginActivity.getKeyUserExtra()) as User
        if(user == null) {

            Toast.makeText(this, "FATAL ERROR", Toast.LENGTH_LONG).show()
            finish()
        }

        addListViewModel = ViewModelProvider(this).get(AddListViewModel::class.java)

        //Evento de click no botão de salvar lista
        layout_add_list_button_save.setOnClickListener {

            //Obter nome digitado
            val name = layout_add_list_text_input_edit_text_name.text.toString()
            //Salvar lista no banco de dados
            this.user?.let { it1 -> addListViewModel.addList(name, it1) }
        }

        //Observar se a lista foi salva
        addListViewModel.observerAddList().observe(this, Observer {

            if(it != null){

                //Mostrar mensagem de sucesso
                Toast.makeText(this, R.string.list_add_success, Toast.LENGTH_LONG).show()
                //Preparar retorno pra tela de listas
                val intent = Intent()
                intent.putExtra(getKeyListAddExtra(), it)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }else{

                Toast.makeText(this, R.string.lista_add_fail, Toast.LENGTH_LONG).show()
            }
        })
    }
}