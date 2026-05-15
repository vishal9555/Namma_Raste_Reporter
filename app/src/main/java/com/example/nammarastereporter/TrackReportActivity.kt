package com.example.nammarastereporter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class TrackReportActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_report)

        firestore = FirebaseFirestore.getInstance()

        val etTicketId = findViewById<EditText>(R.id.etTicketId)
        val btnTrack = findViewById<Button>(R.id.btnTrack)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnTrack.setOnClickListener {

            val ticketId = etTicketId.text.toString().trim()

            if (ticketId.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter Ticket ID",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            firestore.collection("reports")
                .whereEqualTo("ticketId", ticketId)
                .get()

                .addOnSuccessListener { documents ->

                    if (!documents.isEmpty) {

                        val document = documents.documents[0]

                        val issue =
                            document.getString("issue")

                        val status =
                            document.getString("status")

                        tvResult.text =
                            "Issue: $issue\n\nStatus: $status"

                    } else {

                        tvResult.text =
                            "No Report Found"
                    }
                }

                .addOnFailureListener {

                    tvResult.text =
                        "Error Fetching Report"
                }
        }
    }
}