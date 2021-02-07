package com.imagemaker.uicomponent.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import com.imagemaker.uicomponent.FontManager
import com.imagemaker.uicomponent.R

class ButtonView : AppCompatButton {

    private var buttonType = PRIMARY

    companion object {
        private const val PRIMARY: Int = 0
        private const val SECONDARY: Int = 1
    }

    constructor(context: Context) :super(context){
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        initAttrs(context,attrs)
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initAttrs(context,attrs)
        init(context)
    }

    private fun init(context: Context){
        setUpButton(context)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?){
        val styledAtt = context.theme.obtainStyledAttributes(attrs, R.styleable.ButtonView, 0, 0)

        try {
            buttonType = styledAtt.getInteger(R.styleable.ButtonView_buttonType, 0)
            val fontType = styledAtt.getInteger(R.styleable.FontStyle_fontType, FontManager.TYPE_MEDIUM)
            setBackgroundButtonView(buttonType)
            setFontFamily(context,fontType)
        } finally {
            styledAtt.recycle()
        }
    }

    private fun setUpButton(context: Context){
        typeface = FontManager.getMedium(context)
        minHeight = resources.getDimension(R.dimen.min_height_button).toInt()
        minWidth = resources.getDimension(R.dimen.min_width_button).toInt()
        gravity = Gravity.CENTER
    }

    private fun setFontFamily(context: Context, fontType : Int){
        typeface = FontManager.getFontFamily(context, fontType)
    }

    private fun setBackgroundButtonView(buttonType: Int) {
        when (buttonType) {
            PRIMARY -> setBackgroundResource(R.drawable.primary_button_shape)
            SECONDARY -> setBackgroundResource(R.drawable.secondary_button_shape)
            else -> setBackgroundResource(R.drawable.primary_button_shape)
        }
    }

}