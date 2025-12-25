package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class zzha {

    /* renamed from: d */
    public static zzha f14179d;

    /* renamed from: a */
    public final zzio f14180a;

    /* renamed from: b */
    public final TelemetryLoggingClient f14181b;

    /* renamed from: c */
    public final AtomicLong f14182c = new AtomicLong(-1);

    public zzha(Context context, zzio zzioVar) {
        this.f14181b = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.f14180a = zzioVar;
    }

    public final synchronized void zzc(int i, int i2, long j, long j2, int i3) {
        final long elapsedRealtime = this.f14180a.zzaU().elapsedRealtime();
        AtomicLong atomicLong = this.f14182c;
        if (atomicLong.get() != -1 && elapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        this.f14181b.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i2, 0, j, j2, null, null, 0, i3)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.measurement.internal.zzgz
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzha.this.f14182c.set(elapsedRealtime);
            }
        });
    }
}
