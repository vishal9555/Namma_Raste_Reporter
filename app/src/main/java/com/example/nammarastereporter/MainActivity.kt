package com.example.nammarastereporter

import android.content.Intent
import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.LocationServices
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var adapter: ReportAdapter

    private val reportList = mutableListOf<Report>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firestore = FirebaseFirestore.getInstance()

        val btnCamera = findViewById<Button>(R.id.btnCamera)
        val btnLocation = findViewById<Button>(R.id.btnLocation)
        val btnReport = findViewById<Button>(R.id.btnReport)

        // STEP 5 ADDED HERE
        val btnTrackPage =
            findViewById<Button>(R.id.btnTrackPage)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imagePreview = findViewById<ImageView>(R.id.imagePreview)

        // RecyclerView Setup
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ReportAdapter(reportList)

        recyclerView.adapter = adapter

        // Load Existing Reports
        loadReports()

        // Camera Launcher
        val takePicture =
            registerForActivityResult(
                ActivityResultContracts.TakePicturePreview()
            ) { bitmap: Bitmap? ->

                if (bitmap != null) {

                    imagePreview.setImageBitmap(bitmap)

                    Toast.makeText(
                        this,
                        "Image Captured Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        // Camera Button
        btnCamera.setOnClickListener {

            takePicture.launch(null)

        }

        // Location Button
        btnLocation.setOnClickListener {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                requestPermissionLauncher.launch(
                    Manifest.permission.ACCESS_FINE_LOCATION
                )

                return@setOnClickListener
            }

            val fusedLocationClient =
                LocationServices.getFusedLocationProviderClient(this)

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->

                    if (location != null) {

                        val lat = location.latitude
                        val lng = location.longitude

                        Toast.makeText(
                            this,
                            "Latitude: $lat\nLongitude: $lng",
                            Toast.LENGTH_LONG
                        ).show()

                    } else {

                        Toast.makeText(
                            this,
                            "Location not found.\nTurn ON GPS and Internet.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

        // Submit Report Button
        btnReport.setOnClickListener {

            val ticketId =
                "NRR" + System.currentTimeMillis().toString().takeLast(6)

            val report = hashMapOf(
                "ticketId" to ticketId,
                "issue" to "Pothole",
                "status" to "Pending"
            )

            firestore.collection("reports")
                .add(report)

                .addOnSuccessListener {

                    Toast.makeText(
                        this,
                        "Report Saved Successfully\nTicket ID: $ticketId",
                        Toast.LENGTH_LONG
                    ).show()

                    // Refresh RecyclerView After Save
                    loadReports()
                }

                .addOnFailureListener {

                    Toast.makeText(
                        this,
                        "Failed to Save",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

        // STEP 5 ADDED HERE
        btnTrackPage.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    TrackReportActivity::class.java
                )
            )
        }
    }

    // Load Reports Function
    private fun loadReports() {

        firestore.collection("reports")
            .get()

            .addOnSuccessListener { documents ->

                reportList.clear()

                for (document in documents) {

                    val report =
                        document.toObject(Report::class.java)

                    reportList.add(report)
                }

                adapter.notifyDataSetChanged()
            }

            .addOnFailureListener {

                Toast.makeText(
                    this,
                    "Failed to Load Reports",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    // Permission Launcher
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->

            if (isGranted) {

                Toast.makeText(
                    this,
                    "Permission Granted",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Permission Denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}