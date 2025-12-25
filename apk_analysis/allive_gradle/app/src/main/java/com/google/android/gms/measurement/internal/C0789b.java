package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzpq;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import p000.da3;
import p000.l93;

/* renamed from: com.google.android.gms.measurement.internal.b */
/* loaded from: classes.dex */
public final class C0789b {

    /* renamed from: a */
    public final String f13979a;

    /* renamed from: b */
    public final int f13980b;

    /* renamed from: c */
    public Boolean f13981c;

    /* renamed from: d */
    public Boolean f13982d;

    /* renamed from: e */
    public Long f13983e;

    /* renamed from: f */
    public Long f13984f;

    /* renamed from: g */
    public final /* synthetic */ int f13985g;

    /* renamed from: h */
    public final /* synthetic */ l93 f13986h;

    /* renamed from: i */
    public final com.google.android.gms.internal.measurement.zzmd f13987i;

    public C0789b(l93 l93Var, String str, int i, com.google.android.gms.internal.measurement.zzmd zzmdVar, int i2) {
        this.f13985g = i2;
        this.f13986h = l93Var;
        this.f13979a = str;
        this.f13980b = i;
        this.f13987i = zzmdVar;
    }

    /* renamed from: c */
    public static Boolean m3483c(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzfp zzfpVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzfpVar);
        if (zzfpVar.zzg()) {
            boolean z = true;
            if (zzfpVar.zzm() != 1) {
                if (zzfpVar.zzm() == 5) {
                    if (!zzfpVar.zzk() || !zzfpVar.zzj()) {
                        return null;
                    }
                } else if (!zzfpVar.zzh()) {
                    return null;
                }
                int zzm = zzfpVar.zzm();
                if (zzfpVar.zzm() == 5) {
                    if (zzqa.m3667a(zzfpVar.zze()) && zzqa.m3667a(zzfpVar.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzfpVar.zze());
                            bigDecimal4 = new BigDecimal(zzfpVar.zzd());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!zzqa.m3667a(zzfpVar.zzc())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(zzfpVar.zzc());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (zzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i = zzm - 1;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4 || bigDecimal3 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal3) < 0 || bigDecimal.compareTo(bigDecimal4) > 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                        if (bigDecimal2 == null) {
                            return null;
                        }
                        if (d != 0.0d) {
                            if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) >= 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                        if (bigDecimal.compareTo(bigDecimal2) != 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    if (bigDecimal.compareTo(bigDecimal2) <= 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (bigDecimal.compareTo(bigDecimal2) >= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    /* renamed from: d */
    public static Boolean m3484d(String str, com.google.android.gms.internal.measurement.zzfv zzfvVar, zzhe zzheVar) {
        String zzd;
        List zze;
        String str2;
        int i;
        Preconditions.checkNotNull(zzfvVar);
        if (str == null || !zzfvVar.zzi() || zzfvVar.zzj() == 1) {
            return null;
        }
        if (zzfvVar.zzj() == 7) {
            if (zzfvVar.zza() == 0) {
                return null;
            }
        } else if (!zzfvVar.zzh()) {
            return null;
        }
        int zzj = zzfvVar.zzj();
        boolean zzf = zzfvVar.zzf();
        if (!zzf && zzj != 2 && zzj != 7) {
            zzd = zzfvVar.zzd().toUpperCase(Locale.ENGLISH);
        } else {
            zzd = zzfvVar.zzd();
        }
        if (zzfvVar.zza() == 0) {
            zze = null;
        } else {
            zze = zzfvVar.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                Iterator it = zze.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
        }
        if (zzj == 2) {
            str2 = zzd;
        } else {
            str2 = null;
        }
        if (zzj == 7) {
            if (zze == null || zze.isEmpty()) {
                return null;
            }
        } else if (zzd == null) {
            return null;
        }
        if (!zzf && zzj != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzj - 1) {
            case 1:
                if (str2 == null) {
                    return null;
                }
                if (true != zzf) {
                    i = 66;
                } else {
                    i = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str2, i).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzheVar == null) {
                        return null;
                    }
                    zzheVar.zzk().zzb("Invalid regular expression in REGEXP audience filter. expression", str2);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(zzd));
            case 3:
                return Boolean.valueOf(str.endsWith(zzd));
            case 4:
                return Boolean.valueOf(str.contains(zzd));
            case 5:
                return Boolean.valueOf(str.equals(zzd));
            case 6:
                if (zze == null) {
                    return null;
                }
                return Boolean.valueOf(zze.contains(str));
            default:
                return null;
        }
    }

    /* renamed from: e */
    public static Boolean m3485e(long j, com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        try {
            return m3483c(new BigDecimal(j), zzfpVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static Boolean m3486f(Boolean bool, boolean z) {
        boolean z2;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0406 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03fe  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m3487a(Long l, Long l2, zzhm zzhmVar, long j, da3 da3Var, boolean z) {
        long j2;
        Integer num;
        boolean z2;
        Boolean bool;
        boolean z3;
        Boolean bool2;
        Boolean m3483c;
        Long l3;
        Double d;
        Object obj;
        Integer num2;
        Integer num3;
        zzpq.zzb();
        l93 l93Var = this.f13986h;
        zzio zzioVar = l93Var.zzu;
        zzam zzf = zzioVar.zzf();
        zzgg zzggVar = zzgi.zzaE;
        String str = this.f13979a;
        boolean zzx = zzf.zzx(str, zzggVar);
        com.google.android.gms.internal.measurement.zzfj zzfjVar = (com.google.android.gms.internal.measurement.zzfj) this.f13987i;
        if (zzfjVar.zzn()) {
            j2 = da3Var.f16318e;
        } else {
            j2 = j;
        }
        boolean isLoggable = Log.isLoggable(zzioVar.zzaW().zzr(), 2);
        int i = this.f13980b;
        if (isLoggable) {
            zzhc zzj = zzioVar.zzaW().zzj();
            Integer valueOf = Integer.valueOf(i);
            if (zzfjVar.zzp()) {
                num3 = Integer.valueOf(zzfjVar.zzb());
            } else {
                num3 = null;
            }
            zzj.zzd("Evaluating filter. audience, filter, event", valueOf, num3, zzioVar.zzj().zzd(zzfjVar.zzg()));
            zzhc zzj2 = zzioVar.zzaW().zzj();
            zzqa zzA = l93Var.zzg.zzA();
            zzA.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append("\nevent_filter {\n");
            if (zzfjVar.zzp()) {
                zzqa.m3678o(sb, 0, "filter_id", Integer.valueOf(zzfjVar.zzb()));
            }
            zzqa.m3678o(sb, 0, "event_name", zzA.zzu.zzj().zzd(zzfjVar.zzg()));
            String m3675l = zzqa.m3675l(zzfjVar.zzk(), zzfjVar.zzm(), zzfjVar.zzn());
            if (!m3675l.isEmpty()) {
                zzqa.m3678o(sb, 0, "filter_type", m3675l);
            }
            if (zzfjVar.zzo()) {
                zzqa.m3679p(sb, 1, "event_count_filter", zzfjVar.zzf());
            }
            if (zzfjVar.zza() > 0) {
                sb.append("  filters {\n");
                Iterator it = zzfjVar.zzh().iterator();
                while (it.hasNext()) {
                    zzA.m3690i(sb, 2, (com.google.android.gms.internal.measurement.zzfl) it.next());
                }
            }
            zzqa.m3673j(sb, 1);
            sb.append("}\n}\n");
            zzj2.zzb("Filter definition", sb.toString());
        }
        if (zzfjVar.zzp() && zzfjVar.zzb() <= 256) {
            boolean zzk = zzfjVar.zzk();
            boolean zzm = zzfjVar.zzm();
            boolean zzn = zzfjVar.zzn();
            if (zzk || zzm || zzn) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && !z2) {
                zzhc zzj3 = zzioVar.zzaW().zzj();
                Integer valueOf2 = Integer.valueOf(i);
                if (zzfjVar.zzp()) {
                    num2 = Integer.valueOf(zzfjVar.zzb());
                } else {
                    num2 = null;
                }
                zzj3.zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf2, num2);
                return true;
            }
            String zzh = zzhmVar.zzh();
            if (zzfjVar.zzo()) {
                Boolean m3485e = m3485e(j2, zzfjVar.zzf());
                if (m3485e != null) {
                    if (!m3485e.booleanValue()) {
                        bool = Boolean.FALSE;
                        zzhc zzj4 = zzioVar.zzaW().zzj();
                        if (bool == null) {
                            obj = "null";
                        } else {
                            obj = bool;
                        }
                        zzj4.zzb("Event filter result", obj);
                        if (bool == null) {
                            return false;
                        }
                        Boolean bool3 = Boolean.TRUE;
                        this.f13981c = bool3;
                        if (!bool.booleanValue()) {
                            return true;
                        }
                        this.f13982d = bool3;
                        if (z2 && zzhmVar.zzu()) {
                            Long valueOf3 = Long.valueOf(zzhmVar.zzd());
                            if (zzfjVar.zzm()) {
                                if (zzx && zzfjVar.zzo()) {
                                    valueOf3 = l;
                                }
                                this.f13984f = valueOf3;
                            } else {
                                if (zzx && zzfjVar.zzo()) {
                                    valueOf3 = l2;
                                }
                                this.f13983e = valueOf3;
                            }
                        }
                        return true;
                    }
                }
                bool = null;
                zzhc zzj42 = zzioVar.zzaW().zzj();
                if (bool == null) {
                }
                zzj42.zzb("Event filter result", obj);
                if (bool == null) {
                }
            }
            HashSet hashSet = new HashSet();
            Iterator it2 = zzfjVar.zzh().iterator();
            while (true) {
                if (it2.hasNext()) {
                    com.google.android.gms.internal.measurement.zzfl zzflVar = (com.google.android.gms.internal.measurement.zzfl) it2.next();
                    if (zzflVar.zze().isEmpty()) {
                        zzioVar.zzaW().zzk().zzb("null or empty param name in filter. event", zzioVar.zzj().zzd(zzh));
                        break;
                    }
                    hashSet.add(zzflVar.zze());
                } else {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator it3 = zzhmVar.zzi().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it3.next();
                            if (hashSet.contains(zzhqVar.zzg())) {
                                if (zzhqVar.zzw()) {
                                    String zzg = zzhqVar.zzg();
                                    if (zzhqVar.zzw()) {
                                        l3 = Long.valueOf(zzhqVar.zzd());
                                    } else {
                                        l3 = null;
                                    }
                                    arrayMap.put(zzg, l3);
                                } else if (zzhqVar.zzu()) {
                                    String zzg2 = zzhqVar.zzg();
                                    if (zzhqVar.zzu()) {
                                        d = Double.valueOf(zzhqVar.zza());
                                    } else {
                                        d = null;
                                    }
                                    arrayMap.put(zzg2, d);
                                } else if (zzhqVar.zzy()) {
                                    arrayMap.put(zzhqVar.zzg(), zzhqVar.zzh());
                                } else {
                                    zzioVar.zzaW().zzk().zzc("Unknown value for param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zzhqVar.zzg()));
                                    break;
                                }
                            }
                        } else {
                            Iterator it4 = zzfjVar.zzh().iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzfl zzflVar2 = (com.google.android.gms.internal.measurement.zzfl) it4.next();
                                    if (zzflVar2.zzh() && zzflVar2.zzg()) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    String zze = zzflVar2.zze();
                                    if (zze.isEmpty()) {
                                        zzioVar.zzaW().zzk().zzb("Event has empty param name. event", zzioVar.zzj().zzd(zzh));
                                        break;
                                    }
                                    V v = arrayMap.get(zze);
                                    if (v instanceof Long) {
                                        if (!zzflVar2.zzi()) {
                                            zzioVar.zzaW().zzk().zzc("No number filter for long param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                            break;
                                        }
                                        Boolean m3485e2 = m3485e(((Long) v).longValue(), zzflVar2.zzc());
                                        if (m3485e2 == null) {
                                            break;
                                        }
                                        if (m3485e2.booleanValue() == z3) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (v instanceof Double) {
                                        if (!zzflVar2.zzi()) {
                                            zzioVar.zzaW().zzk().zzc("No number filter for double param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                            break;
                                        }
                                        double doubleValue = ((Double) v).doubleValue();
                                        try {
                                            bool2 = m3483c(new BigDecimal(doubleValue), zzflVar2.zzc(), Math.ulp(doubleValue));
                                        } catch (NumberFormatException unused) {
                                            bool2 = null;
                                        }
                                        if (bool2 == null) {
                                            break;
                                        }
                                        if (bool2.booleanValue() == z3) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (v instanceof String) {
                                        if (zzflVar2.zzk()) {
                                            m3483c = m3484d((String) v, zzflVar2.zzd(), zzioVar.zzaW());
                                        } else if (zzflVar2.zzi()) {
                                            String str2 = (String) v;
                                            if (zzqa.m3667a(str2)) {
                                                com.google.android.gms.internal.measurement.zzfp zzc = zzflVar2.zzc();
                                                if (zzqa.m3667a(str2)) {
                                                    try {
                                                        m3483c = m3483c(new BigDecimal(str2), zzc, 0.0d);
                                                    } catch (NumberFormatException unused2) {
                                                    }
                                                }
                                                m3483c = null;
                                            } else {
                                                zzioVar.zzaW().zzk().zzc("Invalid param value for number filter. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                                break;
                                            }
                                        } else {
                                            zzioVar.zzaW().zzk().zzc("No filter for String param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                            break;
                                        }
                                        if (m3483c == null) {
                                            break;
                                        }
                                        if (m3483c.booleanValue() == z3) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (v == 0) {
                                        zzioVar.zzaW().zzj().zzc("Missing param for filter. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                        bool = Boolean.FALSE;
                                    } else {
                                        zzioVar.zzaW().zzk().zzc("Unknown param type. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                    }
                                } else {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            zzhc zzj422 = zzioVar.zzaW().zzj();
            if (bool == null) {
            }
            zzj422.zzb("Event filter result", obj);
            if (bool == null) {
            }
        } else {
            zzhc zzk2 = zzioVar.zzaW().zzk();
            Object zzn2 = zzhe.zzn(str);
            if (zzfjVar.zzp()) {
                num = Integer.valueOf(zzfjVar.zzb());
            } else {
                num = null;
            }
            zzk2.zzc("Invalid event filter ID. appId, id", zzn2, String.valueOf(num));
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public boolean m3488b(Long l, Long l2, com.google.android.gms.internal.measurement.zzio zzioVar, boolean z) {
        Object[] objArr;
        Object obj;
        zzpq.zzb();
        zzio zzioVar2 = this.f13986h.zzu;
        boolean zzx = zzioVar2.zzf().zzx(this.f13979a, zzgi.zzaC);
        com.google.android.gms.internal.measurement.zzfr zzfrVar = (com.google.android.gms.internal.measurement.zzfr) this.f13987i;
        boolean zzg = zzfrVar.zzg();
        boolean zzh = zzfrVar.zzh();
        boolean zzi = zzfrVar.zzi();
        if (zzg || zzh || zzi) {
            objArr = true;
        } else {
            objArr = false;
        }
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Integer num = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && objArr == false) {
            zzhc zzj = zzioVar2.zzaW().zzj();
            Integer valueOf = Integer.valueOf(this.f13980b);
            if (zzfrVar.zzj()) {
                num = Integer.valueOf(zzfrVar.zza());
            }
            zzj.zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf, num);
            return true;
        }
        com.google.android.gms.internal.measurement.zzfl zzb = zzfrVar.zzb();
        boolean zzg2 = zzb.zzg();
        if (zzioVar.zzt()) {
            if (!zzb.zzi()) {
                zzioVar2.zzaW().zzk().zzb("No number filter for long property. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
            } else {
                bool = m3486f(m3485e(zzioVar.zzc(), zzb.zzc()), zzg2);
            }
        } else if (zzioVar.zzr()) {
            if (!zzb.zzi()) {
                zzioVar2.zzaW().zzk().zzb("No number filter for double property. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
            } else {
                double zza = zzioVar.zza();
                try {
                    bool3 = m3483c(new BigDecimal(zza), zzb.zzc(), Math.ulp(zza));
                } catch (NumberFormatException unused) {
                }
                bool = m3486f(bool3, zzg2);
            }
        } else if (zzioVar.zzv()) {
            if (!zzb.zzk()) {
                if (!zzb.zzi()) {
                    zzioVar2.zzaW().zzk().zzb("No string or number filter defined. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
                } else if (zzqa.m3667a(zzioVar.zzh())) {
                    String zzh2 = zzioVar.zzh();
                    com.google.android.gms.internal.measurement.zzfp zzc = zzb.zzc();
                    if (zzqa.m3667a(zzh2)) {
                        try {
                            bool2 = m3483c(new BigDecimal(zzh2), zzc, 0.0d);
                        } catch (NumberFormatException unused2) {
                        }
                    }
                    bool = m3486f(bool2, zzg2);
                } else {
                    zzioVar2.zzaW().zzk().zzc("Invalid user property value for Numeric number filter. property, value", zzioVar2.zzj().zzf(zzioVar.zzg()), zzioVar.zzh());
                }
            } else {
                bool = m3486f(m3484d(zzioVar.zzh(), zzb.zzd(), zzioVar2.zzaW()), zzg2);
            }
        } else {
            zzioVar2.zzaW().zzk().zzb("User property has no value, property", zzioVar2.zzj().zzf(zzioVar.zzg()));
        }
        zzhc zzj2 = zzioVar2.zzaW().zzj();
        if (bool == null) {
            obj = "null";
        } else {
            obj = bool;
        }
        zzj2.zzb("Property filter result", obj);
        if (bool == null) {
            return false;
        }
        this.f13981c = Boolean.TRUE;
        if (zzi && !bool.booleanValue()) {
            return true;
        }
        if (!z || zzfrVar.zzg()) {
            this.f13982d = bool;
        }
        if (bool.booleanValue() && objArr != false && zzioVar.zzu()) {
            long zzd = zzioVar.zzd();
            if (l != null) {
                zzd = l.longValue();
            }
            if (zzx && zzfrVar.zzg() && !zzfrVar.zzh() && l2 != null) {
                zzd = l2.longValue();
            }
            if (zzfrVar.zzh()) {
                this.f13984f = Long.valueOf(zzd);
            } else {
                this.f13983e = Long.valueOf(zzd);
            }
        }
        return true;
    }
}
