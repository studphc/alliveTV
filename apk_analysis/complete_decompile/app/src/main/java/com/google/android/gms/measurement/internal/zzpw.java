package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzpw {

    /* renamed from: a */
    public final Context f14395a;

    @VisibleForTesting
    public zzpw(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f14395a = applicationContext;
    }
}
