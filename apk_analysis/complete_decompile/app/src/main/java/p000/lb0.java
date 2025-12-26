package p000;

import android.content.Context;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import com.google.android.exoplayer2.C0658d;
import com.google.android.exoplayer2.analytics.MediaMetricsListener;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public abstract class lb0 {
    @DoNotInline
    /* renamed from: a */
    public static PlayerId m5913a(Context context, C0658d c0658d, boolean z) {
        LogSessionId logSessionId;
        MediaMetricsListener create = MediaMetricsListener.create(context);
        if (create == null) {
            Log.m3027w("ExoPlayerImpl", "MediaMetricsService unavailable.");
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            return new PlayerId(logSessionId);
        }
        if (z) {
            c0658d.addAnalyticsListener(create);
        }
        return new PlayerId(create.getLogSessionId());
    }
}
