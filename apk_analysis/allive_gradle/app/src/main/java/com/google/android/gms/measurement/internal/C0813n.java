package com.google.android.gms.measurement.internal;

import com.google.android.exoplayer2.ExoPlayer;
import java.util.Objects;
import p000.hc3;
import p000.w93;

/* renamed from: com.google.android.gms.measurement.internal.n */
/* loaded from: classes.dex */
public final class C0813n extends w93 {

    /* renamed from: e */
    public final /* synthetic */ int f14062e;

    /* renamed from: f */
    public final /* synthetic */ zzlw f14063f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0813n(zzlw zzlwVar, hc3 hc3Var, int i) {
        super(hc3Var);
        this.f14062e = i;
        this.f14063f = zzlwVar;
    }

    @Override // p000.w93
    /* renamed from: b */
    public final void mo3493b() {
        switch (this.f14062e) {
            case 0:
                final zzlw zzq = this.f14063f.zzu.zzq();
                Objects.requireNonNull(zzq);
                new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzlw.this.m3566b();
                    }
                }).start();
                return;
            default:
                zzlw zzlwVar = this.f14063f;
                if (zzlwVar.zzu.zzO()) {
                    zzlwVar.f14315q.m8016c(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                }
                return;
        }
    }
}
