package com.example.nm.kotlin

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.elconfidencial.bubbleshowcase.BubbleShowCaseBuilder
import com.elconfidencial.bubbleshowcase.BubbleShowCaseSequence
import com.example.nm.Others.Information
import com.example.nm.Others.VideoInfor
import com.example.nm.R
import kotlinx.android.synthetic.main.activity_select_image.*
import kotlinx.android.synthetic.main.options_popup.view.*
import java.io.IOException

class SelectImage : AppCompatActivity() {

    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap

    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private var mInputSize = 224
    private var mModelPath = "plant_disease_model.tflite"
    private var mLabelPath = "plant_labels.txt"
    private var mSamplePath = "soybean.JPG"
    private var scanResult : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_image)


                val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        setSupportActionBar(toolbar)

        //pass the string to the next intent
        if(intent.getStringExtra("imageSelect") != null)
        {
            var type = intent.getStringExtra("imageSelect")

//......................................................................................
            //select the tensorflow lite model to load

             if(type.equals("Tomato"))
            {
                mInputSize = 224
                mModelPath = "plant_tomato_disease_model.tflite"
                mLabelPath = "plant_tomato_labels.txt"
                mSamplePath = "tom.jpg"
//                Toast.makeText(this,"tomataaao",Toast.LENGTH_LONG).show()
            }else if(type.equals("Corn maize"))
            {
                mInputSize = 224
                mModelPath = "plant_corn_disease_model.tflite"
                mLabelPath = "plant_corn_labels.txt"
                mSamplePath = "corn.jpg"
//                Toast.makeText(this,"corn",Toast.LENGTH_LONG).show()
            }else if(type.equals("Potato"))
            {
                mInputSize = 224
                mModelPath = "plant_potato_disease_model.tflite"
                mLabelPath = "plant_potato_labels.txt"
                mSamplePath = "potato.jpg"
//                Toast.makeText(this,"potato",Toast.LENGTH_LONG).show()
            }
        }



        //........................................................................................
        //screen orientation to stick to vertical
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_select_image)
//........................................................................................

        //initialize the classifier with its parameters
        mClassifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)
//        Toast.makeText(this,mModelPath.toString(),Toast.LENGTH_LONG).show()

        resources.assets.open(mSamplePath).use {
            mBitmap = BitmapFactory.decodeStream(it)
            mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
            mPhotoImageView.setImageBitmap(mBitmap)
        }
//........................................................................................

//........................................................................................

        //initialize buttons
        help_btn.setOnClickListener {
//            Toast.makeText(this,"nicholas",Toast.LENGTH_LONG).show()
            showcaseView()
        }

        mCameraButton.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(callCameraIntent, mCameraRequestCode)
        }

        mDetectButton.setOnClickListener {
            val results = mClassifier.recognizeImage(mBitmap).firstOrNull()
            //mResultTextView.text= results?.title+"\n Confidence:"+results?.confidence
            mResultTextView.text= results?.title
            mResultConfigence.text = "Confidence: " + "%.0f".format(results?.confidence!! * 100.0)+"%"
            scanResult = ""+results?.title

        }
        mPhotoImageView.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode)
        }
//........................................................................................
        mResultTextView.setOnClickListener {
            //show dialog
            val dialog = LayoutInflater.from(this).inflate(R.layout.options_popup, null)
            //Alertdialog builder
            val mBuilder = AlertDialog.Builder(this)
                    .setView(dialog)
                    .setTitle("Options")

            //show dialog
            val mAleartDialog = mBuilder.show()

            //options_popup buttons
            dialog.watchVideo.setOnClickListener {

                val videointent = Intent(this, VideoInfor::class.java)
                startActivity(videointent)


            }
            dialog.readAbout.setOnClickListener {

                val InforIntent = Intent(this, Information::class.java)
                startActivity(InforIntent)




            }


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == mCameraRequestCode){
            //Considering the case of the canceled camera
            if(resultCode == Activity.RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap = scaleImage(mBitmap)
                val toast = Toast.makeText(this, ("Image crop to: w= ${mBitmap.width} h= ${mBitmap.height}"), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.BOTTOM, 0, 20)
                toast.show()
                mPhotoImageView.setImageBitmap(mBitmap)
                mResultTextView.text= "Result"
            } else {
                Toast.makeText(this, "Camera cancel..", Toast.LENGTH_LONG).show()
            }
        } else if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Success!!!")
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)

            }
        } else {
            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }

    //function to scale the image
    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / orignalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }

//..........................................................................................................

    fun showcaseView()
    {
        BubbleShowCaseSequence()
                .addShowCase(
                        BubbleShowCaseBuilder(this)
                                .title("Detection results")
                                .description("Click here after detection result is show to either watch a video about the disease or read about it.")
                                .targetView(findViewById(R.id.detection_layout_result))
                )

                .addShowCase(
                        BubbleShowCaseBuilder(this)
                                .title("Pick an image from gallery")
                                .description("Click here to pick an image from your image gallery to be detected ")
                                .targetView(findViewById(R.id.mPhotoImageView)) )


                .addShowCase( BubbleShowCaseBuilder(this)
                        .title("Open camera")
                        .description("Click here to take a picture of the leaf plant you want to be detected.")
                        .targetView(findViewById(R.id.mCameraButton)) )

                .addShowCase( BubbleShowCaseBuilder(this)
                        .title("Detect disease")
                        .description("Click here to detect the type of disease on the image you have picked")
                        .targetView(findViewById(R.id.mDetectButton)) )
                .show()
    }

}
