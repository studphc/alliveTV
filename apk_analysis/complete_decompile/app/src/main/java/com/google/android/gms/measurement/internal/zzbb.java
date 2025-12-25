package com.google.android.gms.measurement.internal;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1726qj;
import p000.fc3;

/* loaded from: classes.dex */
public final class zzbb extends fc3 {

    /* renamed from: b */
    public long f14140b;

    /* renamed from: c */
    public String f14141c;

    public final long zza() {
        zzv();
        return this.f14140b;
    }

    public final String zzb() {
        zzv();
        return this.f14141c;
    }

    @Override // p000.fc3
    public final boolean zzc() {
        Calendar calendar = Calendar.getInstance();
        this.f14140b = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.f14141c = AbstractC1726qj.m7058n(language.toLowerCase(locale2), "-", locale.getCountry().toLowerCase(locale2));
        return false;
    }
}
