package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;
import p000.ja3;

@ShowFirstParty
@ThreadSafe
@KeepForSdk
/* loaded from: classes.dex */
public class WakeLock {

    /* renamed from: n */
    public static final long f14434n = TimeUnit.DAYS.toMillis(366);

    /* renamed from: o */
    public static volatile ScheduledExecutorService f14435o = null;

    /* renamed from: p */
    public static final Object f14436p = new Object();

    /* renamed from: a */
    public final Object f14437a;

    /* renamed from: b */
    public final PowerManager.WakeLock f14438b;

    /* renamed from: c */
    public int f14439c;

    /* renamed from: d */
    public ScheduledFuture f14440d;

    /* renamed from: e */
    public long f14441e;

    /* renamed from: f */
    public final HashSet f14442f;

    /* renamed from: g */
    public boolean f14443g;

    /* renamed from: h */
    public zzb f14444h;

    /* renamed from: i */
    public final Clock f14445i;

    /* renamed from: j */
    public final String f14446j;

    /* renamed from: k */
    public final HashMap f14447k;

    /* renamed from: l */
    public final AtomicInteger f14448l;

    /* renamed from: m */
    public final ScheduledExecutorService f14449m;

    @KeepForSdk
    public WakeLock(@NonNull Context context, int i, @NonNull String str) {
        String str2;
        String packageName = context.getPackageName();
        this.f14437a = new Object();
        this.f14439c = 0;
        this.f14442f = new HashSet();
        this.f14443g = true;
        this.f14445i = DefaultClock.getInstance();
        this.f14447k = new HashMap();
        this.f14448l = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        this.f14444h = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "*gcore*:".concat(valueOf);
            } else {
                str2 = new String("*gcore*:");
            }
            this.f14446j = str2;
        } else {
            this.f14446j = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i, str);
            this.f14438b = newWakeLock;
            if (WorkSourceUtil.hasWorkSourcePermission(context)) {
                WorkSource fromPackage = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(packageName) ? context.getPackageName() : packageName);
                if (fromPackage != null) {
                    try {
                        newWakeLock.setWorkSource(fromPackage);
                    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                        Log.wtf("WakeLock", e.toString());
                    }
                }
            }
            ScheduledExecutorService scheduledExecutorService = f14435o;
            if (scheduledExecutorService == null) {
                synchronized (f14436p) {
                    try {
                        scheduledExecutorService = f14435o;
                        if (scheduledExecutorService == null) {
                            zzh.zza();
                            scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                            f14435o = scheduledExecutorService;
                        }
                    } finally {
                    }
                }
            }
            this.f14449m = scheduledExecutorService;
            return;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append((CharSequence) "expected a non-null reference", 0, 29);
        throw new zzi(sb.toString());
    }

    public static /* synthetic */ void zza(@NonNull WakeLock wakeLock) {
        synchronized (wakeLock.f14437a) {
            try {
                if (!wakeLock.isHeld()) {
                    return;
                }
                Log.e("WakeLock", String.valueOf(wakeLock.f14446j).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                wakeLock.m3748a();
                if (!wakeLock.isHeld()) {
                    return;
                }
                wakeLock.f14439c = 1;
                wakeLock.m3749b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final void m3748a() {
        HashSet hashSet = this.f14442f;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @KeepForSdk
    public void acquire(long j) {
        this.f14448l.incrementAndGet();
        long j2 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, f14434n), 1L);
        if (j > 0) {
            max = Math.min(j, max);
        }
        synchronized (this.f14437a) {
            try {
                if (!isHeld()) {
                    this.f14444h = zzb.zza(false, null);
                    this.f14438b.acquire();
                    this.f14445i.elapsedRealtime();
                }
                this.f14439c++;
                if (this.f14443g) {
                    TextUtils.isEmpty(null);
                }
                ja3 ja3Var = (ja3) this.f14447k.get(null);
                ja3 ja3Var2 = ja3Var;
                if (ja3Var == null) {
                    Object obj = new Object();
                    this.f14447k.put(null, obj);
                    ja3Var2 = obj;
                }
                ja3Var2.f20439a++;
                long elapsedRealtime = this.f14445i.elapsedRealtime();
                if (Long.MAX_VALUE - elapsedRealtime > max) {
                    j2 = elapsedRealtime + max;
                }
                if (j2 > this.f14441e) {
                    this.f14441e = j2;
                    ScheduledFuture scheduledFuture = this.f14440d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f14440d = this.f14449m.schedule(new Runnable() { // from class: com.google.android.gms.stats.zza
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeLock.zza(WakeLock.this);
                        }
                    }, max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final void m3749b() {
        synchronized (this.f14437a) {
            try {
                if (!isHeld()) {
                    return;
                }
                if (this.f14443g) {
                    int i = this.f14439c - 1;
                    this.f14439c = i;
                    if (i > 0) {
                        return;
                    }
                } else {
                    this.f14439c = 0;
                }
                m3748a();
                Iterator it = this.f14447k.values().iterator();
                while (it.hasNext()) {
                    ((ja3) it.next()).f20439a = 0;
                }
                this.f14447k.clear();
                ScheduledFuture scheduledFuture = this.f14440d;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.f14440d = null;
                    this.f14441e = 0L;
                }
                if (this.f14438b.isHeld()) {
                    try {
                        try {
                            this.f14438b.release();
                            if (this.f14444h != null) {
                                this.f14444h = null;
                            }
                        } catch (RuntimeException e) {
                            if (e.getClass().equals(RuntimeException.class)) {
                                Log.e("WakeLock", String.valueOf(this.f14446j).concat(" failed to release!"), e);
                                if (this.f14444h != null) {
                                    this.f14444h = null;
                                }
                            } else {
                                throw e;
                            }
                        }
                    } catch (Throwable th) {
                        if (this.f14444h != null) {
                            this.f14444h = null;
                        }
                        throw th;
                    }
                } else {
                    Log.e("WakeLock", String.valueOf(this.f14446j).concat(" should be held!"));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @KeepForSdk
    public boolean isHeld() {
        boolean z;
        synchronized (this.f14437a) {
            if (this.f14439c > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @KeepForSdk
    public void release() {
        if (this.f14448l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f14446j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f14437a) {
            try {
                if (this.f14443g) {
                    TextUtils.isEmpty(null);
                }
                if (this.f14447k.containsKey(null)) {
                    ja3 ja3Var = (ja3) this.f14447k.get(null);
                    if (ja3Var != null) {
                        int i = ja3Var.f20439a - 1;
                        ja3Var.f20439a = i;
                        if (i == 0) {
                            this.f14447k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f14446j).concat(" counter does not exist"));
                }
                m3749b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public void setReferenceCounted(boolean z) {
        synchronized (this.f14437a) {
            this.f14443g = z;
        }
    }
}
