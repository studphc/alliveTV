package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

/* loaded from: classes.dex */
public class BooleanResult implements Result {

    /* renamed from: a */
    public final Status f13026a;

    /* renamed from: b */
    public final boolean f13027b;

    @ShowFirstParty
    @KeepForSdk
    public BooleanResult(@NonNull Status status, boolean z) {
        this.f13026a = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.f13027b = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        if (!this.f13026a.equals(booleanResult.f13026a) || this.f13027b != booleanResult.f13027b) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f13026a;
    }

    public boolean getValue() {
        return this.f13027b;
    }

    public final int hashCode() {
        return ((this.f13026a.hashCode() + 527) * 31) + (this.f13027b ? 1 : 0);
    }
}
