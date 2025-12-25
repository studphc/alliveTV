package p000;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjp;
import com.google.android.gms.internal.measurement.zzjq;
import com.google.common.base.Preconditions;
import p000.jc3;

/* loaded from: classes.dex */
public final class jc3 implements gc3 {

    /* renamed from: d */
    public static jc3 f20460d;

    /* renamed from: a */
    public final Context f20461a;

    /* renamed from: b */
    public final ic3 f20462b;

    /* renamed from: c */
    public boolean f20463c;

    public jc3() {
        this.f20463c = false;
        this.f20461a = null;
        this.f20462b = null;
    }

    /* renamed from: a */
    public static jc3 m5434a(Context context) {
        jc3 jc3Var;
        jc3 jc3Var2;
        synchronized (jc3.class) {
            try {
                if (f20460d == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        jc3Var2 = new jc3(context);
                    } else {
                        jc3Var2 = new jc3();
                    }
                    f20460d = jc3Var2;
                }
                jc3 jc3Var3 = f20460d;
                if (jc3Var3 != null && jc3Var3.f20462b != null && !jc3Var3.f20463c) {
                    try {
                        context.getContentResolver().registerContentObserver(zzjc.zza, true, f20460d.f20462b);
                        ((jc3) Preconditions.checkNotNull(f20460d)).f20463c = true;
                    } catch (SecurityException e) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e);
                    }
                }
                jc3Var = (jc3) Preconditions.checkNotNull(f20460d);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jc3Var;
    }

    /* renamed from: c */
    public static synchronized void m5435c() {
        Context context;
        synchronized (jc3.class) {
            try {
                jc3 jc3Var = f20460d;
                if (jc3Var != null && (context = jc3Var.f20461a) != null && jc3Var.f20462b != null && jc3Var.f20463c) {
                    context.getContentResolver().unregisterContentObserver(f20460d.f20462b);
                }
                f20460d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.gc3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        Context context = this.f20461a;
        if (context != null && !zzji.zza(context)) {
            try {
                return (String) zzjp.zza(new zzjq() { // from class: com.google.android.gms.internal.measurement.zzjs
                    @Override // com.google.android.gms.internal.measurement.zzjq
                    public final Object zza() {
                        jc3 jc3Var = jc3.this;
                        return zzjb.zza(((Context) Preconditions.checkNotNull(jc3Var.f20461a)).getContentResolver(), str, null);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [ic3, android.database.ContentObserver] */
    public jc3(Context context) {
        this.f20463c = false;
        this.f20461a = context;
        this.f20462b = new ContentObserver(null);
    }
}
