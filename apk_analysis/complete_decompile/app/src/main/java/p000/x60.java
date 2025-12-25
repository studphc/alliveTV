package p000;

import android.media.MediaDrm;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public abstract class x60 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m8146a(@Nullable Throwable th) {
        return th instanceof MediaDrm.MediaDrmStateException;
    }

    @DoNotInline
    /* renamed from: b */
    public static int m8147b(Throwable th) {
        return Util.getErrorCodeForMediaDrmErrorCode(Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
    }
}
