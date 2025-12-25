package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Assertions;
import java.util.UUID;

/* loaded from: classes.dex */
public final class LocalMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a */
    public final byte[] f9995a;

    public LocalMediaDrmCallback(byte[] bArr) {
        this.f9995a = (byte[]) Assertions.checkNotNull(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
        return this.f9995a;
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) {
        throw new UnsupportedOperationException();
    }
}
