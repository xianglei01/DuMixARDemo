package com.baidu.ardemo.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewStub
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.baidu.ar.util.ARLog
import com.baidu.ardemo.ListItemBean
import com.baidu.ardemo.R
import com.baidu.ardemo.ar.ARActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import java.util.*

/**
 * Created by lei.xiang on 2018/4/02.
 * 首页，包含AR入口列表（SLAM，2D）
 */
class MainActivity : Activity(), AdapterView.OnItemClickListener {

    private lateinit var mArName: Array<String>
    private lateinit var mListView: ListView

    private val mListItemData: List<ListItemBean>
        get() {
            val list = ArrayList<ListItemBean>()
            // SLAM
            list.add(ListItemBean(5, "10082382", mArName[0]))
            // 2D识别
            list.add(ListItemBean(0, "10038237", mArName[1]))
            list.add(ListItemBean(0, "10089236", mArName[2]))
            return list
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainView().setContentView(this)
        ARLog.setDebugEnable(true)
        mArName = resources.getStringArray(R.array.ar_name)
        initView()
    }

    private fun initView() {
        mListView = find(R.id.main_list)
        mListView.addFooterView(ViewStub(this))
        mListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mArName)
        mListView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, ARActivity::class.java)
        val bundle = Bundle()
        val listItemBean = mListItemData[position]
        bundle.putString("ar_key", listItemBean.arKey)
        bundle.putInt("ar_type", listItemBean.arType)
        bundle.putString("name", listItemBean.name)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}