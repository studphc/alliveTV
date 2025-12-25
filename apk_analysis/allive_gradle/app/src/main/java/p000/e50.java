package p000;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class e50 {
    @DoNotInline
    /* renamed from: a */
    public static DisplayCutout m4658a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
        return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
    }

    @DoNotInline
    /* renamed from: b */
    public static Insets m4659b(DisplayCutout displayCutout) {
        return displayCutout.getWaterfallInsets();
    }
}
