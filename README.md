# Screenshot

![Example Image](https://raw.github.com/thanhniencung/LuckyWheel/master/device-2016-11-05-214303.png)

# Usage

Include LuckyWheel widget in your layout:

```xml
<rubikstudio.library.LuckyWheelView
    android:layout_centerInParent="true"
    app:lkwBackgroundColor="#FF9800"
    app:lkwTextColor="#263238"
    app:lkwCenterImage="@drawable/wheel2"
    app:lkwCursor="@drawable/ic_cursor"
    android:id="@+id/luckyWheel"
    android:layout_width="300dp"
    android:layout_height="300dp" />
```

And in your code :

```java
LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);
List<LuckyItem> data = new ArrayList<>();
for (int i=0; i<12; i++) {
    LuckyItem luckyItem = new LuckyItem();
    luckyItem1.text = "Item " + i;
    luckyItem1.icon = R.drawable.test;
    luckyItem1.color = 0xffFFF3E0;
    data.add(luckyItem);
}

luckyWheelView.setData(data);
luckyWheelView.setRound(10);

// start
luckyWheelView.startLuckyWheelWithTargetIndex(index);

// listener after finish lucky wheel
luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
    @Override
    public void LuckyRoundItemSelected(int index) {
        // do something with index
    }
});
```


#Custom LuckyWheel

You can setting these properties of the lucky wheel view with xml :
```xml
    app:lkwBackgroundColor="#FF9800"
    app:lkwTextColor="#263238"
    app:lkwCenterImage="@drawable/wheel2"
    app:lkwCursor="@drawable/ic_cursor"
```

Or with code like:
```java
    luckyWheelView.setLuckyWheelBackgrouldColor(0xff0000ff);
    luckyWheelView.setLuckyWheelTextColor(0xffcc0000);
    luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.icon));
    luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);
```

#Sample
Check out the [sample application](https://github.com/thanhniencung/LuckyWheel/blob/master/app/src/main/java/com/ryan/luckywheel/MainActivity.java) to see it in action!

# Contributing
Contributions welcome via Github pull requests.




