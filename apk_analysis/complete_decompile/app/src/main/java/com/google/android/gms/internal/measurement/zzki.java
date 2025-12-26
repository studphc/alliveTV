package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p000.dc3;
import p000.gc3;
import p000.jc3;

/* loaded from: classes.dex */
public abstract class zzki {

    /* renamed from: f */
    public static final Object f13857f = new Object();

    /* renamed from: g */
    public static volatile dc3 f13858g;

    /* renamed from: h */
    public static final AtomicInteger f13859h;
    public static final /* synthetic */ int zzc = 0;

    /* renamed from: a */
    public final zzkf f13860a;

    /* renamed from: b */
    public final String f13861b;

    /* renamed from: c */
    public final Object f13862c;

    /* renamed from: d */
    public volatile int f13863d = -1;

    /* renamed from: e */
    public volatile Object f13864e;

    static {
        new AtomicReference();
        Preconditions.checkNotNull(new Object() { // from class: com.google.android.gms.internal.measurement.zzka
        }, "BuildInfo must be non-null");
        f13859h = new AtomicInteger();
    }

    public /* synthetic */ zzki(zzkf zzkfVar, String str, Object obj) {
        if (zzkfVar.f13852a != null) {
            this.f13860a = zzkfVar;
            this.f13861b = str;
            this.f13862c = obj;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void zzc() {
        f13859h.incrementAndGet();
    }

    public static void zzd(final Context context) {
        if (f13858g == null && context != null) {
            Object obj = f13857f;
            synchronized (obj) {
                try {
                    if (f13858g == null) {
                        synchronized (obj) {
                            dc3 dc3Var = f13858g;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                            if (dc3Var == null || dc3Var.f16344a != context) {
                                if (dc3Var != null) {
                                    zzjm.m3456a();
                                    zzkk.m3459b();
                                    jc3.m5435c();
                                }
                                f13858g = new dc3(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzjz
                                    @Override // com.google.common.base.Supplier
                                    public final Object get() {
                                        Object obj2 = zzki.f13857f;
                                        return zzjv.zza(context);
                                    }
                                }));
                                f13859h.incrementAndGet();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public abstract Object mo3457a(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001c, B:13:0x002e, B:16:0x004a, B:18:0x0055, B:20:0x005d, B:22:0x0082, B:24:0x008a, B:27:0x00af, B:30:0x00b7, B:31:0x00ba, B:32:0x00be, B:33:0x0093, B:35:0x0097, B:37:0x00a5, B:39:0x00ab, B:43:0x006f, B:46:0x00c2), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001c, B:13:0x002e, B:16:0x004a, B:18:0x0055, B:20:0x005d, B:22:0x0082, B:24:0x008a, B:27:0x00af, B:30:0x00b7, B:31:0x00ba, B:32:0x00be, B:33:0x0093, B:35:0x0097, B:37:0x00a5, B:39:0x00ab, B:43:0x006f, B:46:0x00c2), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006f A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001c, B:13:0x002e, B:16:0x004a, B:18:0x0055, B:20:0x005d, B:22:0x0082, B:24:0x008a, B:27:0x00af, B:30:0x00b7, B:31:0x00ba, B:32:0x00be, B:33:0x0093, B:35:0x0097, B:37:0x00a5, B:39:0x00ab, B:43:0x006f, B:46:0x00c2), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0049  */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.internal.measurement.zzjy] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb() {
        String str;
        boolean z;
        Uri uri;
        gc3 m3458a;
        Object obj;
        String zzb;
        Object zzb2;
        Supplier supplier;
        int i = f13859h.get();
        if (this.f13863d < i) {
            synchronized (this) {
                try {
                    if (this.f13863d < i) {
                        dc3 dc3Var = f13858g;
                        Optional absent = Optional.absent();
                        Object obj2 = null;
                        if (dc3Var != null && (supplier = dc3Var.f16345b) != null) {
                            absent = (Optional) ((Supplier) Preconditions.checkNotNull(supplier)).get();
                            if (absent.isPresent()) {
                                zzjo zzjoVar = (zzjo) absent.get();
                                zzkf zzkfVar = this.f13860a;
                                str = zzjoVar.zza(zzkfVar.f13852a, null, zzkfVar.f13854c, this.f13861b);
                                if (dc3Var == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                Preconditions.checkState(z, "Must call PhenotypeFlagInitializer.maybeInit() first");
                                zzkf zzkfVar2 = this.f13860a;
                                uri = zzkfVar2.f13852a;
                                if (uri == null) {
                                    if (zzjw.zza(dc3Var.f16344a, uri)) {
                                        m3458a = zzjm.zza(dc3Var.f16344a.getContentResolver(), uri, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzjy
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                zzki.zzc();
                                            }
                                        });
                                    } else {
                                        m3458a = null;
                                    }
                                } else {
                                    m3458a = zzkk.m3458a(dc3Var.f16344a, (String) Preconditions.checkNotNull(null), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzjy
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            zzki.zzc();
                                        }
                                    });
                                }
                                if (m3458a == null && (zzb2 = m3458a.zzb(this.f13861b)) != null) {
                                    obj = mo3457a(zzb2);
                                } else {
                                    obj = null;
                                }
                                if (obj == null) {
                                    if (!zzkfVar2.f13855d && (zzb = jc3.m5434a(dc3Var.f16344a).zzb(this.f13861b)) != null) {
                                        obj2 = mo3457a(zzb);
                                    }
                                    if (obj2 == null) {
                                        obj = this.f13862c;
                                    } else {
                                        obj = obj2;
                                    }
                                }
                                if (absent.isPresent()) {
                                    if (str == null) {
                                        obj = this.f13862c;
                                    } else {
                                        obj = mo3457a(str);
                                    }
                                }
                                this.f13864e = obj;
                                this.f13863d = i;
                            }
                        }
                        str = null;
                        if (dc3Var == null) {
                        }
                        Preconditions.checkState(z, "Must call PhenotypeFlagInitializer.maybeInit() first");
                        zzkf zzkfVar22 = this.f13860a;
                        uri = zzkfVar22.f13852a;
                        if (uri == null) {
                        }
                        if (m3458a == null) {
                        }
                        obj = null;
                        if (obj == null) {
                        }
                        if (absent.isPresent()) {
                        }
                        this.f13864e = obj;
                        this.f13863d = i;
                    }
                } finally {
                }
            }
        }
        return this.f13864e;
    }
}
