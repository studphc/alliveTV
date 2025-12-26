package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource;
import p000.t60;

/* renamed from: com.google.android.exoplayer2.drm.i */
/* loaded from: classes.dex */
public final class C0667i implements DrmSessionEventListener {

    /* renamed from: a */
    public final /* synthetic */ OfflineLicenseHelper f10035a;

    public C0667i(OfflineLicenseHelper offlineLicenseHelper) {
        this.f10035a = offlineLicenseHelper;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f10035a.f9997a.open();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f10035a.f9997a.open();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f10035a.f9997a.open();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        t60.m7462d(this, i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        this.f10035a.f9997a.open();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final /* synthetic */ void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        t60.m7465g(this, i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        t60.m7463e(this, i, mediaPeriodId, i2);
    }
}
