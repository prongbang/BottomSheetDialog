package com.prongbang.sbs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class SmartBottomSheetDialogFragment(
		private val supportFragmentManager: FragmentManager
) : BottomSheetDialogFragment() {

	abstract fun tagName(): String

	override fun show(manager: FragmentManager, tag: String?) {
		try {
			manager.beginTransaction()
					.remove(this)
					.commit()
			super.show(manager, tag)
		} catch (e: Exception) {
			Log.e(tagName(), "${e.message}")
		}
	}

	fun show() {
		show(supportFragmentManager, tagName())
	}

	abstract class Builder<T> {
		open val argumentsBundle = Bundle()
		abstract fun build(): T
	}
}