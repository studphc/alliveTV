package androidx.core.os;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import p000.w03;

/* loaded from: classes.dex */
public class UserManagerCompat {
    public static boolean isUserUnlocked(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return w03.m7960a(context);
        }
        return true;
    }
}
