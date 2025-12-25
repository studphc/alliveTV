package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import p000.ob3;
import p000.rb3;
import p000.re3;

/* loaded from: classes.dex */
public final class zzhk extends re3 {
    public zzhk(zzpv zzpvVar) {
        super(zzpvVar);
    }

    @WorkerThread
    public final void zza(ob3 ob3Var, Map map, rb3 rb3Var) {
        zzg();
        zzav();
        Preconditions.checkNotNull(ob3Var);
        Preconditions.checkNotNull(rb3Var);
        zzpi zzy = this.zzg.zzy();
        Uri.Builder builder = new Uri.Builder();
        String m6540g = ob3Var.m6540g();
        if (TextUtils.isEmpty(m6540g)) {
            m6540g = ob3Var.m6534a();
        }
        Uri.Builder appendQueryParameter = builder.scheme((String) zzgi.zze.zza(null)).encodedAuthority((String) zzgi.zzf.zza(null)).path("config/app/".concat(String.valueOf(m6540g))).appendQueryParameter("platform", "android");
        zzy.zzu.zzf().zzj();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(119002L)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            this.zzu.zzaX().zzp(new RunnableC0795e(this, ob3Var.m6536c(), new URI(uri).toURL(), null, map, rb3Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaW().zze().zzc("Failed to parse config URL. Not fetching. appId", zzhe.zzn(ob3Var.m6536c()), uri);
        }
    }

    @Override // p000.re3
    public final boolean zzb() {
        return false;
    }

    @WorkerThread
    public final void zzc(String str, zzph zzphVar, com.google.android.gms.internal.measurement.zzhv zzhvVar, rb3 rb3Var) {
        zzg();
        zzav();
        try {
            URL url = new URI(zzphVar.zzc()).toURL();
            this.zzg.zzA();
            this.zzu.zzaX().zzp(new RunnableC0795e(this, str, url, zzhvVar.zzcd(), zzphVar.zzd(), rb3Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaW().zze().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzhe.zzn(str), zzphVar.zzc());
        }
    }

    public final boolean zzd() {
        zzav();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzu.zzaT().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
