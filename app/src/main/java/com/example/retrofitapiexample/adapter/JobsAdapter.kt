package com.example.retrofitapiexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapiexample.R
import com.example.retrofitapiexample.model.JobsFinderModel

class JobsAdapter(private val jobsList: List<JobsFinderModel>) :
    RecyclerView.Adapter<JobsAdapter.JobsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.jobs_rv, parent, false)
        return JobsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jobsList.size
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.bind(jobsList[position])
    }


    class JobsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(jobsFinderModel: JobsFinderModel) {
            designationTxt.text = jobsFinderModel.title
            companyNameTxt.text = jobsFinderModel.company
            jobTypeTxt.text = jobsFinderModel.type
            companyLocationTxt.text = jobsFinderModel.location
            datePostedTxt.text = jobsFinderModel.createdAt
            companyUrlTxt.text = jobsFinderModel.companyUrl
            howToApplyTxt.text = jobsFinderModel.howToApply
            Glide.with(imageCompanyLogo).load(jobsFinderModel.companyLogo).into(imageCompanyLogo)

        }

        private var designationTxt: TextView = itemView.findViewById(R.id.designation)
        private var companyNameTxt: TextView = itemView.findViewById(R.id.companyName)
        private var jobTypeTxt: TextView = itemView.findViewById(R.id.jobType)
        private var companyLocationTxt: TextView = itemView.findViewById(R.id.companyLocation)
        private var datePostedTxt: TextView = itemView.findViewById(R.id.datePosted)
        private var companyUrlTxt: TextView = itemView.findViewById(R.id.companyUrl)
        private var howToApplyTxt: TextView = itemView.findViewById(R.id.howToApply)
        private var imageCompanyLogo: ImageView = itemView.findViewById(R.id.imageCompanyLogo)

    }
}