package th.ac.kku.cis.my_project

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class AddActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var course: EditText
    lateinit var email: EditText
    lateinit var turl : EditText
    lateinit var btnAdd : Button
    lateinit var back_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        name = findViewById<View>(R.id.txtName) as EditText
        course = findViewById<View>(R.id.txtCourse) as EditText
        email = findViewById<View>(R.id.txtEmail) as EditText

        turl = findViewById<View>(R.id.txtImageURL) as EditText
        btnAdd = findViewById<View>(R.id.btnAdd) as Button
        back_btn = findViewById<View>(R.id.back_btn) as Button

        btnAdd.setOnClickListener { }
        back_btn.setOnClickListener { finish() }

        btnAdd.setOnClickListener {
            insertData()
            clearAll()
        }
        back_btn.setOnClickListener { finish() }
    }

    private fun insertData() {
        val map = hashMapOf<String, Any>()
        map["name"] = name.text.toString()
        map["course"] = course.text.toString()
        map["email"] = email.text.toString()
        map["turl"] = turl.text.toString()

        FirebaseDatabase.getInstance().reference.child("teachers").push()
            .setValue(map)
            .addOnSuccessListener {
                Toast.makeText(
                    this@AddActivity,
                    "Data Inserted Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener {
                Toast.makeText(
                    this@AddActivity,
                    "Error while Insertion",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
    private fun clearAll() {
        name.setText("")
        course.setText("")
        email.setText("")
        turl.setText("")
    }
}
