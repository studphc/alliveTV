package p000;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class at2 {
    @DoNotInline
    /* renamed from: b */
    public static String[] m1964b(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    @DoNotInline
    /* renamed from: c */
    public static PrecomputedText.Params m1965c(TextView textView) {
        return textView.getTextMetricsParams();
    }

    @DoNotInline
    /* renamed from: d */
    public static void m1966d(TextView textView, int i) {
        textView.setFirstBaselineToTopHeight(i);
    }

    @DoNotInline
    /* renamed from: a */
    public static CharSequence m1963a(PrecomputedText precomputedText) {
        return precomputedText;
    }
}
