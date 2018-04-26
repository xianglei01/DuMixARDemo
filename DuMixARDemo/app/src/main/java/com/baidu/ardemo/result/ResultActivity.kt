package com.baidu.ardemo.result

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import com.baidu.ardemo.R
import com.baidu.ardemo.data.REGEX_PHONE
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import java.util.regex.Pattern

/**
 * Created by lei.xiang on 2018/4/08.
 * 领取福利页面
 */
class ResultActivity : Activity() {

    private lateinit var mContent: TextView
    private lateinit var mEditPhone: EditText
    private lateinit var mBtn: Button
    private lateinit var mLayoutResult: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ResultView().setContentView(this)
        initView()
    }

    private fun initView() {
        mContent = find(R.id.demo_content)
        mEditPhone = find(R.id.demo_edit_phone)
        mLayoutResult = find(R.id.demo_result_layout)
        mBtn = find(R.id.demo_btn)
        initListener()
    }

    private fun initListener() {
        mBtn.onClick {
            //验证手机号，领取福利
            val phone = mEditPhone.text
            if (TextUtils.isEmpty(phone) || !isMobileNO(phone)) {
                toast(R.string.demo_phone_error)
            } else {
                hideKeyBroadView(mEditPhone)
                //隐藏输入框、按钮，显示领取结果
                mEditPhone.visibility = View.GONE
                mBtn.visibility = View.GONE
                mLayoutResult.visibility = View.VISIBLE
                mContent.setText(R.string.demo_content_gift)
            }
        }
    }

    private fun isMobileNO(input: CharSequence): Boolean = Pattern.matches(REGEX_PHONE, input)

    private fun hideKeyBroadView(focusView: View) {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(focusView.windowToken, 0)
    }

}
