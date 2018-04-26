package com.baidu.ardemo.ar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.baidu.ar.ARFragment
import com.baidu.ar.bean.DuMixARConfig
import com.baidu.ar.constants.ARConfigKey
import com.baidu.ar.external.ARCallbackClient
import com.baidu.ar.util.Res
import com.baidu.ardemo.R
import com.baidu.ardemo.data.API_KEY
import com.baidu.ardemo.data.APP_ID
import com.baidu.ardemo.data.OPEN_ACTION
import com.baidu.ardemo.result.ResultActivity
import org.jetbrains.anko.setContentView
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by lei.xiang on 2018/4/02.
 * AR页面
 */
class ARActivity : FragmentActivity(), ARCallbackClient {

    private lateinit var mARFragment: ARFragment

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Res.addResource(this)
        // 设置App Id
        DuMixARConfig.setAppId(APP_ID)
        // 设置API Key
        DuMixARConfig.setAPIKey(API_KEY)

        ARView().setContentView(this)

        // 准备调起AR的必要参数
        // AR_KEY:AR内容平台里申请的每个case的key
        // AR_TYPE:AR类型，目前0代表2D跟踪类型，5代表SLAM类型，后续会开放更多类型
        val arKey = intent.getStringExtra(ARConfigKey.AR_KEY)
        val arType = intent.getIntExtra(ARConfigKey.AR_TYPE, 0)
        val data = Bundle()
        val jsonObj = JSONObject()
        try {
            jsonObj.put(ARConfigKey.AR_KEY, arKey)
            jsonObj.put(ARConfigKey.AR_TYPE, arType)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        data.putString(ARConfigKey.AR_VALUE, jsonObj.toString())
        data.putInt(ARConfigKey.AR_ENTRANCE_TYPE, arType)
        initView(data)
    }

    private fun initView(data: Bundle) {
        mARFragment = ARFragment()
        mARFragment.arguments = data
        mARFragment.setARCallbackClient(this@ARActivity)
        // 将trackArFragment设置到布局上
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ar_layout, mARFragment)
        fragmentTransaction.commit()
    }

    override fun share(title: String?, content: String?, shareUrl: String?, iconUrl: String?, type: Int) {
        // type = 1 视频，type = 2 图片
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareUrl)
        shareIntent.putExtra(Intent.EXTRA_TITLE, title)
        shareIntent.type = "text/plain"
        // 设置分享列表的标题，并且每次都显示分享列表
        startActivity(Intent.createChooser(shareIntent, "分享到"))
    }

    /**
     * 透传url接口：当AR Case中需要传出url时通过该接口传出url
     */
    override fun openUrl(url: String?) {
        when (url) {
            OPEN_ACTION -> {
                startActivity(Intent(this, ResultActivity::class.java))
            }
            else -> {
                val intent = Intent()
                intent.action = "android.intent.action.VIEW"
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }
        finish()
    }

    /**
     * AR黑名单回调接口：当手机不支持AR时，通过该接口传入退化H5页面的url
     */
    override fun nonsupport(url: String?) {
        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
        intent.data = Uri.parse(url)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        if (!mARFragment.onFragmentBackPressed()) {
            super.onBackPressed()
        }
    }

}