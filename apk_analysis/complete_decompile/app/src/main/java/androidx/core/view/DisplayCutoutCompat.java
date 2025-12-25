package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.c50;
import p000.d50;
import p000.e50;

/* loaded from: classes.dex */
public final class DisplayCutoutCompat {

    /* renamed from: a */
    public final DisplayCutout f3872a;

    public DisplayCutoutCompat(@Nullable Rect rect, @Nullable List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? c50.m2198a(rect, list) : null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DisplayCutoutCompat.class == obj.getClass()) {
            return ObjectsCompat.equals(this.f3872a, ((DisplayCutoutCompat) obj).f3872a);
        }
        return false;
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c50.m2199b(this.f3872a);
        }
        return Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c50.m2200c(this.f3872a);
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c50.m2201d(this.f3872a);
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c50.m2202e(this.f3872a);
        }
        return 0;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c50.m2203f(this.f3872a);
        }
        return 0;
    }

    @NonNull
    public Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Insets.toCompatInsets(e50.m4659b(this.f3872a));
        }
        return Insets.NONE;
    }

    public int hashCode() {
        int hashCode;
        DisplayCutout displayCutout = this.f3872a;
        if (displayCutout != null) {
            hashCode = displayCutout.hashCode();
            return hashCode;
        }
        return 0;
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.f3872a + "}";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DisplayCutoutCompat(@NonNull Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull Insets insets2) {
        this(r9);
        DisplayCutout displayCutout;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            displayCutout = e50.m4658a(insets.toPlatformInsets(), rect, rect2, rect3, rect4, insets2.toPlatformInsets());
        } else if (i >= 29) {
            displayCutout = d50.m4525a(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
        } else if (i >= 28) {
            Rect rect5 = new Rect(insets.left, insets.top, insets.right, insets.bottom);
            ArrayList arrayList = new ArrayList();
            if (rect != null) {
                arrayList.add(rect);
            }
            if (rect2 != null) {
                arrayList.add(rect2);
            }
            if (rect3 != null) {
                arrayList.add(rect3);
            }
            if (rect4 != null) {
                arrayList.add(rect4);
            }
            displayCutout = c50.m2198a(rect5, arrayList);
        } else {
            displayCutout = null;
        }
    }

    public DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.f3872a = displayCutout;
    }
}
