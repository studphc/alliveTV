package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.xs0;

/* loaded from: classes.dex */
public final class zzjh implements zzjd {

    /* renamed from: a */
    public final AtomicBoolean f13829a = new AtomicBoolean();

    /* renamed from: b */
    public HashMap f13830b = null;

    /* renamed from: c */
    public final HashMap f13831c = new HashMap(16, 1.0f);

    /* renamed from: d */
    public final HashMap f13832d = new HashMap(16, 1.0f);

    /* renamed from: e */
    public final HashMap f13833e = new HashMap(16, 1.0f);

    /* renamed from: f */
    public final HashMap f13834f = new HashMap(16, 1.0f);

    /* renamed from: g */
    public Object f13835g = null;

    @Override // com.google.android.gms.internal.measurement.zzjd
    @Nullable
    public final String zza(@Nullable ContentResolver contentResolver, String str, @Nullable String str2) {
        String str3;
        if (contentResolver != null) {
            synchronized (this) {
                try {
                    if (this.f13830b == null) {
                        this.f13829a.set(false);
                        this.f13830b = new HashMap(16, 1.0f);
                        this.f13835g = new Object();
                        contentResolver.registerContentObserver(zzjc.zza, true, new xs0(1, this));
                    } else if (this.f13829a.getAndSet(false)) {
                        this.f13830b.clear();
                        this.f13831c.clear();
                        this.f13832d.clear();
                        this.f13833e.clear();
                        this.f13834f.clear();
                        this.f13835g = new Object();
                    }
                    Object obj = this.f13835g;
                    String str4 = null;
                    if (this.f13830b.containsKey(str)) {
                        String str5 = (String) this.f13830b.get(str);
                        if (str5 != null) {
                            str4 = str5;
                        }
                        return str4;
                    }
                    try {
                        Uri uri = zzjc.zza;
                        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                        try {
                            if (acquireUnstableContentProviderClient != null) {
                                try {
                                    Cursor query = acquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                                    try {
                                        if (query != null) {
                                            if (query.moveToFirst()) {
                                                str3 = query.getString(1);
                                                query.close();
                                            } else {
                                                query.close();
                                                str3 = null;
                                            }
                                            if (str3 != null && str3.equals(null)) {
                                                str3 = null;
                                            }
                                            synchronized (this) {
                                                try {
                                                    if (obj == this.f13835g) {
                                                        this.f13830b.put(str, str3);
                                                    }
                                                } finally {
                                                }
                                            }
                                            if (str3 == null) {
                                                return null;
                                            }
                                            return str3;
                                        }
                                        throw new zzjg("ContentProvider query returned null cursor");
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
                                    throw new zzjg("ContentProvider query failed", e);
                                }
                            }
                            throw new zzjg("Unable to acquire ContentProviderClient");
                        } finally {
                            acquireUnstableContentProviderClient.release();
                        }
                    } catch (zzjg unused) {
                        return null;
                    }
                } finally {
                }
            }
        }
        throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
    }
}
