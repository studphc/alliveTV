package p000;

import android.system.ErrnoException;
import android.system.OsConstants;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class mc0 {
    /* JADX INFO: Access modifiers changed from: private */
    @DoNotInline
    /* renamed from: b */
    public static boolean m6129b(@Nullable Throwable th) {
        if ((th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES) {
            return true;
        }
        return false;
    }
}
