package com.example.testapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


//    private val viewModel by viewModel<MainViewModel>()
    private lateinit var dataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("AAA", "Activity created")

        dataTextView = findViewById(R.id.textViewData)
        initViewModel()
        initOnClickListeners()
    }

    private fun initViewModel() {
        viewModel.resultLiveData.observe(this) {
            dataTextView.text = it
        }
    }

    private fun initOnClickListeners() {
        val dataEditView = findViewById<EditText>(R.id.editTextName)
        val sendButton = findViewById<Button>(R.id.buttonSaveName)
        val receiveButton = findViewById<Button>(R.id.buttonGetData)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            viewModel.save(text)
        }

        receiveButton.setOnClickListener {
            viewModel.load()
        }
    }
}