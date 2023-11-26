package com.example.testapp.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.App
import com.example.testapp.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var dataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("AAA", "Activity created")
        (applicationContext as App).appComponent.inject(this)

        dataTextView = findViewById(R.id.textViewData)
        initViewModel()
        initOnClickListeners()

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
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