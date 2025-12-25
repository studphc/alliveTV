package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* loaded from: classes.dex */
public final class zal {

    /* renamed from: a */
    public final SparseIntArray f13497a;

    /* renamed from: b */
    public final GoogleApiAvailabilityLight f13498b;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, int i) {
        return this.f13497a.get(i, -1);
    }

    @ResultIgnorabilityUnspecified
    public final int zab(@NonNull Context context, @NonNull Api.Client client) {
        SparseIntArray sparseIntArray;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zaa = zaa(context, minApkVersion);
        if (zaa == -1) {
            int i2 = 0;
            while (true) {
                sparseIntArray = this.f13497a;
                if (i2 < sparseIntArray.size()) {
                    int keyAt = sparseIntArray.keyAt(i2);
                    if (keyAt > minApkVersion && sparseIntArray.get(keyAt) == 0) {
                        break;
                    }
                    i2++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i == -1) {
                zaa = this.f13498b.isGooglePlayServicesAvailable(context, minApkVersion);
            } else {
                zaa = i;
            }
            sparseIntArray.put(minApkVersion, zaa);
        }
        return zaa;
    }

    public final void zac() {
        this.f13497a.clear();
    }

    public zal(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.f13497a = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.f13498b = googleApiAvailabilityLight;
    }
}
