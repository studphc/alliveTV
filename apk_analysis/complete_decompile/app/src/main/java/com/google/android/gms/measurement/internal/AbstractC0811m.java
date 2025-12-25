package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;
import p000.hc3;

/* renamed from: com.google.android.gms.measurement.internal.m */
/* loaded from: classes.dex */
public abstract class AbstractC0811m implements hc3 {
    protected final zzio zzu;

    public AbstractC0811m(zzio zzioVar) {
        Preconditions.checkNotNull(zzioVar);
        this.zzu = zzioVar;
    }

    @Override // p000.hc3
    @Pure
    public final Context zzaT() {
        throw null;
    }

    @Override // p000.hc3
    @Pure
    public final Clock zzaU() {
        throw null;
    }

    @Override // p000.hc3
    @Pure
    public final zzaf zzaV() {
        throw null;
    }

    @Override // p000.hc3
    @Pure
    public final zzhe zzaW() {
        throw null;
    }

    @Override // p000.hc3
    @Pure
    public final zzil zzaX() {
        throw null;
    }

    public void zzaY() {
        this.zzu.zzaX().zzaY();
    }

    public void zzg() {
        this.zzu.zzaX().zzg();
    }
}
