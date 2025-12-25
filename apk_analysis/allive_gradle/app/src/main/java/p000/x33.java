package p000;

import android.view.ViewStructure;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class x33 {
    @DoNotInline
    /* renamed from: a */
    public static void m8094a(ViewStructure viewStructure, String str) {
        viewStructure.setClassName(str);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m8095b(ViewStructure viewStructure, CharSequence charSequence) {
        viewStructure.setContentDescription(charSequence);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m8096c(ViewStructure viewStructure, int i, int i2, int i3, int i4, int i5, int i6) {
        viewStructure.setDimens(i, i2, i3, i4, i5, i6);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m8097d(ViewStructure viewStructure, CharSequence charSequence) {
        viewStructure.setText(charSequence);
    }
}
