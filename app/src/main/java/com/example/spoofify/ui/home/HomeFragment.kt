package com.example.spoofify.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.spoofify.LoginActivity
import com.example.spoofify.R
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val linearLayouts = intArrayOf(R.id.linear_1, R.id.linear_2, R.id.linear_3, R.id.linear_4);
        var layoutNumber = 0;

        val images = intArrayOf(
                R.drawable.cat1music1, R.drawable.cat1music2, R.drawable.cat1music3, R.drawable.cat1music4, R.drawable.cat1music5,
                R.drawable.cat2music1, R.drawable.cat2music2, R.drawable.cat2music3, R.drawable.cat2music4, R.drawable.cat2music5,
                R.drawable.cat3music1, R.drawable.cat3music2, R.drawable.cat3music3, R.drawable.cat3music4, R.drawable.cat3music5,
                R.drawable.cat4music1, R.drawable.cat4music2, R.drawable.cat4music3, R.drawable.cat4music4, R.drawable.cat4music5);

        for (layout in linearLayouts) {
            val linearLayout = view.findViewById<LinearLayout>(layout) as LinearLayout

            for (i in 0 until (images.size / linearLayouts.size)) {
                var imageView = ImageView(activity);
                val layoutParams = LinearLayout.LayoutParams(200, 200);
                layoutParams.setMargins(7, 10, 7, 0)

                imageView.layoutParams = layoutParams;
                imageView.id = i;
                imageView.setImageResource(images[(layoutNumber * 5) + i])
                imageView.isClickable = true;

                linearLayout?.addView(imageView)
                imageView.requestLayout();

                imageView.setOnClickListener{
                    Toast.makeText(activity, "Now Downloading...", Toast.LENGTH_LONG).show()
                }
            }
            layoutNumber += 1;

        }

        return view;
    }
}
