package p000;

import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* renamed from: ca */
/* loaded from: classes.dex */
public abstract class AbstractC0586ca {
    @DoNotInline
    /* renamed from: a */
    public static int m2212a(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m2213b(TextView textView, int i, int i2, int i3, int i4) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m2214c(TextView textView, int[] iArr, int i) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m2215d(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
