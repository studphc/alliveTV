package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* renamed from: com.google.android.gms.security.a */
/* loaded from: classes.dex */
public final class AsyncTaskC0831a extends AsyncTask {

    /* renamed from: a */
    public final /* synthetic */ Context f14418a;

    /* renamed from: b */
    public final /* synthetic */ ProviderInstaller.ProviderInstallListener f14419b;

    public AsyncTaskC0831a(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.f14418a = context;
        this.f14419b = providerInstallListener;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            ProviderInstaller.installIfNeeded(this.f14418a);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return Integer.valueOf(e.errorCode);
        } catch (GooglePlayServicesRepairableException e2) {
            return Integer.valueOf(e2.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        int intValue = num.intValue();
        ProviderInstaller.ProviderInstallListener providerInstallListener = this.f14419b;
        if (intValue == 0) {
            providerInstallListener.onProviderInstalled();
            return;
        }
        providerInstallListener.onProviderInstallFailed(num.intValue(), ProviderInstaller.f14414a.getErrorResolutionIntent(this.f14418a, num.intValue(), "pi"));
    }
}
