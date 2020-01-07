package com.example.retrofitapiexample.view

import android.app.ProgressDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapiexample.R
import com.example.retrofitapiexample.adapter.JobsAdapter
import com.example.retrofitapiexample.base.BaseActivity
import com.example.retrofitapiexample.model.JobsFinderModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_jobs_finder.*

class JobsFinderActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    JobFinderView {
     var pDialogJob: ProgressDialog? = null

    lateinit var jobsAdapter: JobsAdapter
    override fun showMessage(message: String) {
        showSnackBar(message)
    }

    override fun showList(body: List<JobsFinderModel>) {
        rv.layoutManager = LinearLayoutManager(this)
        jobsAdapter = JobsAdapter(body)
        rv.adapter=jobsAdapter
        jobsAdapter.notifyDataSetChanged()
        pDialogJob?.dismiss()
    }

    var jobsPresenter: JobsPresenter = JobsPresenter(this)


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return true
    }

    override fun setLayout(): Int {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        return R.layout.activity_jobs_finder
    }

    override fun initView(savedInstanceState: Bundle?) {
        pDialogJob = ProgressDialog(this@JobsFinderActivity)
        pDialogJob!!.setMessage("Getting Data...")
        pDialogJob!!.setIndeterminate(false)
        pDialogJob!!.setCancelable(true)
        pDialogJob!!.show()
        jobsPresenter.callApi()

    }
}