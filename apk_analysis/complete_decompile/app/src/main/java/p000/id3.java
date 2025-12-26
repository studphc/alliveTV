package p000;

import com.google.android.gms.measurement.internal.zzmh;
import com.google.android.gms.measurement.internal.zzmo;

/* loaded from: classes.dex */
public final class id3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ zzmh f18376a;

    /* renamed from: b */
    public final /* synthetic */ zzmh f18377b;

    /* renamed from: c */
    public final /* synthetic */ long f18378c;

    /* renamed from: d */
    public final /* synthetic */ boolean f18379d;

    /* renamed from: e */
    public final /* synthetic */ zzmo f18380e;

    public id3(zzmo zzmoVar, zzmh zzmhVar, zzmh zzmhVar2, long j, boolean z) {
        this.f18376a = zzmhVar;
        this.f18377b = zzmhVar2;
        this.f18378c = j;
        this.f18379d = z;
        this.f18380e = zzmoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18380e.m3578b(this.f18376a, this.f18377b, this.f18378c, this.f18379d, null);
    }
}
