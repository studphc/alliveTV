package com.google.android.gms.common.wrappers;

import android.content.AttributionSource;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class AttributionSourceWrapper {

    /* renamed from: a */
    public final AttributionSource f13673a;

    @KeepForSdk
    public AttributionSourceWrapper(@Nullable AttributionSource attributionSource) {
        this.f13673a = attributionSource;
    }

    @Nullable
    @KeepForSdk
    public AttributionSource getAttributionSource() {
        return this.f13673a;
    }
}
