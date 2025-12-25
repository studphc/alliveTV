package p000;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzlw;

/* loaded from: classes.dex */
public final class sc3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ String f26371a;

    /* renamed from: b */
    public final /* synthetic */ String f26372b;

    /* renamed from: c */
    public final /* synthetic */ long f26373c;

    /* renamed from: d */
    public final /* synthetic */ Bundle f26374d;

    /* renamed from: e */
    public final /* synthetic */ boolean f26375e;

    /* renamed from: f */
    public final /* synthetic */ boolean f26376f;

    /* renamed from: g */
    public final /* synthetic */ boolean f26377g;

    /* renamed from: h */
    public final /* synthetic */ String f26378h;

    /* renamed from: i */
    public final /* synthetic */ zzlw f26379i;

    public sc3(zzlw zzlwVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f26371a = str;
        this.f26372b = str2;
        this.f26373c = j;
        this.f26374d = bundle;
        this.f26375e = z;
        this.f26376f = z2;
        this.f26377g = z3;
        this.f26378h = str3;
        this.f26379i = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26379i.zzT(this.f26371a, this.f26372b, this.f26373c, this.f26374d, this.f26375e, this.f26376f, this.f26377g, this.f26378h);
    }
}
