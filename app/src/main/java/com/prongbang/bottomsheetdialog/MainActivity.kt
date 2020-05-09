package com.prongbang.bottomsheetdialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private val avatarUrl = "https://avatars3.githubusercontent.com/u/6635954?v=3&u=d18aab686938ecda4b96f29e4e3b776008ced91f&s=400"

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		tvClickMe.setOnClickListener {
			showBottomSheetDialog()
		}
	}

	private fun showBottomSheetDialog() {
		MyBottomSheetDialogFragment.Builder(supportFragmentManager)
				.setAvatar(avatarUrl)
				.setTitle("เดฟไปวันๆ")
				.setSubtitle("https://prongbang.github.io")
				.setOnCloseButton {
					Toast.makeText(this, "Bottom Sheet Dialog Closed", Toast.LENGTH_SHORT).show()
				}
				.build()
				.show()
	}

}