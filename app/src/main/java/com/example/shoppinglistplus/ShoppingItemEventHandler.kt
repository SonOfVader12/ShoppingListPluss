package com.example.shoppinglistplus

import android.widget.EditText

class ShoppingItemEventHandler
(
    var onEnterPressed : () -> Unit,
    var onBackSpacePressed : (itemName : EditText) -> Unit
)