package com.kbyai.facerecognition

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.google.firebase.database.FirebaseDatabase
import java.util.logging.Handler


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val identifiedFace = intent.getParcelableExtra("identified_face") as? Bitmap
        val enrolledFace = intent.getParcelableExtra("enrolled_face") as? Bitmap
        val identifiedName = intent.getStringExtra("identified_name")
        val similarity = intent.getFloatExtra("similarity", 0f)
        val livenessScore = intent.getFloatExtra("liveness", 0f)
        val yaw = intent.getFloatExtra("yaw", 0f)
        val roll = intent.getFloatExtra("roll", 0f)
        val pitch = intent.getFloatExtra("pitch", 0f)

        // Update the TextView to show the identified name
        findViewById<TextView>(R.id.textPerson).text = "Identified: $identifiedName"

        // Check if the identified name is "Person14175"
        if (identifiedName == "Person14175") {
            // If it is, update the Firebase Realtime Database
            FirebaseDatabase.getInstance().reference
                .child("currentUser")
                .setValue("7BFoDyn7U1TOtM4xs7CBf3P47zC3")
                .addOnSuccessListener {
                    Log.d("ResultActivity", "Value updated successfully")
                    // Delay the redirection using Handler
                    android.os.Handler().postDelayed({
                        // Redirect user back to MainActivity.kt
                        val intent = Intent(this, CameraActivity::class.java)
                        startActivity(intent)
                        finish() // Close this activity
                        FirebaseDatabase.getInstance().reference
                            .child("currentUser")
                            .setValue("0")
                    }, 20000) // 20 seconds delay
                }
                .addOnFailureListener {
                    Log.e("ResultActivity", "Failed to update value: $it")
                }
        }
        else if (identifiedName == "Person11810") {
            // If it is, update the Firebase Realtime Database
            FirebaseDatabase.getInstance().reference
                .child("currentUser")
                .setValue("FhA4FOkTtjefEnhFuihlFQawJYR2")
                .addOnSuccessListener {
                    Log.d("ResultActivity", "Value updated successfully")
                    // Delay the redirection using Handler
                    android.os.Handler().postDelayed({
                        // Redirect user back to MainActivity.kt
                        val intent = Intent(this, CameraActivity::class.java)
                        startActivity(intent)
                        finish() // Close this activity
                        FirebaseDatabase.getInstance().reference
                            .child("currentUser")
                            .setValue("0")
                    }, 20000) // 20 seconds delay
                }
                .addOnFailureListener {
                    Log.e("ResultActivity", "Failed to update value: $it")
                }
        }
        else if (identifiedName == "Person13202") {
            // If it is, update the Firebase Realtime Database
            FirebaseDatabase.getInstance().reference
                .child("currentUser")
                .setValue("VQvOx1DbX1YjPi3KSEYvOk3X8lC3")
                .addOnSuccessListener {
                    Log.d("ResultActivity", "Value updated successfully")
                    // Delay the redirection using Handler
                    android.os.Handler().postDelayed({
                        // Redirect user back to MainActivity.kt
                        val intent = Intent(this, CameraActivity::class.java)
                        startActivity(intent)
                        finish() // Close this activity
                        FirebaseDatabase.getInstance().reference
                            .child("currentUser")
                            .setValue("0")
                    }, 20000) // 20 seconds delay
                }
                .addOnFailureListener {
                    Log.e("ResultActivity", "Failed to update value: $it")
                }
        }
        else{
            // If it is, update the Firebase Realtime Database
            FirebaseDatabase.getInstance().reference
                .child("currentUser")
                .setValue("7BFoDyn7U1TOtM4xs7CBf3P47zC3")
                .addOnSuccessListener {
                    Log.d("ResultActivity", "Value updated successfully")
                    // Delay the redirection using Handler
                    android.os.Handler().postDelayed({
                        // Redirect user back to MainActivity.kt
                        val intent = Intent(this, CameraActivity::class.java)
                        startActivity(intent)
                        finish() // Close this activity
                        FirebaseDatabase.getInstance().reference
                            .child("currentUser")
                            .setValue("0")
                    }, 20000) // 20 seconds delay
                }
                .addOnFailureListener {
                    Log.e("ResultActivity", "Failed to update value: $it")
                }
        }

        // Set other views with respective data
        findViewById<ImageView>(R.id.imageEnrolled).setImageBitmap(enrolledFace)
        findViewById<ImageView>(R.id.imageIdentified).setImageBitmap(identifiedFace)
        findViewById<TextView>(R.id.textSimilarity).text = "Similarity: $similarity"
        findViewById<TextView>(R.id.textLiveness).text = "Liveness score: $livenessScore"
        findViewById<TextView>(R.id.textYaw).text = "Yaw: $yaw"
        findViewById<TextView>(R.id.textRoll).text = "Roll: $roll"
        findViewById<TextView>(R.id.textPitch).text = "Pitch: $pitch"
    }
}
