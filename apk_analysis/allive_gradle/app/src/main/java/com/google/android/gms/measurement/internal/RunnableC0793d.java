package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import p000.AbstractC1726qj;
import p000.ub3;

/* renamed from: com.google.android.gms.measurement.internal.d */
/* loaded from: classes.dex */
public final class RunnableC0793d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14002a;

    /* renamed from: b */
    public final /* synthetic */ String f14003b;

    /* renamed from: c */
    public final /* synthetic */ Object f14004c;

    /* renamed from: d */
    public final /* synthetic */ Object f14005d;

    /* renamed from: e */
    public final /* synthetic */ Object f14006e;

    /* renamed from: f */
    public final /* synthetic */ zzhe f14007f;

    public RunnableC0793d(zzhe zzheVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f14002a = i;
        this.f14003b = str;
        this.f14004c = obj;
        this.f14005d = obj2;
        this.f14006e = obj3;
        this.f14007f = zzheVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhe zzheVar = this.f14007f;
        ub3 zzm = zzheVar.zzu.zzm();
        if (zzm.f17212a) {
            if (zzheVar.f14187b == 0) {
                zzio zzioVar = zzheVar.zzu;
                if (zzioVar.zzf().zzD()) {
                    zzioVar.zzaV();
                    zzheVar.f14187b = 'C';
                } else {
                    zzioVar.zzaV();
                    zzheVar.f14187b = 'c';
                }
            }
            if (zzheVar.f14188c < 0) {
                zzheVar.zzu.zzf().zzj();
                zzheVar.f14188c = 119002L;
            }
            char charAt = "01VDIWEA?".charAt(this.f14002a);
            char c = zzheVar.f14187b;
            long j = zzheVar.f14188c;
            Object obj = this.f14004c;
            String str = this.f14003b;
            String m3532a = zzhe.m3532a(true, str, obj, this.f14005d, this.f14006e);
            StringBuilder sb = new StringBuilder(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(c);
            sb.append(j);
            String m7061q = AbstractC1726qj.m7061q(sb, ":", m3532a);
            if (m7061q.length() > 1024) {
                m7061q = str.substring(0, 1024);
            }
            zzhq zzhqVar = zzm.f27196e;
            if (zzhqVar != null) {
                zzhqVar.zzb(m7061q, 1L);
                return;
            }
            return;
        }
        Log.println(6, zzheVar.zzr(), "Persisted config not initialized. Not logging error/warn");
    }
}
