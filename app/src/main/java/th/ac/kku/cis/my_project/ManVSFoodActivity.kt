package th.ac.kku.cis.my_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase



class ManVSFoodActivity : AppCompatActivity() {

    lateinit var back_btn : Button
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : Adapter
    lateinit var action_search : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man_vsfood)

        back_btn = findViewById(R.id.back_btn)
        recyclerView = findViewById(R.id.rv)

        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ในภาษา Kotlin, การสร้างอ็อบเจ็กต์ใหม่ไม่ต้องใช้คำว่า new เหมือนในภาษา Java แทนที่จะใช้คำว่า new คุณสามารถใช้การสร้างอ็อบเจ็กต์โดยตรงได้ดังนี้:
        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(
                FirebaseDatabase.getInstance().getReference().child( "teachers"),
                MainModel::class.java
            )
            .build()

        //Adapter = new Adapter(options);ราสามารถสร้างอ็อบเจกต์โดยตรงโดยไม่ต้องใช้ new ดังนี้:
        //recyclerView.setAdapter(Adapter);
       adapter = Adapter(options)
        recyclerView.adapter = adapter




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
        adapter.startListening()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        val item: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView: SearchView? = item?.actionView as? SearchView

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { txtSearch(it) }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let { txtSearch(it) }
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }
    private fun txtSearch(str: String) {
        val query = FirebaseDatabase.getInstance().getReference().child("teachers")
            .orderByChild("name")
            .startAt(str)
            .endAt(str + "\uf8ff")

        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(query, MainModel::class.java)
            .build()

        adapter = Adapter(options)
        adapter.startListening()
        recyclerView.adapter = adapter
    }

//    private fun txtSearch(str: String) {
//        val options = FirebaseRecyclerOptions.Builder<MainModel>()
//            .setQuery(
//                FirebaseDatabase.getInstance().getReference().child( "teachers").orderByChild("name").startAt(str).endAt(str+"~"),
//                MainModel::class.java
//            )
//            .build()
//
//        adapter = Adapter(options)
//        adapter.startListening()
//        recyclerView.adapter = adapter
//    }
}