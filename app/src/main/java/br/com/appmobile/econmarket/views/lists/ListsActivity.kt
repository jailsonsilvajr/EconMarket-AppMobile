package br.com.appmobile.econmarket.views.lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.appmobile.econmarket.R

class ListsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lists)

        this.supportFragmentManager.beginTransaction()
            .add(R.id.layout_lists_framelayout,
                ShowListsFragment()
            )
            .commit()
    }
}