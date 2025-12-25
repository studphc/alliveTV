package p000;

import android.content.Context;
import android.view.inputmethod.EditorInfo;

/* loaded from: classes.dex */
public abstract class z70 {
    /* renamed from: a */
    public static boolean m8394a(Context context) {
        return !context.getPackageManager().isAutoRevokeWhitelisted();
    }

    /* renamed from: b */
    public static CharSequence m8395b(EditorInfo editorInfo, int i) {
        return editorInfo.getInitialSelectedText(i);
    }

    /* renamed from: c */
    public static CharSequence m8396c(EditorInfo editorInfo, int i, int i2) {
        return editorInfo.getInitialTextAfterCursor(i, i2);
    }

    /* renamed from: d */
    public static CharSequence m8397d(EditorInfo editorInfo, int i, int i2) {
        return editorInfo.getInitialTextBeforeCursor(i, i2);
    }

    /* renamed from: e */
    public static void m8398e(EditorInfo editorInfo, CharSequence charSequence, int i) {
        editorInfo.setInitialSurroundingSubText(charSequence, i);
    }
}
