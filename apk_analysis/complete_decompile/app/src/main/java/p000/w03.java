package p000;

import android.content.Context;
import android.os.UserManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class w03 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m7960a(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
