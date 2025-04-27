# BottomSheetDialog 📱

[![](https://jitpack.io/v/prongbang/BottomSheetDialog.svg)](https://jitpack.io/#prongbang/BottomSheetDialog)
[![](https://jitpack.io/v/prongbang/BottomSheetDialog/month.svg)](https://jitpack.io/#prongbang/BottomSheetDialog)
[![Android](https://img.shields.io/badge/platform-Android-green.svg)](https://developer.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![Kotlin](https://img.shields.io/badge/kotlin-1.5.x-orange.svg)](https://kotlinlang.org)

> Create beautiful and customizable bottom sheet dialogs for Android with minimal setup.

## ✨ Features

- 🎨 **Fully Customizable** - Design your own bottom sheet layout
- 🚀 **Easy Integration** - Simple builder pattern implementation
- 📱 **Material Design** - Follows Material Design guidelines
- 🔄 **Lifecycle Aware** - Properly handles configuration changes
- 🎯 **Type-Safe** - Written in Kotlin with type safety in mind

## 📸 Preview

<p align="center">
  <img src="https://github.com/prongbang/images/blob/master/bottom-sheet-dialog.gif?raw=true" alt="Bottom Sheet Dialog Demo" width="300"/>
</p>

## 📦 Installation

### Step 1: Add JitPack repository

Add it in your root `build.gradle` at the end of repositories:

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the dependency

For AndroidX:

```groovy
dependencies {
    implementation 'com.github.prongbang:bottomsheetdialog:1.0.0'
}
```

## 🚀 Quick Start

### 1. Create your bottom sheet layout

```xml
<!-- bottom_sheet_layout.xml -->
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    app:layout_behavior="@string/bottom_sheet_behavior">
    
    <!-- Your custom layout here -->
    
</LinearLayout>
```

### 2. Create your BottomSheetDialogFragment

```kotlin
class MyBottomSheetDialogFragment(
    supportFragmentManager: FragmentManager
) : SmartBottomSheetDialogFragment(supportFragmentManager) {
    
    override fun tagName(): String = MyBottomSheetDialogFragment::class.java.simpleName
    
    override fun onCreateView(
        inflater: LayoutInflater, 
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    
    private fun initView() {
        arguments?.let { args ->
            // Get values by key
            val title = args.getString(TITLE_KEY)
            val subtitle = args.getString(SUBTITLE_KEY)
            val avatarUrl = args.getString(AVATAR_URL_KEY)
            
            // Set up your views
        }
    }
    
    class Builder(
        private val fragmentManager: FragmentManager
    ) : SmartBottomSheetDialogFragment.Builder<MyBottomSheetDialogFragment>() {
        
        private var onCloseListener: (() -> Unit)? = null
        
        fun setTitle(title: String) = apply {
            argumentsBundle.putString(TITLE_KEY, title)
        }
        
        fun setSubtitle(subtitle: String) = apply {
            argumentsBundle.putString(SUBTITLE_KEY, subtitle)
        }
        
        fun setAvatar(avatarUrl: String) = apply {
            argumentsBundle.putString(AVATAR_URL_KEY, avatarUrl)
        }
        
        fun setOnCloseButton(listener: () -> Unit) = apply {
            onCloseListener = listener
        }
        
        override fun build(): MyBottomSheetDialogFragment {
            return MyBottomSheetDialogFragment(fragmentManager).apply {
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

### 3. Show the bottom sheet

```kotlin
// In your Activity or Fragment
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

## 🔧 Advanced Usage

### Custom Styling

```xml
<!-- styles.xml -->
<style name="CustomBottomSheetDialog" parent="Theme.Design.Light.BottomSheetDialog">
    <item name="bottomSheetStyle">@style/CustomBottomSheet</item>
</style>

<style name="CustomBottomSheet" parent="Widget.Design.BottomSheet.Modal">
    <item name="android:background">@drawable/custom_bottom_sheet_background</item>
</style>
```

### Handle State Changes

```kotlin
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    // Get bottom sheet behavior
    val bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
    
    // Set state change callback
    bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_EXPANDED -> {
                    // Handle expanded state
                }
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    // Handle collapsed state
                }
                BottomSheetBehavior.STATE_HIDDEN -> {
                    dismiss()
                }
            }
        }
        
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            // Handle slide offset
        }
    })
}
```

## 📝 Pro Tips

1. **Remember to add behavior** - Always add `app:layout_behavior="@string/bottom_sheet_behavior"` to your root layout
2. **Handle configuration changes** - The builder pattern helps maintain state across configuration changes
3. **Custom animations** - Override `setupDialog()` to customize enter/exit animations
4. **Peek height** - Adjust the initial visible height using `BottomSheetBehavior.setPeekHeight()`

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 💖 Support

If you find this library helpful, please consider giving it a ⭐️ and buying me a coffee!

[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/prongbang)

---
