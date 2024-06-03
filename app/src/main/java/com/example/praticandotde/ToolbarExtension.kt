package com.example.praticandotde

import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.setupActionToolbar(title: String, enableBackButton: Boolean) {
    supportActionBar?.apply {
        this.title = title
        setDisplayHomeAsUpEnabled(enableBackButton)
    }
}


