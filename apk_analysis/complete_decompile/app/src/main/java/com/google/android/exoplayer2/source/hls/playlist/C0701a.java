package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.hls.playlist.a */
/* loaded from: classes.dex */
public final class C0701a implements HlsPlaylistTracker.PlaylistEventListener {

    /* renamed from: a */
    public final /* synthetic */ DefaultHlsPlaylistTracker f11520a;

    public C0701a(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        this.f11520a = defaultHlsPlaylistTracker;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public final void onPlaylistChanged() {
        this.f11520a.f11453e.remove(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public final boolean onPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
        C0702b c0702b;
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.f11520a;
        if (defaultHlsPlaylistTracker.f11461m == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<HlsMultivariantPlaylist.Variant> list = ((HlsMultivariantPlaylist) Util.castNonNull(defaultHlsPlaylistTracker.f11459k)).variants;
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                C0702b c0702b2 = (C0702b) defaultHlsPlaylistTracker.f11452d.get(list.get(i2).url);
                if (c0702b2 != null && elapsedRealtime < c0702b2.f11528h) {
                    i++;
                }
            }
            LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = defaultHlsPlaylistTracker.f11451c.getFallbackSelectionFor(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, defaultHlsPlaylistTracker.f11459k.variants.size(), i), loadErrorInfo);
            if (fallbackSelectionFor != null && fallbackSelectionFor.type == 2 && (c0702b = (C0702b) defaultHlsPlaylistTracker.f11452d.get(uri)) != null) {
                C0702b.m2811a(c0702b, fallbackSelectionFor.exclusionDurationMs);
            }
        }
        return false;
    }
}
