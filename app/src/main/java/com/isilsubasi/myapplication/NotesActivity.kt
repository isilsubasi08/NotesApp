package com.isilsubasi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isilsubasi.myapplication.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}