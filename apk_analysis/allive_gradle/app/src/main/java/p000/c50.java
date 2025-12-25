package p000;

import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c50 {
    @DoNotInline
    /* renamed from: a */
    public static DisplayCutout m2198a(Rect rect, List<Rect> list) {
        return new DisplayCutout(rect, list);
    }

    @DoNotInline
    /* renamed from: b */
    public static List<Rect> m2199b(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    @DoNotInline
    /* renamed from: c */
    public static int m2200c(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    @DoNotInline
    /* renamed from: d */
    public static int m2201d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    @DoNotInline
    /* renamed from: e */
    public static int m2202e(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    @DoNotInline
    /* renamed from: f */
    public static int m2203f(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}
