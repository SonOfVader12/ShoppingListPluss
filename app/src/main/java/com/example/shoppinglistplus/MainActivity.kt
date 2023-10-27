package com.example.shoppinglistplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.util.Log
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            try{
                setContentView(R.layout.activity_main)
            }catch (ex : Exception){
                Log.d("ShoppingLog", "MAIN EX\n" + ex.message + "\n" + ex.stackTraceToString())
            }

            }

        }

    }

