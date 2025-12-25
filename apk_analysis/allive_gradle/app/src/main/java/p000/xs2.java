package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class xs2 {
    @DoNotInline
    /* renamed from: a */
    public static int m8184a(TextView textView) {
        return textView.getBreakStrategy();
    }

    @DoNotInline
    /* renamed from: b */
    public static ColorStateList m8185b(TextView textView) {
        return textView.getCompoundDrawableTintList();
    }

    @DoNotInline
    /* renamed from: c */
    public static PorterDuff.Mode m8186c(TextView textView) {
        return textView.getCompoundDrawableTintMode();
    }

    @DoNotInline
    /* renamed from: d */
    public static int m8187d(TextView textView) {
        return textView.getHyphenationFrequency();
    }

    @DoNotInline
    /* renamed from: e */
    public static void m8188e(TextView textView, int i) {
        textView.setBreakStrategy(i);
    }

    @DoNotInline
    /* renamed from: f */
    public static void m8189f(TextView textView, ColorStateList colorStateList) {
        textView.setCompoundDrawableTintList(colorStateList);
    }

    @DoNotInline
    /* renamed from: g */
    public static void m8190g(TextView textView, PorterDuff.Mode mode) {
        textView.setCompoundDrawableTintMode(mode);
    }

    @DoNotInline
    /* renamed from: h */
    public static void m8191h(TextView textView, int i) {
        textView.setHyphenationFrequency(i);
    }
}
