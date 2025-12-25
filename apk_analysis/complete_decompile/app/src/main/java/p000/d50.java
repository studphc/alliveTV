package p000;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d50 {
    @DoNotInline
    /* renamed from: a */
    public static DisplayCutout m4525a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
        return new DisplayCutout(insets, rect, rect2, rect3, rect4);
    }
}
