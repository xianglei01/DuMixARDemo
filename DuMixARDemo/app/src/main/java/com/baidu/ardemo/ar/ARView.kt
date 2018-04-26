package com.baidu.ardemo.ar

import android.content.Context
import android.view.View
import com.baidu.ardemo.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent

/**
 * Created by lei.xiang on 2018/4/26.
 */
class ARView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        frameLayout {
            id = R.id.ar_layout
            lparams(matchParent, matchParent)
        }
    }
}