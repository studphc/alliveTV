package com.google.android.exoplayer2.mediacodec;

import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;

/* renamed from: com.google.android.exoplayer2.mediacodec.b */
/* loaded from: classes.dex */
public abstract class AbstractC0677b {
    @DoNotInline
    /* renamed from: a */
    public static void m2670a(MediaCodecAdapter.Configuration configuration, PlayerId playerId) {
        LogSessionId logSessionId;
        boolean equals;
        String stringId;
        LogSessionId logSessionId2 = playerId.getLogSessionId();
        logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        equals = logSessionId2.equals(logSessionId);
        if (!equals) {
            MediaFormat mediaFormat = configuration.mediaFormat;
            stringId = logSessionId2.getStringId();
            mediaFormat.setString("log-session-id", stringId);
        }
    }
}
