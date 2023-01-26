package com.example.mypet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import net.daum.mf.map.api.MapView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapView = MapView(this)

        val mapViewContainer = map_view as ViewGroup
        mapViewContainer.addView(mapView)
    }
}
