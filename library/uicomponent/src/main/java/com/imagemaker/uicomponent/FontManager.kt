package com.imagemaker.uicomponent

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat

object FontManager {

    const val TYPE_LIGHT = 1
    const val TYPE_ITALIC = 2
    const val TYPE_REGULAR = 3
    const val TYPE_MEDIUM = 4
    const val TYPE_BOLD = 5

    fun getLight(context: Context): Typeface? {
        return ResourcesCompat.getFont(context, R.font.alegreya_sans_light)
    }

    fun getItalic(context: Context): Typeface? {
        return ResourcesCompat.getFont(context, R.font.alegreya_sans_italic)
    }

    fun getRegular(context: Context): Typeface? {
        return ResourcesCompat.getFont(context, R.font.alegreya_sans_regular)
    }

    fun getMedium(context: Context): Typeface? {
        return ResourcesCompat.getFont(context, R.font.alegreya_sans_medium)
    }

    fun getBold(context: Context): Typeface? {
        return ResourcesCompat.getFont(context, R.font.alegreya_sans_bold)
    }

    fun getFontFamily(context: Context, fontType: Int): Typeface? = when (fontType) {
        TYPE_LIGHT -> getLight(context)
        TYPE_ITALIC -> getItalic(context)
        TYPE_REGULAR -> getRegular(context)
        TYPE_MEDIUM -> getMedium(context)
        TYPE_BOLD -> getBold(context)
        else -> getRegular(context)
    }

}