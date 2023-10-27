package com.example.shoppinglistplus
import android.util.Log
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebSettings.TextSize
import android.widget.EditText
import android.widget.LinearLayout

class ShoppingListCategory @JvmOverloads constructor(context : Context,  attrs: AttributeSet? = null, defStyleAttr:Int = 0, defStyleRes:Int=0) :
    LinearLayout(context,  attrs,  defStyleAttr, defStyleRes){
    var numberOfItems : Int = 0
    init {
        try{


            createNewCategory()
            createNewItem()

        }
        catch(ex : Exception){
            Log.d("ShoppingList", "Exception In Category Init" + ex.message + ex.stackTraceToString())
        }
    }
    fun createNewCategory (){
        var editText = EditText(context)
        editText.setSingleLine()
        editText.setText("Category")
        editText.gravity = Gravity.CENTER
        this.addView(editText)
    }
    fun createNewItem() {
        var item : ShoppingListItem = ShoppingListItem(context)
      var eventListener : ShoppingItemEventHandler = ShoppingItemEventHandler (
            ::createNewItem,
            ::tryDeleteLine
        )
        item.ItemEventListener = eventListener
        item.id = numberOfItems
        addView(item)
        numberOfItems++

    }
    fun tryDeleteLine(itemName : EditText) {
        try{
            if(itemName.text.isEmpty() && numberOfItems > 1){
                Log.d("ShoppingLog", "SHOULD DELETE")
                val theParent : ShoppingListItem = (itemName.parent).parent as ShoppingListItem
                this.removeView(theParent)
                numberOfItems--
                val oneAbove : ShoppingListItem  =   this.getChildAt(numberOfItems) as ShoppingListItem
                oneAbove.requestFocus()
            }
        }
      catch (ex : java.lang.Exception){
          Log.d("ShoppingLog", "Delete line error"+ ex.message)
      }
    }
}