package com.example.spoofify

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
//
//    private lateinit var logoutBtn: Button
//    private lateinit var updatePass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Already logged in", Toast.LENGTH_LONG).show()
        }

        setContentView(R.layout.activity_main)
        val linearLayouts = intArrayOf(R.id.linear_1, R.id.linear_2, R.id.linear_3, R.id.linear_4);
        var layoutNumber = 0;

        val images = intArrayOf(
                R.drawable.cat1music1, R.drawable.cat1music2, R.drawable.cat1music3, R.drawable.cat1music4, R.drawable.cat1music5,
                R.drawable.cat2music1, R.drawable.cat2music2, R.drawable.cat2music3, R.drawable.cat2music4, R.drawable.cat2music5,
                R.drawable.cat3music1, R.drawable.cat3music2, R.drawable.cat3music3, R.drawable.cat3music4, R.drawable.cat3music5,
                R.drawable.cat4music1, R.drawable.cat4music2, R.drawable.cat4music3, R.drawable.cat4music4, R.drawable.cat4music5);

        for (layout in linearLayouts) {
            val linearLayout = findViewById<LinearLayout>(layout) as LinearLayout

            for (i in 0 until (images.size / linearLayouts.size)) {
                var imageView = ImageView(this);
                val layoutParams = LinearLayout.LayoutParams(200, 200);
                layoutParams.setMargins(7, 15, 7, 0)

                imageView.layoutParams = layoutParams;
                imageView.id = i;
                imageView.setImageResource(images[(layoutNumber * 5) + i])
                imageView.isClickable = true;

                linearLayout?.addView(imageView)
                imageView.requestLayout();
            }
            layoutNumber += 1;
        }


        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    setContent("Home")
                    true
                }
                R.id.menu_request -> {
                    setContent("Request")
                    true
                }
                R.id.menu_search -> {
                    setContent("Search")
                    true
                }
                R.id.SettingsFragment -> {
                    setContent("Settings")
                    true
                }
                else -> false
            }
        }
    }
    private fun setContent(content: String) {
        setTitle(content)
        tvLabel.text = content
    }
    fun Int.dpToPixels(context: Context):Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,this.toFloat(),context.resources.displayMetrics
    )
    }
