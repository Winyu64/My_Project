package th.ac.kku.cis.my_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class Add_FoodActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var details: EditText
    lateinit var location: EditText
    lateinit var foodurl : EditText
    lateinit var btnAdd : Button
    lateinit var back_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        name = findViewById<View>(R.id.txtName) as EditText
        details = findViewById<View>(R.id.txtDetails) as EditText
        location = findViewById<View>(R.id.txtLocation) as EditText
        foodurl = findViewById<View>(R.id.txtImageURL) as EditText
        btnAdd = findViewById<View>(R.id.btnAdd) as Button
        back_btn = findViewById<View>(R.id.back_btn) as Button

        btnAdd.setOnClickListener { }
        back_btn.setOnClickListener { finish() }

        btnAdd.setOnClickListener {
            insertData()
            clearAll()
        }
        back_btn.setOnClickListener{
            val intent = Intent(this, ManVSFoodActivity::class.java);
            startActivity(intent)

        }
    }

    private fun insertData() {
        val map = hashMapOf<String, Any>()
        map["name"] = name.text.toString()
        map["details"] = details.text.toString()
        map["location"] = location.text.toString()
        map["foodurl"] = foodurl.text.toString()

        FirebaseDatabase.getInstance().reference.child("Food").push()
            .setValue(map)
            .addOnSuccessListener {
                Toast.makeText(
                    this@Add_FoodActivity,
                    "บันทึกข้อมูลสำเร็จ",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener {
                Toast.makeText(
                    this@Add_FoodActivity,
                    "Error เกิดข้อผิดพลาดขณะบันทึกข้อมูล",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
    private fun clearAll() {
        name.setText("")
        details.setText("")
        location.setText("")
        foodurl.setText("")
    }
}
