package p000;

import android.view.View;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class hy0 {
    @DoNotInline
    /* renamed from: a */
    public static void m5139a(View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m5140b(View view, int i) {
        view.setImportantForAutofill(i);
    }
}
