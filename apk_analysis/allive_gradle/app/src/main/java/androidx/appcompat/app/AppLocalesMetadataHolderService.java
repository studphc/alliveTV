package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.NonNull;
import p000.AbstractC1615oa;

/* loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends Service {
    @NonNull
    public static ServiceInfo getServiceInfo(@NonNull Context context) {
        int i;
        if (Build.VERSION.SDK_INT >= 24) {
            i = AbstractC1615oa.m6525a() | 128;
        } else {
            i = 640;
        }
        return context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), i);
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@NonNull Intent intent) {
        throw new UnsupportedOperationException();
    }
}
