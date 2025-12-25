package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes.dex */
public final class zzx {

    /* renamed from: a */
    public final zzio f14413a;

    public zzx(zzio zzioVar) {
        this.f14413a = zzioVar;
    }

    /* renamed from: a */
    public final void m3744a(String str, Bundle bundle) {
        String uri;
        zzio zzioVar = this.f14413a;
        zzioVar.zzaX().zzg();
        if (!zzioVar.zzJ()) {
            if (bundle.isEmpty()) {
                uri = null;
            } else {
                if (true == str.isEmpty()) {
                    str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str2 : bundle.keySet()) {
                    builder.appendQueryParameter(str2, bundle.getString(str2));
                }
                uri = builder.build().toString();
            }
            if (!TextUtils.isEmpty(uri)) {
                zzioVar.zzm().f27214w.zzb(uri);
                zzioVar.zzm().f27215x.zzb(zzioVar.zzaU().currentTimeMillis());
            }
        }
    }

    /* renamed from: b */
    public final boolean m3745b() {
        if (this.f14413a.zzm().f27215x.zza() > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final boolean m3746c() {
        if (!m3745b()) {
            return false;
        }
        zzio zzioVar = this.f14413a;
        if (zzioVar.zzaU().currentTimeMillis() - zzioVar.zzm().f27215x.zza() <= zzioVar.zzf().zzk(null, zzgi.zzai)) {
            return false;
        }
        return true;
    }
}
