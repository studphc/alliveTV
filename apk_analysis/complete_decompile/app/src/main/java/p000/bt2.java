package p000;

import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class bt2 {
    @DoNotInline
    /* renamed from: a */
    public static void m2164a(@NonNull TextView textView, int i, @FloatRange(from = 0.0d) float f) {
        textView.setLineHeight(i, f);
    }
}
