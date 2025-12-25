package p000;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class kx0 {
    @DoNotInline
    /* renamed from: a */
    public static int m5798a(Context context) {
        return ((GrammaticalInflectionManager) context.getSystemService(GrammaticalInflectionManager.class)).getApplicationGrammaticalGender();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m5799b(Context context, int i) {
        ((GrammaticalInflectionManager) context.getSystemService(GrammaticalInflectionManager.class)).setRequestedApplicationGrammaticalGender(i);
    }
}
