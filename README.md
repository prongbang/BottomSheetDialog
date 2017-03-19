# Custom Bottom Sheet Dialog Example
### Result
![screenshot gif](https://github.com/prongbang/images/blob/master/bottom-sheet-dialog.gif?raw=true)

### Add in bottom_sheet_layout.xml ([see more...](https://github.com/prongbang/BottomSheetDialog/blob/master/app/src/main/res/layout/bottom_sheet_layout.xml))
---
> app:layout_behavior="android.support.design.widget.BottomSheetBehavior"
 
### Create Java Class extends "BottomSheetDialog" ([see more...](https://github.com/prongbang/BottomSheetDialog/blob/master/app/src/main/java/com/prongbang/bottomsheetdialog/widget/MyBottomSheetDialog.java))

```java
public class MyBottomSheetDialog extends BottomSheetDialog implements View.OnClickListener {

    ...

    public MyBottomSheetDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        create();
    }

    public void create() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        setContentView(bottomSheetView);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // do something
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // do something
            }
        };

        ivAvatar = (ImageView) bottomSheetView.findViewById(R.id.ivAvatar);
        ivClose = (ImageView) bottomSheetView.findViewById(R.id.ivClose);
        tvTitle = (TextView) bottomSheetView.findViewById(R.id.tvTitle);
        tvSubTitle = (TextView) bottomSheetView.findViewById(R.id.tvSubTitle);

        ivAvatar.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        tvTitle.setOnClickListener(this);

    }
  
    ...
}
```

### Use in Activity ([see more...](https://github.com/prongbang/BottomSheetDialog/tree/master/app/src/main/java/com/prongbang/bottomsheetdialog/activities))
```java
  MyBottomSheetDialog myBottomSheetDialog = MyBottomSheetDialog.getInstance(this);
  myBottomSheetDialog.setTvTitle("Bottom Sheet Dialog");
  myBottomSheetDialog.setTvSubTitle("Read more...");
  myBottomSheetDialog.setIvAvatar("https://avatars3.githubusercontent.com/u/6635954?v=3&u=d18aab686938ecda4b96f29e4e3b776008ced91f&s=400");
  myBottomSheetDialog.setCanceledOnTouchOutside(false);
  myBottomSheetDialog.show();
```

### Enjoy :V
