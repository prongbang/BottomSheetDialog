package com.prongbang.bottomsheetdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.prongbang.sbs.SmartBottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

class MyBottomSheetDialogFragment(
		supportFragmentManager: FragmentManager
) : SmartBottomSheetDialogFragment(supportFragmentManager) {

	private var onClickCloseListener: (() -> Unit)? = null

	override fun tagName(): String = MyBottomSheetDialogFragment::class.java.simpleName

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
	}

	private fun initView() {
		arguments?.let { args ->
			context?.let {
				ImageUtil.loadImageFromUrl(it, args.getString(AVATAR_URL_KEY), ivAvatar)
			}
			tvTitle.text = args.getString(TITLE_KEY)
			tvSubTitle.text = args.getString(SUBTITLE_KEY)
			ivClose.setOnClickListener {
				dismiss()
				onClickCloseListener?.invoke()
			}
		}
	}

	class Builder(
			private val fragmentManager: FragmentManager
	) : SmartBottomSheetDialogFragment.Builder<MyBottomSheetDialogFragment>() {

		private var onCloseListener: (() -> Unit)? = null

		override fun build(): MyBottomSheetDialogFragment {
			return MyBottomSheetDialogFragment(fragmentManager)
					.apply {
						arguments = argumentsBundle.apply {
							onClickCloseListener = onCloseListener
						}
					}
		}

		fun setTitle(title: String): Builder {
			argumentsBundle.putString(TITLE_KEY, title)
			return this
		}

		fun setAvatar(url: String): Builder {
			argumentsBundle.putString(AVATAR_URL_KEY, url)
			return this
		}

		fun setSubtitle(subtitle: String): Builder {
			argumentsBundle.putString(SUBTITLE_KEY, subtitle)
			return this
		}

		fun setOnCloseButton(onListener: (() -> Unit)? = null): Builder {
			onCloseListener = onListener
			return this
		}
	}

	companion object {
		private const val TITLE_KEY = "TITLE_KEY"
		private const val SUBTITLE_KEY = "SUBTITLE_KEY"
		private const val AVATAR_URL_KEY = "AVATAR_URL_KEY"
	}
}