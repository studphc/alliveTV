package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzhx;

/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzhx.zza {

    /* renamed from: c */
    public zzhx f13968c;

    @NonNull
    public BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    @Override // com.google.android.gms.measurement.internal.zzhx.zza
    @MainThread
    public void doStartService(@NonNull Context context, @NonNull Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (this.f13968c == null) {
            this.f13968c = new zzhx(this);
        }
        this.f13968c.zza(context, intent);
    }
}
