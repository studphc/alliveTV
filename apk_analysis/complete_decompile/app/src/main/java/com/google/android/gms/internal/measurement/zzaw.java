package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzaw {

    /* renamed from: a */
    public final ArrayList f13786a = new ArrayList();

    /* renamed from: a */
    public final void m3283a(String str) {
        if (this.f13786a.contains(zzh.zze(str))) {
            throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
        }
        throw new IllegalArgumentException("Command not supported");
    }

    public abstract zzap zza(String str, zzg zzgVar, List list);
}
