package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzke {

    /* renamed from: a */
    public final Context f14290a;

    /* renamed from: b */
    public final String f14291b;

    /* renamed from: c */
    public final String f14292c;

    /* renamed from: d */
    public final String f14293d;

    /* renamed from: e */
    public final Boolean f14294e;

    /* renamed from: f */
    public final long f14295f;

    /* renamed from: g */
    public final com.google.android.gms.internal.measurement.zzdh f14296g;

    /* renamed from: h */
    public final boolean f14297h;

    /* renamed from: i */
    public final Long f14298i;

    /* renamed from: j */
    public final String f14299j;

    public zzke(Context context, @Nullable com.google.android.gms.internal.measurement.zzdh zzdhVar, @Nullable Long l) {
        this.f14297h = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f14290a = applicationContext;
        this.f14298i = l;
        if (zzdhVar != null) {
            this.f14296g = zzdhVar;
            this.f14291b = zzdhVar.zzf;
            this.f14292c = zzdhVar.zze;
            this.f14293d = zzdhVar.zzd;
            this.f14297h = zzdhVar.zzc;
            this.f14295f = zzdhVar.zzb;
            this.f14299j = zzdhVar.zzh;
            Bundle bundle = zzdhVar.zzg;
            if (bundle != null) {
                this.f14294e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
