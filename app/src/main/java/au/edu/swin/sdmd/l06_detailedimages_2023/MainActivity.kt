package au.edu.swin.sdmd.l06_detailedimages_2023

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var station: Location
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        station = Location("Glenferrie Station", "Ada May Plante",
            -37.82154f, 145.03647f)

        val vStation = findViewById<TextView>(R.id.station)
        vStation.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("location", station)
            //startActivity(intent)
            startForResult.launch(intent)
        }
    }

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when(result.resultCode){
                RESULT_OK -> {
                    val data = result.data
                    val visited = data?.getParcelableExtra<Location>("visited")
                    val vStation = findViewById<TextView>(R.id.station)
                    visited?.let {
                        vStation.setTextColor(if (it.visited) Color.GREEN else Color.RED)
                        station = visited
                    }
                }
            }

        }


}