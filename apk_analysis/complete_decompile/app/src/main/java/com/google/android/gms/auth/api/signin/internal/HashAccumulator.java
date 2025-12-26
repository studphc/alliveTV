package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
/* loaded from: classes.dex */
public class HashAccumulator {

    /* renamed from: a */
    public int f12955a = 1;

    @NonNull
    @CanIgnoreReturnValue
    @KeepForSdk
    public HashAccumulator addObject(@Nullable Object obj) {
        int hashCode;
        int i = this.f12955a * 31;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        this.f12955a = i + hashCode;
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.f12955a;
    }

    @NonNull
    @CanIgnoreReturnValue
    public final HashAccumulator zaa(boolean z) {
        this.f12955a = (this.f12955a * 31) + (z ? 1 : 0);
        return this;
    }
}
