package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.provider.CallableC0191f;
import androidx.media.AbstractC0436m;
import androidx.media.C0431h;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.RunnableC0753b;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzbf;
import com.google.android.gms.measurement.internal.zzbh;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzif;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzqa;
import com.google.android.gms.measurement.internal.zzqb;
import com.google.android.gms.measurement.internal.zzr;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class sk1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f26462a;

    /* renamed from: b */
    public Object f26463b;

    /* renamed from: c */
    public Object f26464c;

    /* renamed from: d */
    public Object f26465d;

    public /* synthetic */ sk1() {
        this.f26462a = 1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Bundle bundle;
        zzbf zzbfVar;
        switch (this.f26462a) {
            case 0:
                AbstractC0436m abstractC0436m = (AbstractC0436m) this.f26465d;
                Iterator it = abstractC0436m.f6717d.f6662d.keySet().iterator();
                while (it.hasNext()) {
                    abstractC0436m.m1561c((C0431h) abstractC0436m.f6717d.f6662d.get((IBinder) it.next()), (String) this.f26463b, (Bundle) this.f26464c);
                }
                return;
            case 1:
                try {
                    obj = ((CallableC0191f) this.f26463b).call();
                } catch (Exception unused) {
                    obj = null;
                }
                ((Handler) this.f26465d).post(new xy1(11, (zs0) this.f26464c, obj, false));
                return;
            case 2:
                Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
                Bitmap bitmap = null;
                Uri uri = (Uri) this.f26463b;
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) this.f26464c;
                if (parcelFileDescriptor != null) {
                    try {
                        bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                    } catch (OutOfMemoryError e) {
                        Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(uri)), e);
                    }
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e2) {
                        Log.e("ImageManager", "closed failed", e2);
                    }
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ImageManager imageManager = (ImageManager) this.f26465d;
                imageManager.f13344b.post(new RunnableC0753b(imageManager, uri, bitmap, countDownLatch));
                try {
                    countDownLatch.await();
                    return;
                } catch (InterruptedException unused2) {
                    Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(uri)));
                    return;
                }
            case 3:
                h71 h71Var = (h71) this.f26465d;
                int i = h71Var.f17964a;
                LifecycleCallback lifecycleCallback = (LifecycleCallback) this.f26464c;
                if (i > 0) {
                    Bundle bundle2 = (Bundle) h71Var.f17966c;
                    if (bundle2 != null) {
                        bundle = bundle2.getBundle((String) this.f26463b);
                    } else {
                        bundle = null;
                    }
                    lifecycleCallback.onCreate(bundle);
                }
                if (h71Var.f17964a >= 2) {
                    lifecycleCallback.onStart();
                }
                if (h71Var.f17964a >= 3) {
                    lifecycleCallback.onResume();
                }
                if (h71Var.f17964a >= 4) {
                    lifecycleCallback.onStop();
                }
                if (h71Var.f17964a >= 5) {
                    lifecycleCallback.onDestroy();
                    return;
                }
                return;
            case 4:
                zzjp zzjpVar = (zzjp) this.f26465d;
                zzjpVar.f14280a.m3643c();
                zzai zzaiVar = (zzai) this.f26463b;
                Object zza = zzaiVar.zzc.zza();
                zzr zzrVar = (zzr) this.f26464c;
                zzpv zzpvVar = zzjpVar.f14280a;
                if (zza == null) {
                    zzpvVar.m3621H(zzaiVar, zzrVar);
                    return;
                } else {
                    zzpvVar.m3626M(zzaiVar, zzrVar);
                    return;
                }
            case 5:
                zzjp zzjpVar2 = (zzjp) this.f26465d;
                zzjpVar2.getClass();
                zzbh zzbhVar = (zzbh) this.f26463b;
                boolean equals = "_cmp".equals(zzbhVar.zza);
                zzpv zzpvVar2 = zzjpVar2.f14280a;
                if (equals && (zzbfVar = zzbhVar.zzb) != null && zzbfVar.zza() != 0) {
                    String string = zzbfVar.f14148a.getString("_cis");
                    if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                        zzpvVar2.zzaW().zzi().zzb("Event has been filtered ", zzbhVar.toString());
                        zzbhVar = new zzbh("_cmpx", zzbfVar, zzbhVar.zzc, zzbhVar.zzd);
                    }
                }
                zzc zzcVar = null;
                boolean booleanValue = ((Boolean) zzgi.zzbn.zza(null)).booleanValue();
                zzr zzrVar2 = (zzr) this.f26464c;
                if (!booleanValue) {
                    zzif zzr = zzpvVar2.zzr();
                    String str = zzrVar2.zza;
                    if (!zzr.zzs(str)) {
                        zzjpVar2.m3560e(zzbhVar, zzrVar2);
                        return;
                    }
                    zzpvVar2.zzaW().zzj().zzb("EES config found for", str);
                }
                zzif zzr2 = zzpvVar2.zzr();
                String str2 = zzrVar2.zza;
                if (!TextUtils.isEmpty(str2)) {
                    zzcVar = (zzc) zzr2.f14232h.get(str2);
                }
                if (zzcVar != null) {
                    try {
                        zzqa zzA = zzpvVar2.zzA();
                        Bundle zzc = zzbhVar.zzb.zzc();
                        zzA.getClass();
                        HashMap m3665C = zzqa.m3665C(zzc, true);
                        String str3 = zzbhVar.zza;
                        String zza2 = zzjy.zza(str3);
                        if (zza2 != null) {
                            str3 = zza2;
                        }
                        if (zzcVar.zze(new zzaa(str3, zzbhVar.zzd, m3665C))) {
                            if (zzcVar.zzg()) {
                                zzpvVar2.zzaW().zzj().zzb("EES edited event", zzbhVar.zza);
                                zzqa zzA2 = zzpvVar2.zzA();
                                zzaa zzb = zzcVar.zza().zzb();
                                zzA2.getClass();
                                zzjpVar2.m3560e(zzqa.m3682u(zzb), zzrVar2);
                            } else {
                                zzjpVar2.m3560e(zzbhVar, zzrVar2);
                            }
                            if (zzcVar.zzf()) {
                                for (zzaa zzaaVar : zzcVar.zza().zzc()) {
                                    zzpvVar2.zzaW().zzj().zzb("EES logging created event", zzaaVar.zze());
                                    zzpvVar2.zzA().getClass();
                                    zzjpVar2.m3560e(zzqa.m3682u(zzaaVar), zzrVar2);
                                }
                                return;
                            }
                            return;
                        }
                    } catch (zzd unused3) {
                        zzpvVar2.zzaW().zze().zzc("EES error. appId, eventName", zzrVar2.zzb, zzbhVar.zza);
                    }
                    zzpvVar2.zzaW().zzj().zzb("EES was not applied to event", zzbhVar.zza);
                    zzjpVar2.m3560e(zzbhVar, zzrVar2);
                    return;
                }
                zzpvVar2.zzaW().zzj().zzb("EES not loaded for", zzrVar2.zza);
                zzjpVar2.m3560e(zzbhVar, zzrVar2);
                return;
            case 6:
                zzjp zzjpVar3 = (zzjp) this.f26465d;
                zzjpVar3.f14280a.m3643c();
                zzjpVar3.f14280a.m3650j((zzbh) this.f26464c, (String) this.f26463b);
                return;
            default:
                zzjp zzjpVar4 = (zzjp) this.f26465d;
                zzjpVar4.f14280a.m3643c();
                zzqb zzqbVar = (zzqb) this.f26463b;
                Object zza3 = zzqbVar.zza();
                zzr zzrVar3 = (zzr) this.f26464c;
                zzpv zzpvVar3 = zzjpVar4.f14280a;
                if (zza3 == null) {
                    zzpvVar3.m3622I(zzqbVar.zzb, zzrVar3);
                    return;
                } else {
                    zzpvVar3.m3628O(zzqbVar, zzrVar3);
                    return;
                }
        }
    }

    public /* synthetic */ sk1(int i, String str, Object obj, Object obj2) {
        this.f26462a = i;
        this.f26464c = obj2;
        this.f26463b = str;
        this.f26465d = obj;
    }

    public /* synthetic */ sk1(Object obj, Object obj2, Parcelable parcelable, int i) {
        this.f26462a = i;
        this.f26465d = obj;
        this.f26463b = obj2;
        this.f26464c = parcelable;
    }
}
