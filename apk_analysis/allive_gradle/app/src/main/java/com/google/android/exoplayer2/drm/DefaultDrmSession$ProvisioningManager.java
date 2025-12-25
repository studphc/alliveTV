package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public interface DefaultDrmSession$ProvisioningManager {
    void onProvisionCompleted();

    void onProvisionError(Exception exc, boolean z);

    void provisionRequired(C0660b c0660b);
}
