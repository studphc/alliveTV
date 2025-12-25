package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;
import p000.AbstractC1726qj;

/* renamed from: com.google.android.gms.measurement.internal.w */
/* loaded from: classes.dex */
public final class RunnableC0827w implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14103a = 1;

    /* renamed from: b */
    public final /* synthetic */ boolean f14104b;

    /* renamed from: c */
    public final /* synthetic */ Object f14105c;

    /* renamed from: d */
    public final /* synthetic */ Object f14106d;

    /* renamed from: e */
    public final /* synthetic */ Object f14107e;

    /* renamed from: f */
    public final /* synthetic */ Object f14108f;

    public RunnableC0827w(C0828x c0828x, boolean z, Uri uri, String str, String str2) {
        this.f14104b = z;
        this.f14107e = uri;
        this.f14105c = str;
        this.f14106d = str2;
        this.f14108f = c0828x;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0142 A[Catch: RuntimeException -> 0x012f, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x012f, blocks: (B:63:0x00fc, B:65:0x0106, B:68:0x0113, B:70:0x0119, B:71:0x0134, B:30:0x013a, B:34:0x0142, B:38:0x0163, B:40:0x0179, B:42:0x016b, B:43:0x017d, B:45:0x0183, B:47:0x0189, B:49:0x018f, B:51:0x0195, B:53:0x019d, B:55:0x01a5, B:57:0x01ab, B:60:0x01af), top: B:62:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Bundle m3720S;
        boolean z;
        switch (this.f14103a) {
            case 0:
                ((zzlw) this.f14108f).zzu.zzu().zzL((AtomicReference) this.f14107e, null, (String) this.f14105c, (String) this.f14106d, this.f14104b);
                return;
            case 1:
                C0828x c0828x = (C0828x) this.f14108f;
                zzlw zzlwVar = c0828x.f14109a;
                zzlwVar.zzg();
                String str = (String) this.f14106d;
                Uri uri = (Uri) this.f14107e;
                try {
                    zzio zzioVar = zzlwVar.zzu;
                    zzqf zzw = zzioVar.zzw();
                    if (!TextUtils.isEmpty(str)) {
                        if (!str.contains("gclid")) {
                            try {
                                if (!str.contains("gbraid") && !str.contains("utm_campaign") && !str.contains("utm_source") && !str.contains("utm_medium") && !str.contains("utm_id") && !str.contains("dclid") && !str.contains("srsltid") && !str.contains("sfmc_id")) {
                                    zzw.zzu.zzaW().zzd().zza("Activity created with data 'referrer' without required params");
                                }
                            } catch (RuntimeException e) {
                                e = e;
                                c0828x.f14109a.zzu.zzaW().zze().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
                                return;
                            }
                        }
                        m3720S = zzw.m3720S(Uri.parse("https://google.com/search?".concat(str)));
                        if (m3720S != null) {
                            m3720S.putString("_cis", "referrer");
                        }
                        z = this.f14104b;
                        zzx zzxVar = zzlwVar.f14314p;
                        String str2 = (String) this.f14105c;
                        if (z) {
                            try {
                                Bundle m3720S2 = zzioVar.zzw().m3720S(uri);
                                if (m3720S2 != null) {
                                    m3720S2.putString("_cis", "intent");
                                    if (!m3720S2.containsKey("gclid") && m3720S != null && m3720S.containsKey("gclid")) {
                                        m3720S2.putString("_cer", "gclid=" + m3720S.getString("gclid"));
                                    }
                                    zzlwVar.m3567c(str2, "_cmp", m3720S2);
                                    zzxVar.m3744a(str2, m3720S2);
                                }
                            } catch (RuntimeException e2) {
                                e = e2;
                                c0828x = c0828x;
                                c0828x.f14109a.zzu.zzaW().zze().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
                                return;
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            zzioVar.zzaW().zzd().zzb("Activity created with referrer", str);
                            if (zzioVar.zzf().zzx(null, zzgi.zzaF)) {
                                if (m3720S != null) {
                                    zzlwVar.m3567c(str2, "_cmp", m3720S);
                                    zzxVar.m3744a(str2, m3720S);
                                } else {
                                    zzioVar.zzaW().zzd().zzb("Referrer does not contain valid parameters", str);
                                }
                                zzlwVar.zzal(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", null, true);
                                return;
                            }
                            if (str.contains("gclid") && (str.contains("utm_campaign") || str.contains("utm_source") || str.contains("utm_medium") || str.contains("utm_term") || str.contains("utm_content"))) {
                                if (!TextUtils.isEmpty(str)) {
                                    zzlwVar.zzal(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", str, true);
                                    return;
                                }
                                return;
                            }
                            zzioVar.zzaW().zzd().zza("Activity created with data 'referrer' without required params");
                            return;
                        }
                        return;
                    }
                    m3720S = null;
                    z = this.f14104b;
                    zzx zzxVar2 = zzlwVar.f14314p;
                    String str22 = (String) this.f14105c;
                    if (z) {
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                } catch (RuntimeException e3) {
                    e = e3;
                }
                break;
            default:
                zzny zznyVar = (zzny) this.f14108f;
                zzgl zzglVar = zznyVar.f14338c;
                if (zzglVar == null) {
                    AbstractC1726qj.m7039D(zznyVar.zzu, "Failed to send default event parameters to service");
                    return;
                }
                zzbf zzbfVar = null;
                boolean zzx = zznyVar.zzu.zzf().zzx(null, zzgi.zzbl);
                zzr zzrVar = (zzr) this.f14107e;
                if (zzx) {
                    Preconditions.checkNotNull(zzrVar);
                    if (!this.f14104b) {
                        zzbfVar = (zzbf) this.f14105c;
                    }
                    zznyVar.m3584b(zzglVar, zzbfVar, zzrVar);
                    return;
                }
                try {
                    Preconditions.checkNotNull(zzrVar);
                    zzglVar.zzx((Bundle) this.f14106d, zzrVar);
                    zznyVar.m3589g();
                    return;
                } catch (RemoteException e4) {
                    zznyVar.zzu.zzaW().zze().zzb("Failed to send default event parameters to service", e4);
                    return;
                }
        }
    }

    public RunnableC0827w(zzlw zzlwVar, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.f14107e = atomicReference;
        this.f14105c = str;
        this.f14106d = str2;
        this.f14104b = z;
        this.f14108f = zzlwVar;
    }

    public RunnableC0827w(zzny zznyVar, zzr zzrVar, boolean z, zzbf zzbfVar, Bundle bundle) {
        this.f14107e = zzrVar;
        this.f14104b = z;
        this.f14105c = zzbfVar;
        this.f14106d = bundle;
        this.f14108f = zznyVar;
    }
}
