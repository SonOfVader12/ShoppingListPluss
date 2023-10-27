package com.example.shoppinglistplus
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.util.Log
import android.util.LongSparseArray
import android.view.View.OnKeyListener
import android.view.translation.ViewTranslationResponse
import android.widget.LinearLayout
import android.widget.ToggleButton
import java.lang.Exception
import kotlin.math.log


class ShoppingListItem@JvmOverloads constructor(context : Context,  attrs: AttributeSet? = null, defStyleAttr:Int = 0, defStyleRes:Int=0):
    LinearLayout(context,  attrs,  defStyleAttr, defStyleRes){
    lateinit var ItemEventListener: ShoppingItemEventHandler

    init {
        try {
            inflate(context, R.layout.shopping_item, this)
            var toggle: ToggleButton = findViewById(R.id.toggleButton)

            var itemName: EditText = findViewById(R.id.itemName)
            itemName.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->

                if (keyCode == KeyEvent.KEYCODE_ENTER && KeyEvent.ACTION_UP == event.action) {
                    ItemEventListener.onEnterPressed()
                    Log.d("ShoppingLog", "Enter Pressed")
                    return@OnKeyListener true
                } else if (keyCode == KeyEvent.KEYCODE_DEL && KeyEvent.ACTION_UP == event.action) {
                    ItemEventListener.onBackSpacePressed(itemName)
                    Log.d("ShoppingLog", "BACK Pressed")
                    return@OnKeyListener true
                }

                false
            })
            itemName.requestFocus()

        }
        catch(ex : Exception){
            Log.d("ShoppingList", "Exception In Item Init" + ex.message + ex.stackTraceToString())
        }
    }

    override fun requestFocus(direction: Int, previouslyFocusedRect: Rect?): Boolean {
        var itemName: EditText = findViewById(R.id.itemName)
        return itemName.requestFocus(direction, previouslyFocusedRect)
    }



}




