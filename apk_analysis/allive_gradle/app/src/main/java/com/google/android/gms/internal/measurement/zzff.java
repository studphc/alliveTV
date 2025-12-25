package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.C0643C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzig;
import com.google.android.gms.measurement.internal.zzkb;
import com.google.android.gms.measurement.internal.zzkc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.ThreadFactoryC1968x2;
import p000.ab3;
import p000.bb3;
import p000.cb3;
import p000.db3;
import p000.eb3;
import p000.fb3;
import p000.kb3;
import p000.oa3;
import p000.pa3;
import p000.qa3;
import p000.ra3;
import p000.sa3;
import p000.ta3;
import p000.ua3;
import p000.va3;
import p000.ya3;
import p000.za3;

/* loaded from: classes.dex */
public final class zzff {

    /* renamed from: h */
    public static volatile zzff f13813h;

    /* renamed from: a */
    public final String f13814a;

    /* renamed from: b */
    public final AppMeasurementSdk f13815b;

    /* renamed from: c */
    public final ArrayList f13816c;

    /* renamed from: d */
    public int f13817d;

    /* renamed from: e */
    public boolean f13818e;

    /* renamed from: f */
    public final String f13819f;

    /* renamed from: g */
    public volatile zzcv f13820g;
    protected final Clock zza;
    protected final ExecutorService zzb;

    public zzff(Context context, String str, String str2, String str3, Bundle bundle) {
        boolean z;
        if (str != null && str3 != null && str2 != null && !zzT()) {
            this.f13814a = str;
        } else {
            this.f13814a = "FA";
        }
        this.zza = DefaultClock.getInstance();
        zzcq.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC1968x2());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f13815b = new AppMeasurementSdk(this);
        this.f13816c = new ArrayList();
        try {
            if (com.google.android.gms.measurement.internal.zzmg.zzc(context, "google_app_id", zzig.zza(context)) != null && !zzT()) {
                this.f13819f = null;
                this.f13818e = true;
                Log.w(this.f13814a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (str3 != null && str2 != null && !zzT()) {
            this.f13819f = str2;
        } else {
            this.f13819f = "fa";
            if (str2 != null && str3 != null) {
                Log.v(this.f13814a, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            } else {
                if (str2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z ^ (str3 == null)) {
                    Log.w(this.f13814a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        }
        m3294b(new ua3(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f13814a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new kb3(this));
        }
    }

    public static zzff zzg(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (f13813h == null) {
            synchronized (zzff.class) {
                try {
                    if (f13813h == null) {
                        f13813h = new zzff(context, str, str2, str3, bundle);
                    }
                } finally {
                }
            }
        }
        return f13813h;
    }

    /* renamed from: a */
    public final void m3293a(Exception exc, boolean z, boolean z2) {
        this.f13818e |= z;
        String str = this.f13814a;
        if (z) {
            Log.w(str, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzB(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(str, "Error with data collection. Data lost.", exc);
    }

    /* renamed from: b */
    public final void m3294b(AbstractRunnableC0781a abstractRunnableC0781a) {
        this.zzb.execute(abstractRunnableC0781a);
    }

    public final void zzA(String str, String str2, Bundle bundle, long j) {
        m3294b(new db3(this, Long.valueOf(j), str, str2, bundle, true, false));
    }

    public final void zzB(int i, String str, Object obj, Object obj2, Object obj3) {
        m3294b(new za3(this, str, obj));
    }

    public final void zzC(zzkc zzkcVar) {
        Preconditions.checkNotNull(zzkcVar);
        ArrayList arrayList = this.f13816c;
        synchronized (arrayList) {
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    if (zzkcVar.equals(((Pair) arrayList.get(i)).first)) {
                        Log.w(this.f13814a, "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            fb3 fb3Var = new fb3(zzkcVar);
            arrayList.add(new Pair(zzkcVar, fb3Var));
            if (this.f13820g != null) {
                try {
                    this.f13820g.registerOnMeasurementEventListener(fb3Var);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.f13814a, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            m3294b(new cb3(this, fb3Var, 0));
        }
    }

    public final void zzD() {
        m3294b(new ta3(this));
    }

    public final void zzE(Runnable runnable) {
        m3294b(new sa3(this, runnable, 1));
    }

    public final void zzF(Bundle bundle) {
        m3294b(new pa3(this, bundle, 0));
    }

    public final void zzG(Bundle bundle) {
        m3294b(new pa3(this, bundle, 1));
    }

    public final void zzH(zzdj zzdjVar, String str, String str2) {
        m3294b(new qa3(this, zzdjVar, str, str2));
    }

    public final void zzI(boolean z) {
        m3294b(new bb3(this, z));
    }

    public final void zzJ(Bundle bundle) {
        m3294b(new pa3(this, bundle, 2));
    }

    public final void zzK(zzkb zzkbVar) {
        eb3 eb3Var = new eb3(zzkbVar);
        if (this.f13820g != null) {
            try {
                this.f13820g.setEventInterceptor(eb3Var);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.f13814a, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        m3294b(new sa3(this, eb3Var, 2));
    }

    public final void zzL(Boolean bool) {
        m3294b(new sa3(this, bool, 0));
    }

    public final void zzM(long j) {
        m3294b(new va3(this, j));
    }

    public final void zzN(Intent intent) {
        m3294b(new sa3(this, intent, 3));
    }

    public final void zzO(String str) {
        m3294b(new ra3(this, str, 0));
    }

    public final void zzP(String str, String str2, Object obj, boolean z) {
        m3294b(new oa3(this, str, str2, obj, z));
    }

    public final void zzQ(zzkc zzkcVar) {
        Pair pair;
        Preconditions.checkNotNull(zzkcVar);
        ArrayList arrayList = this.f13816c;
        synchronized (arrayList) {
            int i = 0;
            while (true) {
                try {
                    if (i < arrayList.size()) {
                        if (zzkcVar.equals(((Pair) arrayList.get(i)).first)) {
                            pair = (Pair) arrayList.get(i);
                            break;
                        }
                        i++;
                    } else {
                        pair = null;
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (pair == null) {
                Log.w(this.f13814a, "OnEventListener had not been registered.");
                return;
            }
            arrayList.remove(pair);
            fb3 fb3Var = (fb3) pair.second;
            if (this.f13820g != null) {
                try {
                    this.f13820g.unregisterOnMeasurementEventListener(fb3Var);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.f13814a, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            m3294b(new cb3(this, fb3Var, 1));
        }
    }

    public final boolean zzT() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzff.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final int zza(String str) {
        zzcs zzcsVar = new zzcs();
        m3294b(new za3(this, str, zzcsVar, 2));
        Integer num = (Integer) zzcs.zzf(zzcsVar.zzb(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long zzb() {
        zzcs zzcsVar = new zzcs();
        m3294b(new ya3(this, zzcsVar, 2));
        Long zzc = zzcsVar.zzc(500L);
        if (zzc == null) {
            long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i = this.f13817d + 1;
            this.f13817d = i;
            return nextLong + i;
        }
        return zzc.longValue();
    }

    public final Bundle zzc(Bundle bundle, boolean z) {
        zzcs zzcsVar = new zzcs();
        m3294b(new za3(this, bundle, zzcsVar, 1));
        if (z) {
            return zzcsVar.zzb(5000L);
        }
        return null;
    }

    public final AppMeasurementSdk zzd() {
        return this.f13815b;
    }

    public final zzcv zzf(Context context, boolean z) {
        try {
            return zzcu.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            m3293a(e, true, false);
            return null;
        }
    }

    @WorkerThread
    public final Long zzh() {
        zzcs zzcsVar = new zzcs();
        m3294b(new ya3(this, zzcsVar, 6));
        return zzcsVar.zzc(120000L);
    }

    public final Object zzi(int i) {
        zzcs zzcsVar = new zzcs();
        m3294b(new ab3(this, zzcsVar, i));
        return zzcs.zzf(zzcsVar.zzb(C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS), Object.class);
    }

    public final String zzk() {
        return this.f13819f;
    }

    @WorkerThread
    public final String zzl() {
        zzcs zzcsVar = new zzcs();
        m3294b(new ya3(this, zzcsVar, 5));
        return zzcsVar.zzd(120000L);
    }

    public final String zzm() {
        zzcs zzcsVar = new zzcs();
        m3294b(new ya3(this, zzcsVar, 1));
        return zzcsVar.zzd(50L);
    }

    public final String zzn() {
        zzcs zzcsVar = new zzcs();
        m3294b(new ya3(this, zzcsVar, 4));
        return zzcsVar.zzd(500L);
    }

    public final String zzo() {
        zzcs zzcsVar = new zzcs();
        m3294b(new ya3(this, zzcsVar, 3));
        return zzcsVar.zzd(500L);
    }

    public final String zzp() {
        zzcs zzcsVar = new zzcs();
        m3294b(new ya3(this, zzcsVar, 0));
        return zzcsVar.zzd(500L);
    }

    public final List zzq(String str, String str2) {
        zzcs zzcsVar = new zzcs();
        m3294b(new qa3(this, str, str2, zzcsVar, 1));
        List list = (List) zzcs.zzf(zzcsVar.zzb(5000L), List.class);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public final Map zzr(String str, String str2, boolean z) {
        zzcs zzcsVar = new zzcs();
        m3294b(new oa3(this, str, str2, z, zzcsVar));
        Bundle zzb = zzcsVar.zzb(5000L);
        if (zzb != null && zzb.size() != 0) {
            HashMap hashMap = new HashMap(zzb.size());
            for (String str3 : zzb.keySet()) {
                Object obj = zzb.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public final void zzv(String str) {
        m3294b(new ra3(this, str, 1));
    }

    public final void zzw(String str, String str2, Bundle bundle) {
        m3294b(new qa3(this, str, str2, bundle, 0));
    }

    public final void zzx(String str) {
        m3294b(new ra3(this, str, 2));
    }

    public final void zzy(@NonNull String str, Bundle bundle) {
        m3294b(new db3(this, null, null, str, bundle, false, true));
    }

    public final void zzz(String str, String str2, Bundle bundle) {
        m3294b(new db3(this, null, str, str2, bundle, true, true));
    }
}
