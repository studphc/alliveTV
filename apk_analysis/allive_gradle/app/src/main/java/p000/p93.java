package p000;

import com.google.android.gms.internal.common.zzak;
import com.google.android.gms.internal.common.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public final class p93 extends zzak {

    /* renamed from: c */
    public final transient int f25090c;

    /* renamed from: d */
    public final transient int f25091d;

    /* renamed from: e */
    public final /* synthetic */ zzak f25092e;

    public p93(zzak zzakVar, int i, int i2) {
        this.f25092e = zzakVar;
        this.f25090c = i;
        this.f25091d = i2;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: b */
    public final int mo3210b() {
        return this.f25092e.mo3211c() + this.f25090c + this.f25091d;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: c */
    public final int mo3211c() {
        return this.f25092e.mo3211c() + this.f25090c;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: d */
    public final boolean mo3212d() {
        return true;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: e */
    public final Object[] mo3213e() {
        return this.f25092e.mo3213e();
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzv.zza(i, this.f25091d, FirebaseAnalytics.Param.INDEX);
        return this.f25092e.get(i + this.f25090c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f25091d;
    }

    @Override // com.google.android.gms.internal.common.zzak, java.util.List
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzak subList(int i, int i2) {
        zzv.zzc(i, i2, this.f25091d);
        int i3 = this.f25090c;
        return this.f25092e.subList(i + i3, i2 + i3);
    }
}
