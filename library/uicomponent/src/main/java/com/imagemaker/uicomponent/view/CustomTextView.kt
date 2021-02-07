package com.imagemaker.uicomponent.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.imagemaker.uicomponent.FontManager
import com.imagemaker.uicomponent.R

class CustomTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context) {
        typeface = FontManager.getRegular(context)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val styledAttrs = context.theme.obtainStyledAttributes(attrs, R.styleable.FontStyle, 0, 0)
        try {
            val fontType = styledAttrs.getInteger(R.styleable.FontStyle_fontType, FontManager.TYPE_REGULAR)
            typeface = FontManager.getFontFamily(context, fontType)
        }finally {
            styledAttrs.recycle()
        }
    }

}