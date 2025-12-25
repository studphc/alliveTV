package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class m62 {
    @DoNotInline
    /* renamed from: a */
    public static PointerIcon m6086a(Bitmap bitmap, float f, float f2) {
        return PointerIcon.create(bitmap, f, f2);
    }

    @DoNotInline
    /* renamed from: b */
    public static PointerIcon m6087b(Context context, int i) {
        return PointerIcon.getSystemIcon(context, i);
    }

    @DoNotInline
    /* renamed from: c */
    public static PointerIcon m6088c(Resources resources, int i) {
        return PointerIcon.load(resources, i);
    }
}
