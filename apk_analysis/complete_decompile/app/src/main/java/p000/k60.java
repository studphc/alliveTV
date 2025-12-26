package p000;

import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class k60 {
    @DoNotInline
    /* renamed from: a */
    public static int m5501a(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m5502b(Drawable drawable, int i) {
        return drawable.setLayoutDirection(i);
    }
}
