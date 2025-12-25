package p000;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* renamed from: ia */
/* loaded from: classes.dex */
public abstract class AbstractC1299ia {
    @NonNull
    @DoNotInline
    /* renamed from: a */
    public static StaticLayout m5203a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i, int i2, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull AbstractC1504la abstractC1504la) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            abstractC1504la.mo5423a(obtain, textView);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }
}
