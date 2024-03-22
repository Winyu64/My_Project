package th.ac.kku.cis.my_project

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase


class ManVSFoodActivity : AppCompatActivity() {

    lateinit var back_btn : Button
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : Adapter
    lateinit var floatingActionButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man_vsfood)

        back_btn = findViewById(R.id.back_btn)
        recyclerView = findViewById(R.id.rv)
        floatingActionButton = findViewById(R.id.floatingActionButton)

        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(
                FirebaseDatabase.getInstance().getReference().child( "teachers"),
                MainModel::class.java
            )
            .build()

        adapter = Adapter(options)
        recyclerView.adapter = adapter

        floatingActionButton.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java);
            startActivity(intent)
        }

        back_btn.setOnClickListener{
            val intent = Intent(this, HomePageActivity::class.java);
            startActivity(intent)

        }
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        val item = menu.findItem(R.id.search)
        val searchView = item.actionView as SearchView?
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                txtSearch(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                txtSearch(query)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun txtSearch(str: String) {
        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(
                FirebaseDatabase.getInstance().reference.child("teachers").orderByChild("name")
                    .startAfter(str).endAt(
                        "$str~"
                    ),
                MainModel::class.java
            )
            .build()
        adapter = Adapter(options)
        adapter.startListening()
        recyclerView.setAdapter(adapter)
    }
}