package com.baidu.ardemo.view

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.baidu.ardemo.BaseActivity
import com.baidu.ardemo.R
import com.baidu.ardemo.data.Constants
import java.util.regex.Pattern

/**
 * Created by lei.xiang on 2018/4/08.
 * 领取福利页面
 */
class ResultActivity : BaseActivity(), View.OnClickListener {

    private var mContent: TextView? = null
    private var mEditPhone: EditText? = null
    private var mBtn: Button? = null
    private var mLayoutResult: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo, true)
        setTitleTxt(R.string.demo_title)
        initView()
    }

    private fun initView() {
        mContent = findViewById(R.id.demo_content)
        mEditPhone = findViewById(R.id.demo_edit_phone)
        mLayoutResult = findViewById(R.id.demo_result_layout)
        mBtn = findViewById(R.id.demo_btn)
        mBtn!!.setOnClickListener(this@ResultActivity)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.demo_btn -> {
                //验证手机号，领取福利
                val phone = mEditPhone!!.text
                if (TextUtils.isEmpty(phone) || !isMobileNO(phone)) {
                    Toast.makeText(this@ResultActivity,
                            R.string.demo_phone_error, Toast.LENGTH_SHORT).show()
                    return
                }
                hideKeyBroadView(mEditPhone)
                //隐藏输入框、按钮，显示领取结果
                mEditPhone!!.visibility = View.GONE
                mBtn!!.visibility = View.GONE
                mLayoutResult!!.visibility = View.VISIBLE
                mContent!!.setText(R.string.demo_content_gift)
            }
        }
    }

    private fun isMobileNO(input: CharSequence): Boolean = Pattern.matches(Constants.REGEX_PHONE, input)

    private fun hideKeyBroadView(focusView: View?) {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(focusView!!.windowToken, 0)
    }

}
