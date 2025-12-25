package p000;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;

/* loaded from: classes.dex */
public abstract class ot0 {
    /* renamed from: a */
    public static int m6727a(int i, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }
}
