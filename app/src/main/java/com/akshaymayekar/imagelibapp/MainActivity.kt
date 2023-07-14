package com.akshaymayekar.imagelibapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.akshaymayekar.newImagelibrary.ImageLib
import com.akshaymayekar.newImagelibrary.OnImageLoadListener
import com.akshaymayekar.newImagelibrary.OnMultipleImageLoadListener
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var imageLib: ImageLib
    private lateinit var imageView: ImageView
    private lateinit var nextImage: Button
    private lateinit var previousImage: Button
    private lateinit var btnSubmit: Button
    private lateinit var edtInput: EditText

    private lateinit var scope: CoroutineScope


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        imageLib = ImageLib()
        imageLib.init()


        scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            previousImage.isEnabled = false
            fetchNextImage()
        }
    }

    private fun loadImage(message: String) {
        scope.launch(Dispatchers.Main) {
            Glide.with(this@MainActivity).load(message).into(imageView)
        }
    }

    private fun initialize() {
        nextImage = findViewById(R.id.nextImage)
        imageView = findViewById(R.id.imageView)
        previousImage = findViewById(R.id.previousImage)
        imageView = findViewById(R.id.imageView)
        btnSubmit = findViewById(R.id.btnSubmit)
        edtInput = findViewById(R.id.edtInput)


        previousImage.isEnabled = false
        btnSubmit.setOnClickListener {
            var number = edtInput.text.toString().toInt()
            if (number > 10) {
                Toast.makeText(
                    this@MainActivity, "Number can be less then equal to 10.", Toast.LENGTH_SHORT
                ).show()
            } else {
                fetchNumberOfImage(number)
            }
        }
        nextImage.setOnClickListener {
            previousImage.isEnabled = true

            fetchNextImage()

        }
        previousImage.setOnClickListener {
            fetchPreviousImage()

        }
    }

    private fun fetchPreviousImage() {
        scope.launch {
            imageLib.getPreviousImage(object : OnImageLoadListener {
                override fun onSuccess(message: String) {

                    loadImage(message)
                }

                override fun onFailed(e: Exception?) {
                    Toast.makeText(
                        this@MainActivity, "Failed to load Image...", Toast.LENGTH_SHORT
                    ).show()
                }

            })
        }
    }

    private fun fetchNextImage() {
        scope.launch {
            imageLib.getNextImage(object : OnImageLoadListener {
                override fun onSuccess(message: String) {

                    loadImage(message)
                }

                override fun onFailed(e: Exception?) {
                    Toast.makeText(
                        this@MainActivity, "Failed to load Image...", Toast.LENGTH_SHORT
                    ).show()
                }

            })
        }
    }

    private fun fetchNumberOfImage(number: Int) {
        scope.launch {
            imageLib.getImages(number, object : OnMultipleImageLoadListener {
                override fun onSuccess(message: List<String>) {
                    runOnUiThread {
                        Toast.makeText(
                            this@MainActivity, message.toString(), Toast.LENGTH_SHORT
                        ).show()
                    }

                }

                override fun onFailed(e: Exception?) {
                    runOnUiThread {
                        Toast.makeText(
                            this@MainActivity, "Failed to load Image...", Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            })
        }
    }
}