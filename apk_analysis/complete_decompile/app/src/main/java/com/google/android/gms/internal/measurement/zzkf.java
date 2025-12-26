package com.google.android.gms.internal.measurement;

import android.net.Uri;
import p000.lc3;

/* loaded from: classes.dex */
public final class zzkf {

    /* renamed from: a */
    public final Uri f13852a;

    /* renamed from: b */
    public final String f13853b;

    /* renamed from: c */
    public final String f13854c;

    /* renamed from: d */
    public final boolean f13855d;

    /* renamed from: e */
    public final boolean f13856e;

    public zzkf(Uri uri, boolean z, boolean z2) {
        this.f13852a = uri;
        this.f13853b = "";
        this.f13854c = "";
        this.f13855d = z;
        this.f13856e = z2;
    }

    public final zzkf zza() {
        return new zzkf(this.f13852a, this.f13855d, true);
    }

    public final zzkf zzb() {
        if (this.f13853b.isEmpty()) {
            return new zzkf(this.f13852a, true, this.f13856e);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzki zzc(String str, double d) {
        Double valueOf = Double.valueOf(-3.0d);
        Object obj = zzki.f13857f;
        return new lc3(this, "measurement.test.double_flag", valueOf, 2);
    }

    public final zzki zzd(String str, long j) {
        Long valueOf = Long.valueOf(j);
        Object obj = zzki.f13857f;
        return new lc3(this, str, valueOf, 0);
    }

    public final zzki zze(String str, String str2) {
        Object obj = zzki.f13857f;
        return new lc3(this, str, str2, 3);
    }

    public final zzki zzf(String str, boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        Object obj = zzki.f13857f;
        return new lc3(this, str, valueOf, 1);
    }

    public zzkf(Uri uri) {
        this(uri, false, false);
    }
}
