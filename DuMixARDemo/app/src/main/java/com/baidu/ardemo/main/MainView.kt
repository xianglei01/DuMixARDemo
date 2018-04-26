package com.baidu.ardemo.main

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.baidu.ardemo.R
import org.jetbrains.anko.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
class MainView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        verticalLayout {
            orientation = LinearLayout.VERTICAL
            include<View>(R.layout.base_title_layout) {
                find<TextView>(R.id.base_title).textResource = R.string.app_title
            }
            listView {
                id = R.id.main_list
            }.lparams(matchParent, matchParent)
        }
    }
}