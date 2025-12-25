package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import java.io.File;

/* renamed from: yv */
/* loaded from: classes.dex */
public abstract class AbstractC2034yv {
    @DoNotInline
    /* renamed from: a */
    public static File m8325a(Context context) {
        return context.getCodeCacheDir();
    }

    @DoNotInline
    /* renamed from: b */
    public static Drawable m8326b(Context context, int i) {
        return context.getDrawable(i);
    }

    @DoNotInline
    /* renamed from: c */
    public static File m8327c(Context context) {
        return context.getNoBackupFilesDir();
    }
}
