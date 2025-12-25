package p000;

import android.media.MediaDrm;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public abstract class av0 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m1967a(MediaDrm mediaDrm, String str) {
        boolean requiresSecureDecoder;
        requiresSecureDecoder = mediaDrm.requiresSecureDecoder(str);
        return requiresSecureDecoder;
    }

    @DoNotInline
    /* renamed from: b */
    public static void m1968b(MediaDrm mediaDrm, byte[] bArr, PlayerId playerId) {
        LogSessionId logSessionId;
        boolean equals;
        MediaDrm.PlaybackComponent playbackComponent;
        LogSessionId logSessionId2 = playerId.getLogSessionId();
        logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        equals = logSessionId2.equals(logSessionId);
        if (!equals) {
            playbackComponent = mediaDrm.getPlaybackComponent(bArr);
            AbstractC1267hf.m5065f(Assertions.checkNotNull(playbackComponent)).setLogSessionId(logSessionId2);
        }
    }
}
