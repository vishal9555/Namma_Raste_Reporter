package com.example.nammarastereporter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReportAdapter(
    private val reportList: List<Report>
) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    class ReportViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val txtTicket: TextView =
            itemView.findViewById(R.id.txtTicket)

        val txtIssue: TextView =
            itemView.findViewById(R.id.txtIssue)

        val txtStatus: TextView =
            itemView.findViewById(R.id.txtStatus)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReportViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_report, parent, false)

        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ReportViewHolder,
        position: Int
    ) {

        val report = reportList[position]

        holder.txtTicket.text =
            "Ticket ID: ${report.ticketId}"

        holder.txtIssue.text =
            "Issue: ${report.issue}"

        holder.txtStatus.text =
            "Status: ${report.status}"
    }

    override fun getItemCount(): Int {
        return reportList.size
    }
}