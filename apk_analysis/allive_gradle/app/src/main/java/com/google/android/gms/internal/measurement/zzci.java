package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Preconditions;
import p000.C1851tx;

/* loaded from: classes.dex */
public final class zzci {

    /* renamed from: a */
    public static final C1851tx f13803a = new C1851tx(5);

    public static SharedPreferences zza(Context context, String str, int i, zzcc zzccVar) {
        zzcg zzcgVar;
        zzbx.zza();
        if (str.equals("")) {
            zzcgVar = new zzcg();
        } else {
            zzcgVar = null;
        }
        if (zzcgVar != null) {
            return zzcgVar;
        }
        C1851tx c1851tx = f13803a;
        Preconditions.checkArgument(((Boolean) c1851tx.get()).booleanValue());
        c1851tx.set(Boolean.FALSE);
        try {
            return context.getSharedPreferences(str, 0);
        } finally {
            c1851tx.set(Boolean.TRUE);
        }
    }
}
