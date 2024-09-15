package com.ft.utils;

import android.os.Build;
import android.view.View;

import java.util.concurrent.atomic.AtomicInteger;

public class IdUtils {

    private static final AtomicInteger nextGeneratedId = new AtomicInteger(1);

    public static int generateViewId(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return generateId();
        } else {
            return View.generateViewId();
        }
    }

    private static int generateId() {
        for (; ; ) {
            final int result = nextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (nextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}
