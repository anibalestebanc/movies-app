package com.imagemaker.uicomponent.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.imagemaker.uicomponent.FontManager
import com.imagemaker.uicomponent.R

class EditTextView : AppCompatEditText {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(context, attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttrs(context, attrs)
        init()
    }

    private fun init() {
        setUpEditText()
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        val styledAtt = context.theme.obtainStyledAttributes(attrs, R.styleable.FontStyle, 0, 0)
        try {
            val fontType = styledAtt.getInteger(R.styleable.FontStyle_fontType, FontManager.TYPE_MEDIUM)
            setFontFamily(context, fontType)
        } finally {
            styledAtt.recycle()
        }
    }

    private fun setFontFamily(context: Context, fontType: Int) {
        typeface = FontManager.getFontFamily(context, fontType)
    }

    private fun setUpEditText() {
        minHeight = resources.getDimension(R.dimen.min_height_edit_text).toInt()
        //textSize = resources.getDimension(R.dimen.text_size_edit_text)
    }

}