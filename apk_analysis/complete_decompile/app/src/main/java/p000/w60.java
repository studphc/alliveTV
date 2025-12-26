package p000;

import android.media.DeniedByServerException;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class w60 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m8007a(@Nullable Throwable th) {
        return th instanceof DeniedByServerException;
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m8008b(@Nullable Throwable th) {
        return th instanceof NotProvisionedException;
    }
}
