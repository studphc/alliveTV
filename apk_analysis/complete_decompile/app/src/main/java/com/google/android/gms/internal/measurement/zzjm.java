package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000.gc3;
import p000.xs0;

/* loaded from: classes.dex */
public final class zzjm implements gc3 {

    /* renamed from: h */
    public static final ArrayMap f13838h = new ArrayMap();
    public static final String[] zza = {"key", "value"};

    /* renamed from: a */
    public final ContentResolver f13839a;

    /* renamed from: b */
    public final Uri f13840b;

    /* renamed from: c */
    public final Runnable f13841c;

    /* renamed from: d */
    public final xs0 f13842d;

    /* renamed from: f */
    public volatile Map f13844f;

    /* renamed from: e */
    public final Object f13843e = new Object();

    /* renamed from: g */
    public final ArrayList f13845g = new ArrayList();

    public zzjm(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.f13839a = contentResolver;
        this.f13840b = uri;
        this.f13841c = runnable;
        this.f13842d = new xs0(2, this);
    }

    /* renamed from: a */
    public static synchronized void m3456a() {
        synchronized (zzjm.class) {
            try {
                ArrayMap arrayMap = f13838h;
                for (V v : arrayMap.values()) {
                    v.f13839a.unregisterContentObserver(v.f13842d);
                }
                arrayMap.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzjm zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzjm zzjmVar;
        synchronized (zzjm.class) {
            ArrayMap arrayMap = f13838h;
            zzjmVar = (zzjm) arrayMap.get(uri);
            if (zzjmVar == null) {
                try {
                    zzjm zzjmVar2 = new zzjm(contentResolver, uri, runnable);
                    try {
                        contentResolver.registerContentObserver(uri, false, zzjmVar2.f13842d);
                        arrayMap.put(uri, zzjmVar2);
                    } catch (SecurityException unused) {
                    }
                    zzjmVar = zzjmVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzjmVar;
    }

    public static /* synthetic */ Map zzc(zzjm zzjmVar) {
        Map emptyMap;
        Cursor query;
        Map hashMap;
        Map emptyMap2;
        ContentResolver contentResolver = zzjmVar.f13839a;
        Uri uri = zzjmVar.f13840b;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (acquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            try {
                query = acquireUnstableContentProviderClient.query(uri, zza, null, null, null);
                try {
                } catch (Throwable th) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (RemoteException e) {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
                emptyMap = Collections.emptyMap();
            }
            if (query == null) {
                Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                emptyMap = Collections.emptyMap();
                acquireUnstableContentProviderClient.release();
                return emptyMap;
            }
            int count = query.getCount();
            if (count == 0) {
                emptyMap2 = Collections.emptyMap();
            } else {
                if (count <= 256) {
                    hashMap = new ArrayMap(count);
                } else {
                    hashMap = new HashMap(count, 1.0f);
                }
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                if (!query.isAfterLast()) {
                    Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                    emptyMap2 = Collections.emptyMap();
                } else {
                    query.close();
                    acquireUnstableContentProviderClient.release();
                    return hashMap;
                }
            }
            query.close();
            acquireUnstableContentProviderClient.release();
            return emptyMap2;
        } catch (Throwable th3) {
            acquireUnstableContentProviderClient.release();
            throw th3;
        }
    }

    @Override // p000.gc3
    public final /* bridge */ /* synthetic */ Object zzb(String str) {
        return (String) zzd().get(str);
    }

    public final Map zzd() {
        Map emptyMap;
        Map map = this.f13844f;
        if (map == null) {
            synchronized (this.f13843e) {
                map = this.f13844f;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            emptyMap = (Map) zzjp.zza(new zzjq() { // from class: com.google.android.gms.internal.measurement.zzjk
                                @Override // com.google.android.gms.internal.measurement.zzjq
                                public final Object zza() {
                                    return zzjm.zzc(zzjm.this);
                                }
                            });
                        } finally {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException e) {
                        Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                        emptyMap = Collections.emptyMap();
                    }
                    this.f13844f = emptyMap;
                    map = emptyMap;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final void zzf() {
        synchronized (this.f13843e) {
            this.f13844f = null;
            this.f13841c.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.f13845g.iterator();
                while (it.hasNext()) {
                    ((zzjn) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
