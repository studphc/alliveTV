package p000;

import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;

/* loaded from: classes.dex */
public abstract /* synthetic */ class ol1 {
    /* renamed from: b */
    public static /* bridge */ /* synthetic */ MediaMetricsManager m6688b(Object obj) {
        return (MediaMetricsManager) obj;
    }

    /* renamed from: c */
    public static /* synthetic */ NetworkEvent.Builder m6689c() {
        return new NetworkEvent.Builder();
    }

    /* renamed from: d */
    public static /* synthetic */ PlaybackErrorEvent.Builder m6690d() {
        return new PlaybackErrorEvent.Builder();
    }

    /* renamed from: e */
    public static /* synthetic */ PlaybackMetrics.Builder m6691e() {
        return new PlaybackMetrics.Builder();
    }

    /* renamed from: g */
    public static /* bridge */ /* synthetic */ PlaybackMetrics.Builder m6693g(Object obj) {
        return (PlaybackMetrics.Builder) obj;
    }

    /* renamed from: i */
    public static /* synthetic */ PlaybackStateEvent.Builder m6695i() {
        return new PlaybackStateEvent.Builder();
    }

    /* renamed from: j */
    public static /* synthetic */ TrackChangeEvent.Builder m6696j(int i) {
        return new TrackChangeEvent.Builder(i);
    }
}
