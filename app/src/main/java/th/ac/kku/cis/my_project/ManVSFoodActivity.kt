package th.ac.kku.cis.my_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ManVSFoodActivity : AppCompatActivity() {

    lateinit var back_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man_vsfood)

        back_btn = findViewById(R.id.back_btn)

        back_btn.setOnClickListener{
            val intent = Intent(this, HomePageActivity::class.java);
            startActivity(intent)

        }
    }
}