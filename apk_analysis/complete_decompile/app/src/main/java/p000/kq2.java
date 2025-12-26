package p000;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public abstract class kq2 {
    /* renamed from: a */
    public static void m5763a(Cue.Builder builder) {
        boolean z;
        builder.setTextSize(-3.4028235E38f, Integer.MIN_VALUE);
        if (builder.getText() instanceof Spanned) {
            if (!(builder.getText() instanceof Spannable)) {
                builder.setText(SpannableString.valueOf(builder.getText()));
            }
            Spannable spannable = (Spannable) Assertions.checkNotNull(builder.getText());
            for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                if (!(obj instanceof AbsoluteSizeSpan) && !(obj instanceof RelativeSizeSpan)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    spannable.removeSpan(obj);
                }
            }
        }
    }

    /* renamed from: b */
    public static float m5764b(int i, int i2, int i3, float f) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        } else {
            f2 = i3;
        }
        return f * f2;
    }
}
