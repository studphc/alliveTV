package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p000.gc3;

/* loaded from: classes.dex */
public final class zzkk implements gc3 {

    /* renamed from: f */
    public static final ArrayMap f13865f = new ArrayMap();

    /* renamed from: a */
    public final SharedPreferences f13866a;

    /* renamed from: b */
    public zzkj f13867b;

    /* renamed from: d */
    public volatile Map f13869d;

    /* renamed from: c */
    public final Object f13868c = new Object();

    /* renamed from: e */
    public final ArrayList f13870e = new ArrayList();

    public zzkk(SharedPreferences sharedPreferences, zzjy zzjyVar) {
        this.f13866a = sharedPreferences;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.measurement.zzkj, android.content.SharedPreferences$OnSharedPreferenceChangeListener] */
    /* renamed from: a */
    public static zzkk m3458a(Context context, String str, zzjy zzjyVar) {
        final zzkk zzkkVar;
        SharedPreferences zza;
        if (zzji.zzc() && !str.startsWith("direct_boot:") && !zzji.zzb(context)) {
            return null;
        }
        synchronized (zzkk.class) {
            ArrayMap arrayMap = f13865f;
            zzkkVar = (zzkk) arrayMap.get(str);
            if (zzkkVar == null) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    if (str.startsWith("direct_boot:")) {
                        if (zzji.zzc()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        zza = zzci.zza(context, str.substring(12), 0, zzcd.zza);
                    } else {
                        zza = zzci.zza(context, str, 0, zzcd.zza);
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    zzkkVar = new zzkk(zza, zzjyVar);
                    ?? r7 = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.measurement.zzkj
                        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                            zzkk.zzc(zzkk.this, sharedPreferences, str2);
                        }
                    };
                    zzkkVar.f13867b = r7;
                    zzkkVar.f13866a.registerOnSharedPreferenceChangeListener(r7);
                    arrayMap.put(str, zzkkVar);
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th;
                }
            }
        }
        return zzkkVar;
    }

    /* renamed from: b */
    public static synchronized void m3459b() {
        synchronized (zzkk.class) {
            try {
                ArrayMap arrayMap = f13865f;
                for (V v : arrayMap.values()) {
                    v.f13866a.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) Preconditions.checkNotNull(v.f13867b));
                }
                arrayMap.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void zzc(zzkk zzkkVar, SharedPreferences sharedPreferences, String str) {
        synchronized (zzkkVar.f13868c) {
            zzkkVar.f13869d = null;
            zzki.zzc();
        }
        synchronized (zzkkVar) {
            try {
                Iterator it = zzkkVar.f13870e.iterator();
                while (it.hasNext()) {
                    ((zzjn) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.gc3
    public final Object zzb(String str) {
        Map<String, ?> map = this.f13869d;
        if (map == null) {
            synchronized (this.f13868c) {
                try {
                    map = this.f13869d;
                    if (map == null) {
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            Map<String, ?> all = this.f13866a.getAll();
                            this.f13869d = all;
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            map = all;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                } finally {
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
