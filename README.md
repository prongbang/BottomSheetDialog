# Custom Bottom Sheet Dialog Example

[![](https://jitpack.io/v/prongbang/BottomSheetDialog.svg)](https://jitpack.io/#prongbang/BottomSheetDialog)
[![](https://jitpack.io/v/prongbang/BottomSheetDialog/month.svg)](https://jitpack.io/#prongbang/BottomSheetDialog)

### Result
![screenshot gif](https://github.com/prongbang/images/blob/master/bottom-sheet-dialog.gif?raw=true)

## Download

> build.gradle
>
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### AndroidX

```groovy
implementation 'com.github.prongbang:bottomsheetdialog:1.0.0'
```

## How to use

> Add in bottom_sheet_layout.xml

```xml
app:layout_behavior="android.support.design.widget.BottomSheetBehavior"
```

> MyBottomSheetDialogFragment.kt

```kotlin
class MyBottomSheetDialogFragment(
		supportFragmentManager: FragmentManager
) : SmartBottomSheetDialogFragment(supportFragmentManager) {

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
			// get value by key
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
	}

	companion object {
		private const val TITLE_KEY = "TITLE_KEY"
		private const val SUBTITLE_KEY = "SUBTITLE_KEY"
		private const val AVATAR_URL_KEY = "AVATAR_URL_KEY"
	}
}
```

> Use in Activity
```kotlin
MyBottomSheetDialogFragment.Builder(supportFragmentManager)
    .setAvatar(avatarUrl)
    .setTitle("เดฟไปวันๆ")
    .setSubtitle("https://prongbang.github.io")
    .setOnCloseButton {
        Toast.makeText(this, "Bottom Sheet Dialog Closed", Toast.LENGTH_SHORT).show()
    }
    .build()
    .show()
```

### Enjoy :V
