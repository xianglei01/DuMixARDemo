package com.baidu.ardemo.result

import android.content.Context
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.baidu.ardemo.R
import org.jetbrains.anko.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
class ResultView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        verticalLayout {
            orientation = LinearLayout.VERTICAL
            include<View>(R.layout.base_title_layout) {
                find<TextView>(R.id.base_title).textResource = R.string.demo_title
            }
            scrollView {
                isFillViewport = true
                verticalLayout {
                    orientation = LinearLayout.VERTICAL
                    imageView(R.drawable.icon_gift).lparams {
                        topMargin = dip(30)
                        gravity = Gravity.CENTER_HORIZONTAL
                    }
                    textView(R.string.demo_content) {
                        id = R.id.demo_content
                        horizontalPadding = dip(20)
                        topPadding = dip(20)
                        gravity = Gravity.CENTER_HORIZONTAL
                        textColorResource = R.color.gray_666666
                        textSize = 20f
                    }
                    editText {
                        id = R.id.demo_edit_phone
                        padding = dip(10)
                        backgroundResource = R.drawable.bg_edit
                        hintResource = R.string.demo_phone_hint
                        inputType = InputType.TYPE_CLASS_PHONE
                        textColorResource = R.color.black_333333
                        hintTextColor = R.color.gray_666666
                        textSize = 16f
                    }.lparams(matchParent, wrapContent) {
                        margin = dip(20)
                    }
                    button(R.string.demo_btn) {
                        id = R.id.demo_btn
                        backgroundResource = R.drawable.bg_btn
                        gravity = Gravity.CENTER
                        textColorResource = R.color.white
                        textSize = 16f
                    }.lparams(matchParent, wrapContent) {
                        horizontalMargin = dip(20)
                        topMargin = dip(10)
                    }
                    relativeLayout {
                        id = R.id.demo_result_layout
                        backgroundResource = R.drawable.bg_gift
                        visibility = View.GONE
                        textView(R.string.demo_gift_money) {
                            id = R.id.demo_gift_money
                            textColorResource = R.color.pink_btn_normal
                            textSize = 20f
                        }.lparams {
                            centerVertically()
                            leftMargin = dip(25)
                        }
                        verticalLayout {
                            orientation = LinearLayout.VERTICAL
                            textView(R.string.demo_gift) {
                                textColorResource = R.color.black_333333
                                textSize = 16f
                            }
                            textView(R.string.demo_gift_time) {
                                topPadding = dip(3)
                                textColor = R.color.gray_666666
                                textSize = 14f
                            }
                        }.lparams {
                            centerVertically()
                            leftMargin = dip(35)
                            rightOf(R.id.demo_gift_money)
                        }
                    }.lparams(matchParent, wrapContent) {
                        horizontalMargin = dip(20)
                        topMargin = dip(30)
                    }
                }.lparams(matchParent, wrapContent)
            }.lparams(matchParent, matchParent)
        }
    }
}