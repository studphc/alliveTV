package p000;

import android.app.Dialog;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class s30 {
    @DoNotInline
    /* renamed from: a */
    public static <T> T m7322a(Dialog dialog, int i) {
        return (T) dialog.requireViewById(i);
    }
}
