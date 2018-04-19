package com.baidu.ardemo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by lei.xiang on 2018/4/17.
 */
open class BaseActivity : Activity() {

    private var mTvTitle: TextView? = null

    fun setContentView(view: View, needTitle: Boolean) {
        setContentView(view, LayoutInflater.from(this), needTitle)
    }

    fun setContentView(layoutResID: Int, needTitle: Boolean) {
        val layoutInflater = LayoutInflater.from(this)
        setContentView(layoutInflater.inflate(layoutResID, null), layoutInflater, needTitle)
    }

    fun setContentView(view: View, layoutInflater: LayoutInflater, needTitle: Boolean) {
        if (needTitle) {
            val titleLayout = layoutInflater.inflate(R.layout.layout_base_title, null)
            var parent = titleLayout.findViewById<LinearLayout>(R.id.base_layout)
            parent.addView(view, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT))
            setContentView(titleLayout)
        } else {
            setContentView(view)
        }
    }

    fun setTitleTxt(resId: Int) {
        setTitleTxt(getString(resId))
    }

    fun setTitleTxt(res: String?) {
        try {
            mTvTitle = findViewById(R.id.base_title)
            mTvTitle!!.text = res ?: ""
        } catch (e: Exception) {
        }

    }

}