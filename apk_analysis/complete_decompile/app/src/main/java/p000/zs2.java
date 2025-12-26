package p000;

import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class zs2 {
    @DoNotInline
    /* renamed from: a */
    public static int m8430a(TextView textView) {
        return textView.getAutoSizeMaxTextSize();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m8431b(TextView textView) {
        return textView.getAutoSizeMinTextSize();
    }

    @DoNotInline
    /* renamed from: c */
    public static int m8432c(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    @DoNotInline
    /* renamed from: d */
    public static int[] m8433d(TextView textView) {
        return textView.getAutoSizeTextAvailableSizes();
    }

    @DoNotInline
    /* renamed from: e */
    public static int m8434e(TextView textView) {
        return textView.getAutoSizeTextType();
    }

    @DoNotInline
    /* renamed from: f */
    public static void m8435f(TextView textView, int i, int i2, int i3, int i4) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    @DoNotInline
    /* renamed from: g */
    public static void m8436g(TextView textView, int[] iArr, int i) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    @DoNotInline
    /* renamed from: h */
    public static void m8437h(TextView textView, int i) {
        textView.setAutoSizeTextTypeWithDefaults(i);
    }
}
