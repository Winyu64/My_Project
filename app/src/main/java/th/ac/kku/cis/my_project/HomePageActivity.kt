package th.ac.kku.cis.my_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class HomePageActivity : AppCompatActivity() {

    //lateinit var settings_icon : ImageView
    lateinit var settings_btn : Button
    lateinit var Man_VS_Food_btn : Button
    lateinit var Man_VS_Drink_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //settings_icon = findViewById(R.id.settings_icon)
        settings_btn = findViewById(R.id.settings_btn)
        Man_VS_Food_btn = findViewById(R.id.Man_VS_Food_btn)
        Man_VS_Drink_btn = findViewById(R.id.Man_VS_Drink_btn)

        settings_btn.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java);
            startActivity(intent)

            }

        Man_VS_Food_btn.setOnClickListener{
//            val intent = Intent(this, ManVSFoodActivity::class.java);
            val intent = Intent(this, ManVSFoodActivity::class.java);
            startActivity(intent)
        }
        Man_VS_Drink_btn.setOnClickListener{
//            val intent = Intent(this, ManVSFoodActivity::class.java);
            val intent = Intent(this, ManVSDrinkActivity::class.java);
            startActivity(intent)
        }

    }
}