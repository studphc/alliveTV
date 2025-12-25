package androidx.leanback.media;

import androidx.leanback.media.PlaybackGlueHost;

/* renamed from: androidx.leanback.media.l */
/* loaded from: classes.dex */
public final class C0309l extends PlaybackGlueHost.HostCallback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackGlue f5476a;

    public C0309l(PlaybackGlue playbackGlue) {
        this.f5476a = playbackGlue;
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
    public final void onHostDestroy() {
        this.f5476a.setHost(null);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
    public final void onHostPause() {
        this.f5476a.onHostPause();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
    public final void onHostResume() {
        this.f5476a.onHostResume();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
    public final void onHostStart() {
        this.f5476a.onHostStart();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
    public final void onHostStop() {
        this.f5476a.onHostStop();
    }
}
