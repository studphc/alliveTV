package p000;

import android.content.Context;
import androidx.annotation.DoNotInline;
import java.io.File;

/* renamed from: aw */
/* loaded from: classes.dex */
public abstract class AbstractC0535aw {
    @DoNotInline
    /* renamed from: a */
    public static Context m1970a(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    @DoNotInline
    /* renamed from: b */
    public static File m1971b(Context context) {
        return context.getDataDir();
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m1972c(Context context) {
        return context.isDeviceProtectedStorage();
    }
}
