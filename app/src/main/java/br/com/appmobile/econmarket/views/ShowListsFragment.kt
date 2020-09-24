package br.com.appmobile.econmarket.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.appmobile.econmarket.R
import br.com.appmobile.econmarket.viewmodels.ListViewModel
import kotlinx.android.synthetic.main.fragment_show_lists.view.*
import kotlinx.android.synthetic.main.layout_show_lists_item.view.*

class ShowListsFragment : Fragment() {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var listViewModel: ListViewModel
    private lateinit var lists: MutableList<br.com.appmobile.econmarket.models.List>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_show_lists, container, false)

        this.listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        this.listViewModel.observerArrayList().observe(this, Observer {

            this.lists = it
            view.layout_show_lists_recyclerView.adapter = AdapterLists(this.lists)
        })
        this.listViewModel.loadArrayList()

        this.layoutManager = LinearLayoutManager(context)
        view.layout_show_lists_recyclerView.layoutManager = this.layoutManager

        return view
    }

    class AdapterLists(private val dataset: List<br.com.appmobile.econmarket.models.List>) :
        RecyclerView.Adapter<AdapterLists.ViewHolderLists>(){

        class ViewHolderLists(itemView: View) : RecyclerView.ViewHolder(itemView){

            val textViewName = itemView.layout_lists_item_textView_listName
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLists {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_show_lists_item, parent, false)
            return ViewHolderLists(view)
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