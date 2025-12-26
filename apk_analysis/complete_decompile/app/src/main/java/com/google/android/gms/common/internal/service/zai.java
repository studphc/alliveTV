package com.google.android.gms.common.internal.service;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.zac;

/* loaded from: classes.dex */
public final class zai extends com.google.android.gms.internal.base.zaa implements IInterface {
    public final void zae(TelemetryData telemetryData) {
        Parcel zaa = zaa();
        zac.zac(zaa, telemetryData);
        zad(1, zaa);
    }
}
