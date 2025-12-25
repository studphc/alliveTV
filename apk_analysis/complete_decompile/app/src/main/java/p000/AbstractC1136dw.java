package p000;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: dw */
/* loaded from: classes.dex */
public abstract class AbstractC1136dw {
    @NonNull
    @DoNotInline
    /* renamed from: a */
    public static Context m4622a(@NonNull Context context, @Nullable String str) {
        return context.createAttributionContext(str);
    }

    @DoNotInline
    /* renamed from: b */
    public static String m4623b(Context context) {
        return context.getAttributionTag();
    }

    @DoNotInline
    /* renamed from: c */
    public static Display m4624c(Context context) {
        try {
            return context.getDisplay();
        } catch (UnsupportedOperationException unused) {
            Log.w("ContextCompat", "The context:" + context + " is not associated with any display. Return a fallback display instead.");
            return ((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(0);
        }
    }
}
