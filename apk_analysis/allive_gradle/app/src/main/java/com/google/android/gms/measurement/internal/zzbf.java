package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import p000.oj2;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzbf extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbf> CREATOR = new zzbg();

    /* renamed from: a */
    public final Bundle f14148a;

    public zzbf(Bundle bundle) {
        this.f14148a = bundle;
    }

    /* renamed from: a */
    public final Double m3517a() {
        return Double.valueOf(this.f14148a.getDouble("value"));
    }

    /* renamed from: b */
    public final Object m3518b(String str) {
        return this.f14148a.get(str);
    }

    /* renamed from: c */
    public final String m3519c() {
        return this.f14148a.getString(FirebaseAnalytics.Param.CURRENCY);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new oj2(this);
    }

    public final String toString() {
        return this.f14148a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzc(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.f14148a.size();
    }

    public final Bundle zzc() {
        return new Bundle(this.f14148a);
    }
}
