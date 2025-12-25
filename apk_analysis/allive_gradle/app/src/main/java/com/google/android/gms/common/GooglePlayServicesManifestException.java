package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* loaded from: classes.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {

    /* renamed from: a */
    public final int f12988a;

    public GooglePlayServicesManifestException(int i, @NonNull String str) {
        super(str);
        this.f12988a = i;
    }

    public int getActualVersion() {
        return this.f12988a;
    }

    public int getExpectedVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
