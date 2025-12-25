package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Assertions;
import p000.o00;

/* renamed from: com.google.android.exoplayer2.drm.c */
/* loaded from: classes.dex */
public final class C0661c implements ExoMediaDrm.OnEventListener {

    /* renamed from: a */
    public final /* synthetic */ DefaultDrmSessionManager f10027a;

    public C0661c(DefaultDrmSessionManager defaultDrmSessionManager) {
        this.f10027a = defaultDrmSessionManager;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
    public final void onEvent(ExoMediaDrm exoMediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        ((o00) Assertions.checkNotNull(this.f10027a.f9961x)).obtainMessage(i, bArr).sendToTarget();
    }
}
