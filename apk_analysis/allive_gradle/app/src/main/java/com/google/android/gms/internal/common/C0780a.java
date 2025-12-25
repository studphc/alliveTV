package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.common.a */
/* loaded from: classes.dex */
public final class C0780a extends zzak {

    /* renamed from: e */
    public static final C0780a f13734e = new C0780a(0, new Object[0]);

    /* renamed from: c */
    public final transient Object[] f13735c;

    /* renamed from: d */
    public final transient int f13736d;

    public C0780a(int i, Object[] objArr) {
        this.f13735c = objArr;
        this.f13736d = i;
    }

    @Override // com.google.android.gms.internal.common.zzak, com.google.android.gms.internal.common.zzag
    /* renamed from: a */
    public final void mo3209a(Object[] objArr) {
        System.arraycopy(this.f13735c, 0, objArr, 0, this.f13736d);
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: b */
    public final int mo3210b() {
        return this.f13736d;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: c */
    public final int mo3211c() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: d */
    public final boolean mo3212d() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: e */
    public final Object[] mo3213e() {
        return this.f13735c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzv.zza(i, this.f13736d, FirebaseAnalytics.Param.INDEX);
        Object obj = this.f13735c[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13736d;
    }
}
