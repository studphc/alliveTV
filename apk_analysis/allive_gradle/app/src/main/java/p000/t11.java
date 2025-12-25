package p000;

import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class t11 {
    @DoNotInline
    /* renamed from: a */
    public static int m7433a(Object obj) {
        return ((Icon) obj).getResId();
    }

    @DoNotInline
    /* renamed from: b */
    public static String m7434b(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    @DoNotInline
    /* renamed from: c */
    public static int m7435c(Object obj) {
        return ((Icon) obj).getType();
    }

    @DoNotInline
    /* renamed from: d */
    public static Uri m7436d(Object obj) {
        return ((Icon) obj).getUri();
    }
}
