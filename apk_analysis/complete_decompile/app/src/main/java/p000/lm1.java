package p000;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;

/* loaded from: classes.dex */
public abstract /* synthetic */ class lm1 {
    /* renamed from: a */
    public static Timeline m5958a(MediaSource mediaSource) {
        return null;
    }

    /* renamed from: b */
    public static boolean m5959b(MediaSource mediaSource) {
        return true;
    }

    /* renamed from: c */
    public static void m5960c(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener) {
        mediaSource.prepareSource(mediaSourceCaller, transferListener, PlayerId.UNSET);
    }
}
