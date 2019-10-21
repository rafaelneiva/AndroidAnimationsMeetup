package com.rafaelneiva.androidanimations.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafaelneiva.androidanimations.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        tvTitle.text = intent.extras?.getString(titleKey)
    }

    companion object {
        const val titleKey = "title-key"
    }

}
