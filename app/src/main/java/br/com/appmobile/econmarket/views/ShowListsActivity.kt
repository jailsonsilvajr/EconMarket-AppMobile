package br.com.appmobile.econmarket.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.appmobile.econmarket.R
import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.viewmodels.ShowListsViewModel
import kotlinx.android.synthetic.main.activity_show_lists.*
import kotlinx.android.synthetic.main.layout_show_lists_item.view.*

class ShowListsActivity : AppCompatActivity() {

    private val REQUEST_CODE_ADD_LIST = 1;

    private lateinit var showListsViewModel: ShowListsViewModel
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_lists)

        showListsViewModel = ViewModelProvider(this).get(ShowListsViewModel::class.java)

        //Obter User enviado da activity login
        val extra = intent.extras
        if(extra != null) user = extra.get(LoginActivity.getKeyUserExtra()) as User

        //Configurar RecyclerView
        layout_show_lists_recyclerView.layoutManager = LinearLayoutManager(this)
        layout_show_lists_recyclerView.adapter = user.lists?.let {
            AdapterLists(
                it
            )
        }

        //FloatingAction
        layout_show_lists_floatingActionButton.setOnClickListener {

            val intent = Intent(this, AddListActivity::class.java)
            intent.putExtra(LoginActivity.getKeyUserExtra(), user)
            startActivityForResult(intent, REQUEST_CODE_ADD_LIST)
        }

        //Observar atualização do User
        showListsViewModel.observerUser().observe(this, Observer {

            if(it != null){

                this.user.lists.clear()
                this.user.lists.addAll(it.lists)
                //Atualizar RecyclerView
                layout_show_lists_recyclerView.adapter?.notifyDataSetChanged()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_ADD_LIST){//Retorno da tela de adicionar lista

            if(resultCode == Activity.RESULT_OK){//Uma lista foi adicionada com sucesso

                if(data != null){

                    val list = data.getSerializableExtra(AddListActivity.getKeyListAddExtra()) as List
                    //Atualizar recyclerView
                    this.user.lists.add(list)
                    layout_show_lists_recyclerView.adapter?.notifyDataSetChanged()
                }
            }
        }
    }

    class AdapterLists(private val dataset: MutableList<List>) : RecyclerView.Adapter<AdapterLists.ViewHolderLists>(){

        class ViewHolderLists(itemView: View) : RecyclerView.ViewHolder(itemView){

            val textViewName = itemView.layout_lists_item_textView_listName
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLists {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_show_lists_item, parent, false)
            return ViewHolderLists(
                view
            )
        }

        override fun onBindViewHolder(holder: ViewHolderLists, position: Int) {

            val list = dataset.get(position)
            holder.textViewName.text = list.name
        }

        override fun getItemCount(): Int {

            return dataset.size
        }
    }
}