package p000;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import com.google.android.exoplayer2.analytics.PlayerId;

/* loaded from: classes.dex */
public abstract class g00 {
    @DoNotInline
    /* renamed from: a */
    public static void m4895a(AudioTrack audioTrack, PlayerId playerId) {
        LogSessionId logSessionId;
        boolean equals;
        LogSessionId logSessionId2 = playerId.getLogSessionId();
        logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        equals = logSessionId2.equals(logSessionId);
        if (!equals) {
            audioTrack.setLogSessionId(logSessionId2);
        }
    }
}
