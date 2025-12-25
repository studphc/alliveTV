package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: b */
    public final int f12989b;

    public GooglePlayServicesRepairableException(int i, @NonNull String str, @NonNull Intent intent) {
        super(str, intent);
        this.f12989b = i;
    }

    public int getConnectionStatusCode() {
        return this.f12989b;
    }
}
