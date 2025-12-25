package p000;

import android.media.MediaDrmResetException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class y60 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m8224a(@Nullable Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}
