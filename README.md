

### **PageIndicatorView**

`PageIndicatorView` is light library to indicate ViewPager's selected page with different animations and ability to customise it as you need.

![](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/preview_anim_drop.gif)

### **Integration**
To add `pageindicatorview` to your project, first make sure in root `build.gradle` you have specified the following repository:
```dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
>***Note***
No need `jcenter` repository in your project.
 
See latest library version [ ![Download](https://api.bintray.com/packages/romandanylyk/maven/pageindicatorview/images/download.svg) ](https://github.com/Foysalofficial/PageIndicatorView/releases)
```Old groovy
implementation 'com.github.Foysalofficial:PageIndicatorView:16.0'
```

```Update Android Studio groovy
implementation ("com.github.Foysalofficial:PageIndicatorView:16.0")
```

Keep in mind, that `PageIndicatorView` has min [API level 18](https://developer.android.com/about/dashboards/index.html) and these dependencies:

### **Usage Sample**
Usage of `PageIndicatorView` is quite simple. All you need to do is to declare a view in your `layout.xml`  and call `setSelection` method to select specific indicator - that's it!

```java
PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(5); // specify total count of indicators
        pageIndicatorView.setSelection(2);
```


But if you're as lazy as I'm - then there is another option to handle `PageIndicatorView` 

```xml
     <com.ft.PageIndicatorView
        android:id="@+id/pageIndicatorView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        app:piv_animationType="scale"
        app:piv_dynamicCount="true"
        app:piv_interactiveAnimation="true"
        app:piv_selectedColor="@color/gray_50"
        app:piv_unselectedColor="@color/gray_300"
        app:piv_viewPager="@id/viewPager"
        attrs:piv_padding="12dp"
        attrs:piv_radius="8dp" />
```
All the `piv_` attributes here are specific for `PageIndicatorView` so you can customise it as you want with attributes - pretty handy. 

But what is more important here is  `app:piv_viewPager="@id/viewPager"`.
What it actually do is catch up your `ViewPager` and automatically handles all the event's to selected the right page - so you don't need to call `setSelection` method on your own.

Another handy options here that works with your `ViewPager` as a whole is 
`app:piv_dynamicCount="true"` and ` app:piv_interactiveAnimation="true"` 

Dynamic count will automatically updates `PageIndicatorView` total count as you updates pages count in your `ViewPager` - so that's pretty useful.

While interactive animation will progress the animation process within your swipe position, which makes animation more natural and responsive to end user.


> ***Note***:  Because `setViewPagerId` uses an instance of `ViewPager`, using it in recycler could lead to id conflicts, so `PageIndicatorView`
>  will not know properly what is the right `ViewPager` to work with. Instead you should handle selected indicators on your own programatically.


```java
  pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {/*empty*/}

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {/*empty*/}
        });
```


Here you can see all the animations `PageIndicatorView` support.

Name| Support version| Preview
-------- | --- | ---
`AnimationType.NONE`| 0.0.1 | ![anim_none](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_none.gif)
`AnimationType.COLOR`| 0.0.1 |![anim_color](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_color.gif)
`AnimationType.SCALE`| 0.0.1 |![anim_scale](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_scale.gif)
`AnimationType.SLIDE`| 0.0.1 |![anim_slide](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_slide.gif)
`AnimationType.WORM`| 0.0.1 |![anim_worm](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_worm.gif)
`AnimationType.FILL`| 0.0.6 |![anim_worm](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_fill.gif)
`AnimationType.THIN_WORM`| 0.0.7 |![anim_thin_worm](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_thin_worm.gif)
`AnimationType.DROP`| 0.1.0 |![anim_drop](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_drop.gif)
`AnimationType.SWAP`| 0.1.1 |![anim_swap](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_swap.gif)


### **Release Note**
See release notes on [github releases](https://github.com/Foysalofficial/PageIndicatorView/releases)

### **License**

    Copyright 2024 by Foysal Tech yt
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

