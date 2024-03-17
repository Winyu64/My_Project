package th.ac.kku.cis.my_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class SettingsActivity : AppCompatActivity() {

    lateinit var back_btn : Button
    lateinit var off_img : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        back_btn = findViewById(R.id.back_btn)
        off_img = findViewById(R.id.off_img)

        back_btn.setOnClickListener{
            val intent = Intent(this, HomePageActivity::class.java);
            startActivity(intent)

        }

        // ในฟังก์ชัน onCreate() ของ SettingsActivity
        off_img.setOnClickListener{
            // สร้าง AlertDialog.Builder
            val builder = AlertDialog.Builder(this)
            builder.setTitle("ยืนยันการออกจากระบบ")
            builder.setMessage("คุณแน่ใจหรือไม่ที่ต้องการที่จะออกจากระบบ?")

            // เพิ่มปุ่ม 'ใช่' ใน AlertDialog
            builder.setPositiveButton("ใช่") { dialog, which ->
                // เรียกหน้า MainActivity หลังจากปิดออกจากแอปพลิเคชัน
                val intent = Intent(this@SettingsActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish() // ปิด SettingsActivity
            }

            // เพิ่มปุ่ม 'ไม่' ใน AlertDialog
            builder.setNegativeButton("ไม่") { dialog, which ->
            // ไม่ต้องทำอะไรเมื่อกดปุ่ม 'ไม่'
            }

            // สร้างและแสดง AlertDialog
            val dialog = builder.create()
            dialog.show()
        }
    }
}