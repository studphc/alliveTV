package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p000.fc3;
import p000.qb3;

/* loaded from: classes.dex */
public final class zzhe extends fc3 {

    /* renamed from: b */
    public char f14187b;

    /* renamed from: c */
    public long f14188c;

    /* renamed from: d */
    public String f14189d;

    /* renamed from: e */
    public final zzhc f14190e;

    /* renamed from: f */
    public final zzhc f14191f;

    /* renamed from: g */
    public final zzhc f14192g;

    /* renamed from: h */
    public final zzhc f14193h;

    /* renamed from: i */
    public final zzhc f14194i;

    /* renamed from: j */
    public final zzhc f14195j;

    /* renamed from: k */
    public final zzhc f14196k;

    /* renamed from: l */
    public final zzhc f14197l;

    /* renamed from: m */
    public final zzhc f14198m;

    public zzhe(zzio zzioVar) {
        super(zzioVar);
        this.f14187b = (char) 0;
        this.f14188c = -1L;
        this.f14190e = new zzhc(this, 6, false, false);
        this.f14191f = new zzhc(this, 6, true, false);
        this.f14192g = new zzhc(this, 6, false, true);
        this.f14193h = new zzhc(this, 5, false, false);
        this.f14194i = new zzhc(this, 5, true, false);
        this.f14195j = new zzhc(this, 5, false, true);
        this.f14196k = new zzhc(this, 4, false, false);
        this.f14197l = new zzhc(this, 3, false, false);
        this.f14198m = new zzhc(this, 2, false, false);
    }

    /* renamed from: a */
    public static String m3532a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String m3533b = m3533b(obj, z);
        String m3533b2 = m3533b(obj2, z);
        String m3533b3 = m3533b(obj3, z);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(m3533b)) {
            sb.append(str2);
            sb.append(m3533b);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(m3533b2)) {
            sb.append(str2);
            sb.append(m3533b2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(m3533b3)) {
            sb.append(str3);
            sb.append(m3533b3);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m3533b(Object obj, boolean z) {
        String th;
        int lastIndexOf;
        String substring;
        String className;
        int lastIndexOf2;
        String substring2;
        String str = "";
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder();
            if (charAt == '-') {
                str = "-";
            }
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            if (z) {
                th = th2.getClass().getName();
            } else {
                th = th2.toString();
            }
            StringBuilder sb2 = new StringBuilder(th);
            String canonicalName = zzio.class.getCanonicalName();
            if (TextUtils.isEmpty(canonicalName) || (lastIndexOf = canonicalName.lastIndexOf(46)) == -1) {
                substring = "";
            } else {
                substring = canonicalName.substring(0, lastIndexOf);
            }
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    if (TextUtils.isEmpty(className) || (lastIndexOf2 = className.lastIndexOf(46)) == -1) {
                        substring2 = "";
                    } else {
                        substring2 = className.substring(0, lastIndexOf2);
                    }
                    if (substring2.equals(substring)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                }
                i++;
            }
            return sb2.toString();
        }
        if (obj instanceof qb3) {
            return ((qb3) obj).f25510a;
        }
        if (z) {
            return "-";
        }
        return obj.toString();
    }

    public static Object zzn(String str) {
        if (str == null) {
            return null;
        }
        return new qb3(str);
    }

    @Override // p000.fc3
    public final boolean zzc() {
        return false;
    }

    public final zzhc zzd() {
        return this.f14197l;
    }

    public final zzhc zze() {
        return this.f14190e;
    }

    public final zzhc zzf() {
        return this.f14192g;
    }

    public final zzhc zzh() {
        return this.f14191f;
    }

    public final zzhc zzi() {
        return this.f14196k;
    }

    public final zzhc zzj() {
        return this.f14198m;
    }

    public final zzhc zzk() {
        return this.f14193h;
    }

    public final zzhc zzl() {
        return this.f14195j;
    }

    public final zzhc zzm() {
        return this.f14194i;
    }

    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    @VisibleForTesting
    public final String zzr() {
        String str;
        synchronized (this) {
            try {
                if (this.f14189d == null) {
                    zzio zzioVar = this.zzu;
                    if (zzioVar.zzz() != null) {
                        this.f14189d = zzioVar.zzz();
                    } else {
                        this.zzu.zzf().zzu.zzaV();
                        this.f14189d = "FA";
                    }
                }
                Preconditions.checkNotNull(this.f14189d);
                str = this.f14189d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void zzu(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzr(), i)) {
            Log.println(i, zzr(), m3532a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzil zzilVar = this.zzu.f14263j;
            if (zzilVar == null) {
                Log.println(6, zzr(), "Scheduler not set. Not logging error/warn");
            } else {
                if (!zzilVar.f17212a) {
                    Log.println(6, zzr(), "Scheduler not initialized. Not logging error/warn");
                    return;
                }
                if (i >= 9) {
                    i = 8;
                }
                zzilVar.zzq(new RunnableC0793d(this, i, str, obj, obj2, obj3));
            }
        }
    }
}
