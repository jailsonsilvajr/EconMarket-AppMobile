package br.com.appmobile.econmarket.views.lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.appmobile.econmarket.R
import br.com.appmobile.econmarket.viewmodels.AddListViewModel
import kotlinx.android.synthetic.main.fragment_add_list.view.*

class AddListFragment : Fragment() {

    lateinit var addListViewModel: AddListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_add_list, container, false)

        this.addListViewModel = ViewModelProvider(this).get(AddListViewModel::class.java)
        this.addListViewModel.observerNewList().observe(this, Observer {

            if(it != null){

                Toast.makeText(context, "Lista " + it.name + " criada com sucesso.", Toast.LENGTH_LONG).show()

            }else{

                Toast.makeText(context, "Falha ao criar a lista.", Toast.LENGTH_LONG).show()
            }
        })

        view.fragment_add_list_button_save.setOnClickListener {

            val name = view.fragment_add_list_text_input_edit_text_name.text.toString()
            this.addListViewModel.addNewList(name)
        }

        return view
    }
}