package th.ac.kku.cis.my_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageView

class HomePageActivity : AppCompatActivity() {

    //lateinit var settings_icon : ImageView
    lateinit var settings_btn : Button
    lateinit var ManVSFood_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //settings_icon = findViewById(R.id.settings_icon)
        settings_btn = findViewById(R.id.settings_btn)
        ManVSFood_btn = findViewById(R.id.ManVSFood_btn)

        settings_btn.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java);
            startActivity(intent)

            }

        ManVSFood_btn.setOnClickListener{
//            val intent = Intent(this, ManVSFoodActivity::class.java);
            val intent = Intent(this, ManVSFoodActivity::class.java);
            startActivity(intent)

        }
    }
}