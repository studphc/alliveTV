package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzlp;
import com.google.android.gms.internal.measurement.zzng;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import p000.AbstractC1726qj;
import p000.re3;

/* loaded from: classes.dex */
public final class zzqa extends re3 {
    /* renamed from: B */
    public static ArrayList m3664B(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r4 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r3 = (android.os.Parcelable[]) r3;
        r4 = r3.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r7 >= r4) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r8 = r3[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r5.add(m3665C((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        r0.put(r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if ((r3 instanceof java.util.ArrayList) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        r3 = (java.util.ArrayList) r3;
        r4 = r3.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        if (r7 >= r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        r8 = r3.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r5.add(m3665C((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        if ((r3 instanceof android.os.Bundle) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        r5.add(m3665C((android.os.Bundle) r3, false));
     */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap m3665C(Bundle bundle, boolean z) {
        HashMap hashMap = new HashMap();
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Object obj = bundle.get(next);
            boolean z2 = obj instanceof Parcelable[];
            if (!z2 && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: F */
    public static boolean m3666F(int i, List list) {
        if (i < list.size() * 64) {
            if (((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3667a(String str) {
        if (str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static Bundle[] m3668c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it.next();
            if (zzhqVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhq zzhqVar2 : zzhqVar.zzi()) {
                    if (zzhqVar2.zzy()) {
                        bundle.putString(zzhqVar2.zzg(), zzhqVar2.zzh());
                    } else if (zzhqVar2.zzw()) {
                        bundle.putLong(zzhqVar2.zzg(), zzhqVar2.zzd());
                    } else if (zzhqVar2.zzu()) {
                        bundle.putDouble(zzhqVar2.zzg(), zzhqVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* renamed from: d */
    public static final void m3669d(zzhl zzhlVar, String str, Long l) {
        List zzp = zzhlVar.zzp();
        int i = 0;
        while (true) {
            if (i < zzp.size()) {
                if (str.equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i)).zzg())) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = -1;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
        zze.zzj(str);
        zze.zzi(l.longValue());
        if (i >= 0) {
            zzhlVar.zzj(i, zze);
        } else {
            zzhlVar.zze(zze);
        }
    }

    /* renamed from: e */
    public static final Bundle m3670e(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it.next();
            String zzg = zzhqVar.zzg();
            if (zzhqVar.zzu()) {
                bundle.putDouble(zzg, zzhqVar.zza());
            } else if (zzhqVar.zzv()) {
                bundle.putFloat(zzg, zzhqVar.zzb());
            } else if (zzhqVar.zzy()) {
                bundle.putString(zzg, zzhqVar.zzh());
            } else if (zzhqVar.zzw()) {
                bundle.putLong(zzg, zzhqVar.zzd());
            }
        }
        return bundle;
    }

    /* renamed from: f */
    public static final com.google.android.gms.internal.measurement.zzhq m3671f(zzhm zzhmVar, String str) {
        for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zzhmVar.zzi()) {
            if (zzhqVar.zzg().equals(str)) {
                return zzhqVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Bundle[], java.io.Serializable] */
    /* renamed from: g */
    public static final Serializable m3672g(zzhm zzhmVar, String str) {
        com.google.android.gms.internal.measurement.zzhq m3671f = m3671f(zzhmVar, str);
        if (m3671f != null) {
            if (m3671f.zzy()) {
                return m3671f.zzh();
            }
            if (m3671f.zzw()) {
                return Long.valueOf(m3671f.zzd());
            }
            if (m3671f.zzu()) {
                return Double.valueOf(m3671f.zza());
            }
            if (m3671f.zzc() > 0) {
                return m3668c(m3671f.zzi());
            }
            return null;
        }
        return null;
    }

    /* renamed from: j */
    public static final void m3673j(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    /* renamed from: k */
    public static final void m3674k(Uri.Builder builder, String str, String str2, Set set) {
        if (!set.contains(str) && !TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    /* renamed from: l */
    public static final String m3675l(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* renamed from: m */
    public static final void m3676m(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] split = str.split(",");
            String str2 = split[0];
            String str3 = split[split.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                m3674k(builder, str3, string, set);
            }
        }
    }

    /* renamed from: n */
    public static final void m3677n(StringBuilder sb, String str, zzic zzicVar) {
        Integer num;
        Integer num2;
        Long l;
        if (zzicVar == null) {
            return;
        }
        m3673j(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzicVar.zzb() != 0) {
            m3673j(sb, 4);
            sb.append("results: ");
            int i = 0;
            for (Long l2 : zzicVar.zzi()) {
                int i2 = i + 1;
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i = i2;
            }
            sb.append('\n');
        }
        if (zzicVar.zzd() != 0) {
            m3673j(sb, 4);
            sb.append("status: ");
            int i3 = 0;
            for (Long l3 : zzicVar.zzk()) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(l3);
                i3 = i4;
            }
            sb.append('\n');
        }
        if (zzicVar.zza() != 0) {
            m3673j(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i5 = 0;
            for (com.google.android.gms.internal.measurement.zzhk zzhkVar : zzicVar.zzh()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                if (zzhkVar.zzh()) {
                    num2 = Integer.valueOf(zzhkVar.zza());
                } else {
                    num2 = null;
                }
                sb.append(num2);
                sb.append(":");
                if (zzhkVar.zzg()) {
                    l = Long.valueOf(zzhkVar.zzb());
                } else {
                    l = null;
                }
                sb.append(l);
                i5 = i6;
            }
            sb.append("}\n");
        }
        if (zzicVar.zzc() != 0) {
            m3673j(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i7 = 0;
            for (zzie zzieVar : zzicVar.zzj()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                if (zzieVar.zzi()) {
                    num = Integer.valueOf(zzieVar.zzb());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(": [");
                Iterator it = zzieVar.zzf().iterator();
                int i9 = 0;
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    int i10 = i9 + 1;
                    if (i9 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i9 = i10;
                }
                sb.append("]");
                i7 = i8;
            }
            sb.append("}\n");
        }
        m3673j(sb, 3);
        sb.append("}\n");
    }

    /* renamed from: o */
    public static final void m3678o(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        m3673j(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    /* renamed from: p */
    public static final void m3679p(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        String str2;
        if (zzfpVar == null) {
            return;
        }
        m3673j(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzfpVar.zzg()) {
            int zzm = zzfpVar.zzm();
            if (zzm != 1) {
                if (zzm != 2) {
                    if (zzm != 3) {
                        if (zzm != 4) {
                            str2 = "BETWEEN";
                        } else {
                            str2 = "EQUAL";
                        }
                    } else {
                        str2 = "GREATER_THAN";
                    }
                } else {
                    str2 = "LESS_THAN";
                }
            } else {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            }
            m3678o(sb, i, "comparison_type", str2);
        }
        if (zzfpVar.zzi()) {
            m3678o(sb, i, "match_as_float", Boolean.valueOf(zzfpVar.zzf()));
        }
        if (zzfpVar.zzh()) {
            m3678o(sb, i, "comparison_value", zzfpVar.zzc());
        }
        if (zzfpVar.zzk()) {
            m3678o(sb, i, "min_comparison_value", zzfpVar.zze());
        }
        if (zzfpVar.zzj()) {
            m3678o(sb, i, "max_comparison_value", zzfpVar.zzd());
        }
        m3673j(sb, i);
        sb.append("}\n");
    }

    /* renamed from: q */
    public static int m3680q(com.google.android.gms.internal.measurement.zzhw zzhwVar, String str) {
        for (int i = 0; i < zzhwVar.zzd(); i++) {
            if (str.equals(zzhwVar.zzaE(i).zzg())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: s */
    public static Bundle m3681s(boolean z, Map map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof ArrayList) {
                if (z) {
                    ArrayList arrayList = (ArrayList) obj;
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList2.add(m3681s(false, (Map) arrayList.get(i)));
                    }
                    bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
                }
            } else {
                bundle.putString(str, obj.toString());
            }
        }
        return bundle;
    }

    /* renamed from: u */
    public static zzbh m3682u(zzaa zzaaVar) {
        String str;
        Object obj;
        Bundle m3681s = m3681s(true, zzaaVar.zzf());
        if (m3681s.containsKey("_o") && (obj = m3681s.get("_o")) != null) {
            str = obj.toString();
        } else {
            str = "app";
        }
        String str2 = str;
        String zzb = zzjy.zzb(zzaaVar.zze());
        if (zzb == null) {
            zzb = zzaaVar.zze();
        }
        return new zzbh(zzb, new zzbf(m3681s), str2, zzaaVar.zza());
    }

    /* renamed from: x */
    public static zzng m3683x(com.google.android.gms.internal.measurement.zzlz zzlzVar, byte[] bArr) {
        zzlp zza = zzlp.zza();
        if (zza != null) {
            return zzlzVar.zzaV(bArr, zza);
        }
        return zzlzVar.zzaU(bArr);
    }

    /* renamed from: A */
    public final List m3684A(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzu.zzaW().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzu.zzaW().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    /* renamed from: D */
    public final void m3685D(com.google.android.gms.internal.measurement.zzhp zzhpVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzhpVar.zzg();
        zzhpVar.zze();
        zzhpVar.zzd();
        zzhpVar.zzf();
        if (obj instanceof String) {
            zzhpVar.zzk((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzhpVar.zzi(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzhpVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                    for (String str : bundle.keySet()) {
                        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                        zze2.zzj(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zze2.zzi(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zze2.zzk((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zze2.zzh(((Double) obj2).doubleValue());
                        }
                        zze.zzc(zze2);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                    }
                }
            }
            zzhpVar.zzb(arrayList);
            return;
        }
        this.zzu.zzaW().zze().zzb("Ignoring invalid (type) event param value", obj);
    }

    /* renamed from: E */
    public final void m3686E(zzin zzinVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzinVar.zzc();
        zzinVar.zzb();
        zzinVar.zza();
        if (obj instanceof String) {
            zzinVar.zzh((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzinVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzinVar.zzd(((Double) obj).doubleValue());
        } else {
            this.zzu.zzaW().zze().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* renamed from: G */
    public final boolean m3687G(long j, long j2) {
        if (j != 0 && j2 > 0 && Math.abs(this.zzu.zzaU().currentTimeMillis() - j) <= j2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public final byte[] m3688b(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzu.zzaW().zze().zzb("Failed to gzip content", e);
            throw e;
        }
    }

    /* renamed from: h */
    public final void m3689h(StringBuilder sb, int i, List list) {
        String str;
        String str2;
        Long l;
        if (list != null) {
            int i2 = i + 1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it.next();
                if (zzhqVar != null) {
                    m3673j(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    if (zzhqVar.zzx()) {
                        str = this.zzu.zzj().zze(zzhqVar.zzg());
                    } else {
                        str = null;
                    }
                    m3678o(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, str);
                    if (zzhqVar.zzy()) {
                        str2 = zzhqVar.zzh();
                    } else {
                        str2 = null;
                    }
                    m3678o(sb, i2, "string_value", str2);
                    if (zzhqVar.zzw()) {
                        l = Long.valueOf(zzhqVar.zzd());
                    } else {
                        l = null;
                    }
                    m3678o(sb, i2, "int_value", l);
                    if (zzhqVar.zzu()) {
                        d = Double.valueOf(zzhqVar.zza());
                    }
                    m3678o(sb, i2, "double_value", d);
                    if (zzhqVar.zzc() > 0) {
                        m3689h(sb, i2, zzhqVar.zzi());
                    }
                    m3673j(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    /* renamed from: i */
    public final void m3690i(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        String str;
        if (zzflVar == null) {
            return;
        }
        m3673j(sb, i);
        sb.append("filter {\n");
        if (zzflVar.zzh()) {
            m3678o(sb, i, "complement", Boolean.valueOf(zzflVar.zzg()));
        }
        if (zzflVar.zzj()) {
            m3678o(sb, i, "param_name", this.zzu.zzj().zze(zzflVar.zze()));
        }
        if (zzflVar.zzk()) {
            int i2 = i + 1;
            com.google.android.gms.internal.measurement.zzfv zzd = zzflVar.zzd();
            if (zzd != null) {
                m3673j(sb, i2);
                sb.append("string_filter {\n");
                if (zzd.zzi()) {
                    switch (zzd.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    m3678o(sb, i2, "match_type", str);
                }
                if (zzd.zzh()) {
                    m3678o(sb, i2, "expression", zzd.zzd());
                }
                if (zzd.zzg()) {
                    m3678o(sb, i2, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                }
                if (zzd.zza() > 0) {
                    m3673j(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzd.zze()) {
                        m3673j(sb, i + 3);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                m3673j(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzflVar.zzi()) {
            m3679p(sb, i + 1, "number_filter", zzflVar.zzc());
        }
        m3673j(sb, i);
        sb.append("}\n");
    }

    /* renamed from: r */
    public final long m3691r(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzio zzioVar = this.zzu;
        zzioVar.zzw().zzg();
        MessageDigest m3707f = zzqf.m3707f();
        if (m3707f == null) {
            AbstractC1726qj.m7039D(zzioVar, "Failed to get MD5");
            return 0L;
        }
        return zzqf.m3706R(m3707f.digest(bArr));
    }

    /* renamed from: t */
    public final Parcelable m3692t(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(obtain);
            } catch (SafeParcelReader.ParseException unused) {
                this.zzu.zzaW().zze().zza("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            obtain.recycle();
        }
    }

    /* renamed from: v */
    public final zzov m3693v(String str, com.google.android.gms.internal.measurement.zzhw zzhwVar, zzhl zzhlVar, String str2) {
        int indexOf;
        zzqr.zzb();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(str, zzgi.zzaV)) {
            long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
            String[] split = zzioVar.zzf().zzr(str, zzgi.zzat).split(",");
            HashSet hashSet = new HashSet(split.length);
            for (String str3 : split) {
                Objects.requireNonNull(str3);
                if (!hashSet.add(str3)) {
                    throw new IllegalArgumentException("duplicate element: ".concat(str3));
                }
            }
            Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
            zzpv zzpvVar = this.zzg;
            zzpi zzy = zzpvVar.zzy();
            String m3547l = zzy.zzg.zzr().m3547l(str);
            Uri.Builder builder = new Uri.Builder();
            zzio zzioVar2 = zzy.zzu;
            builder.scheme(zzioVar2.zzf().zzr(str, zzgi.zzam));
            if (!TextUtils.isEmpty(m3547l)) {
                builder.authority(m3547l + "." + zzioVar2.zzf().zzr(str, zzgi.zzan));
            } else {
                builder.authority(zzioVar2.zzf().zzr(str, zzgi.zzan));
            }
            builder.path(zzioVar2.zzf().zzr(str, zzgi.zzao));
            m3674k(builder, "gmp_app_id", zzhwVar.zzaJ(), unmodifiableSet);
            zzioVar.zzf().zzj();
            m3674k(builder, "gmp_version", String.valueOf(119002L), unmodifiableSet);
            String zzaG = zzhwVar.zzaG();
            zzam zzf = zzioVar.zzf();
            zzgg zzggVar = zzgi.zzaY;
            if (zzf.zzx(str, zzggVar) && zzpvVar.zzr().m3538a(str)) {
                zzaG = "";
            }
            m3674k(builder, "app_instance_id", zzaG, unmodifiableSet);
            m3674k(builder, "rdid", zzhwVar.zzaL(), unmodifiableSet);
            m3674k(builder, "bundle_id", zzhwVar.zzaF(), unmodifiableSet);
            String zzo = zzhlVar.zzo();
            String zza = zzjy.zza(zzo);
            if (true != TextUtils.isEmpty(zza)) {
                zzo = zza;
            }
            m3674k(builder, "app_event_name", zzo, unmodifiableSet);
            m3674k(builder, "app_version", String.valueOf(zzhwVar.zzb()), unmodifiableSet);
            String zzaK = zzhwVar.zzaK();
            if (zzioVar.zzf().zzx(str, zzggVar) && zzpvVar.zzr().m3539b(str) && !TextUtils.isEmpty(zzaK) && (indexOf = zzaK.indexOf(".")) != -1) {
                zzaK = zzaK.substring(0, indexOf);
            }
            m3674k(builder, "os_version", zzaK, unmodifiableSet);
            m3674k(builder, "timestamp", String.valueOf(zzhlVar.zzc()), unmodifiableSet);
            boolean zzaP = zzhwVar.zzaP();
            String str4 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
            if (zzaP) {
                m3674k(builder, "lat", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, unmodifiableSet);
            }
            m3674k(builder, "privacy_sandbox_version", String.valueOf(zzhwVar.zza()), unmodifiableSet);
            m3674k(builder, "trigger_uri_source", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, unmodifiableSet);
            m3674k(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), unmodifiableSet);
            m3674k(builder, "request_uuid", str2, unmodifiableSet);
            List<com.google.android.gms.internal.measurement.zzhq> zzp = zzhlVar.zzp();
            Bundle bundle = new Bundle();
            for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zzp) {
                String zzg = zzhqVar.zzg();
                if (zzhqVar.zzu()) {
                    bundle.putString(zzg, String.valueOf(zzhqVar.zza()));
                } else if (zzhqVar.zzv()) {
                    bundle.putString(zzg, String.valueOf(zzhqVar.zzb()));
                } else if (zzhqVar.zzy()) {
                    bundle.putString(zzg, zzhqVar.zzh());
                } else if (zzhqVar.zzw()) {
                    bundle.putString(zzg, String.valueOf(zzhqVar.zzd()));
                }
            }
            m3676m(builder, zzioVar.zzf().zzr(str, zzgi.zzas).split("\\|"), bundle, unmodifiableSet);
            List<com.google.android.gms.internal.measurement.zzio> zzaN = zzhwVar.zzaN();
            Bundle bundle2 = new Bundle();
            for (com.google.android.gms.internal.measurement.zzio zzioVar3 : zzaN) {
                String zzg2 = zzioVar3.zzg();
                if (zzioVar3.zzr()) {
                    bundle2.putString(zzg2, String.valueOf(zzioVar3.zza()));
                } else if (zzioVar3.zzs()) {
                    bundle2.putString(zzg2, String.valueOf(zzioVar3.zzb()));
                } else if (zzioVar3.zzv()) {
                    bundle2.putString(zzg2, zzioVar3.zzh());
                } else if (zzioVar3.zzt()) {
                    bundle2.putString(zzg2, String.valueOf(zzioVar3.zzc()));
                }
            }
            m3676m(builder, zzioVar.zzf().zzr(str, zzgi.zzar).split("\\|"), bundle2, unmodifiableSet);
            if (true != zzhwVar.zzaO()) {
                str4 = "0";
            }
            m3674k(builder, "dma", str4, unmodifiableSet);
            if (!zzhwVar.zzaI().isEmpty()) {
                m3674k(builder, "dma_cps", zzhwVar.zzaI(), unmodifiableSet);
            }
            if (zzhwVar.zzaQ()) {
                com.google.android.gms.internal.measurement.zzhc zzg3 = zzhwVar.zzg();
                if (!zzg3.zzh().isEmpty()) {
                    m3674k(builder, "dl_gclid", zzg3.zzh(), unmodifiableSet);
                }
                if (!zzg3.zzg().isEmpty()) {
                    m3674k(builder, "dl_gbraid", zzg3.zzg(), unmodifiableSet);
                }
                if (!zzg3.zzf().isEmpty()) {
                    m3674k(builder, "dl_gs", zzg3.zzf(), unmodifiableSet);
                }
                if (zzg3.zza() > 0) {
                    m3674k(builder, "dl_ss_ts", String.valueOf(zzg3.zza()), unmodifiableSet);
                }
                if (!zzg3.zzk().isEmpty()) {
                    m3674k(builder, "mr_gclid", zzg3.zzk(), unmodifiableSet);
                }
                if (!zzg3.zzj().isEmpty()) {
                    m3674k(builder, "mr_gbraid", zzg3.zzj(), unmodifiableSet);
                }
                if (!zzg3.zzi().isEmpty()) {
                    m3674k(builder, "mr_gs", zzg3.zzi(), unmodifiableSet);
                }
                if (zzg3.zzb() > 0) {
                    m3674k(builder, "mr_click_ts", String.valueOf(zzg3.zzb()), unmodifiableSet);
                }
            }
            return new zzov(builder.build().toString(), currentTimeMillis, 1);
        }
        return null;
    }

    /* renamed from: w */
    public final zzhm m3694w(zzbc zzbcVar) {
        Bundle bundle;
        zzhl zze = zzhm.zze();
        zze.zzl(zzbcVar.f14146e);
        zzbf zzbfVar = zzbcVar.f14147f;
        Iterator<String> it = zzbfVar.f14148a.keySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            bundle = zzbfVar.f14148a;
            if (!hasNext) {
                break;
            }
            String next = it.next();
            com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
            zze2.zzj(next);
            Object obj = bundle.get(next);
            Preconditions.checkNotNull(obj);
            m3685D(zze2, obj);
            zze.zze(zze2);
        }
        String str = zzbcVar.f14144c;
        if (!TextUtils.isEmpty(str) && bundle.get("_o") == null) {
            com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
            zze3.zzj("_o");
            zze3.zzk(str);
            zze.zzf((com.google.android.gms.internal.measurement.zzhq) zze3.zzba());
        }
        return (zzhm) zze.zzba();
    }

    /* renamed from: y */
    public final String m3695y(com.google.android.gms.internal.measurement.zzhv zzhvVar) {
        Long l;
        Long l2;
        String str;
        String str2;
        zzhg zzx;
        if (zzhvVar == null) {
            return "";
        }
        StringBuilder m7064t = AbstractC1726qj.m7064t("\nbatch {\n");
        if (zzhvVar.zzq()) {
            m3678o(m7064t, 0, "upload_subdomain", zzhvVar.zzg());
        }
        if (zzhvVar.zzp()) {
            m3678o(m7064t, 0, "sgtm_join_id", zzhvVar.zzf());
        }
        for (com.google.android.gms.internal.measurement.zzhx zzhxVar : zzhvVar.zzh()) {
            if (zzhxVar != null) {
                m3673j(m7064t, 1);
                m7064t.append("bundle {\n");
                if (zzhxVar.zzbQ()) {
                    m3678o(m7064t, 1, "protocol_version", Integer.valueOf(zzhxVar.zzf()));
                }
                zzrd.zzb();
                zzio zzioVar = this.zzu;
                if (zzioVar.zzf().zzx(zzhxVar.zzF(), zzgi.zzaL) && zzhxVar.zzbT()) {
                    m3678o(m7064t, 1, "session_stitching_token", zzhxVar.zzU());
                }
                m3678o(m7064t, 1, "platform", zzhxVar.zzS());
                if (zzhxVar.zzbL()) {
                    m3678o(m7064t, 1, "gmp_version", Long.valueOf(zzhxVar.zzp()));
                }
                if (zzhxVar.zzbZ()) {
                    m3678o(m7064t, 1, "uploading_gmp_version", Long.valueOf(zzhxVar.zzv()));
                }
                if (zzhxVar.zzbJ()) {
                    m3678o(m7064t, 1, "dynamite_version", Long.valueOf(zzhxVar.zzn()));
                }
                if (zzhxVar.zzbC()) {
                    m3678o(m7064t, 1, "config_version", Long.valueOf(zzhxVar.zzk()));
                }
                m3678o(m7064t, 1, "gmp_app_id", zzhxVar.zzP());
                m3678o(m7064t, 1, "admob_app_id", zzhxVar.zzE());
                m3678o(m7064t, 1, "app_id", zzhxVar.zzF());
                m3678o(m7064t, 1, "app_version", zzhxVar.zzI());
                if (zzhxVar.zzby()) {
                    m3678o(m7064t, 1, "app_version_major", Integer.valueOf(zzhxVar.zzb()));
                }
                m3678o(m7064t, 1, "firebase_instance_id", zzhxVar.zzO());
                if (zzhxVar.zzbH()) {
                    m3678o(m7064t, 1, "dev_cert_hash", Long.valueOf(zzhxVar.zzm()));
                }
                m3678o(m7064t, 1, "app_store", zzhxVar.zzH());
                if (zzhxVar.zzbY()) {
                    m3678o(m7064t, 1, "upload_timestamp_millis", Long.valueOf(zzhxVar.zzu()));
                }
                if (zzhxVar.zzbV()) {
                    m3678o(m7064t, 1, "start_timestamp_millis", Long.valueOf(zzhxVar.zzs()));
                }
                if (zzhxVar.zzbK()) {
                    m3678o(m7064t, 1, "end_timestamp_millis", Long.valueOf(zzhxVar.zzo()));
                }
                if (zzhxVar.zzbP()) {
                    m3678o(m7064t, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzhxVar.zzr()));
                }
                if (zzhxVar.zzbO()) {
                    m3678o(m7064t, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzhxVar.zzq()));
                }
                m3678o(m7064t, 1, "app_instance_id", zzhxVar.zzG());
                m3678o(m7064t, 1, "resettable_device_id", zzhxVar.zzT());
                m3678o(m7064t, 1, "ds_id", zzhxVar.zzN());
                if (zzhxVar.zzbN()) {
                    m3678o(m7064t, 1, "limited_ad_tracking", Boolean.valueOf(zzhxVar.zzbv()));
                }
                m3678o(m7064t, 1, "os_version", zzhxVar.zzR());
                m3678o(m7064t, 1, "device_model", zzhxVar.zzM());
                m3678o(m7064t, 1, "user_default_language", zzhxVar.zzV());
                if (zzhxVar.zzbX()) {
                    m3678o(m7064t, 1, "time_zone_offset_minutes", Integer.valueOf(zzhxVar.zzh()));
                }
                if (zzhxVar.zzbB()) {
                    m3678o(m7064t, 1, "bundle_sequential_index", Integer.valueOf(zzhxVar.zzc()));
                }
                if (zzhxVar.zzbG()) {
                    m3678o(m7064t, 1, "delivery_index", Integer.valueOf(zzhxVar.zzd()));
                }
                if (zzhxVar.zzbS()) {
                    m3678o(m7064t, 1, "service_upload", Boolean.valueOf(zzhxVar.zzbw()));
                }
                m3678o(m7064t, 1, "health_monitor", zzhxVar.zzQ());
                if (zzhxVar.zzbR()) {
                    m3678o(m7064t, 1, "retry_counter", Integer.valueOf(zzhxVar.zzg()));
                }
                if (zzhxVar.zzbE()) {
                    m3678o(m7064t, 1, "consent_signals", zzhxVar.zzK());
                }
                if (zzhxVar.zzbM()) {
                    m3678o(m7064t, 1, "is_dma_region", Boolean.valueOf(zzhxVar.zzbu()));
                }
                if (zzhxVar.zzbF()) {
                    m3678o(m7064t, 1, "core_platform_services", zzhxVar.zzL());
                }
                if (zzhxVar.zzbD()) {
                    m3678o(m7064t, 1, "consent_diagnostics", zzhxVar.zzJ());
                }
                if (zzhxVar.zzbW()) {
                    m3678o(m7064t, 1, "target_os_version", Long.valueOf(zzhxVar.zzt()));
                }
                zzqr.zzb();
                if (zzioVar.zzf().zzx(zzhxVar.zzF(), zzgi.zzaV)) {
                    m3678o(m7064t, 1, "ad_services_version", Integer.valueOf(zzhxVar.zza()));
                    if (zzhxVar.zzbz() && (zzx = zzhxVar.zzx()) != null) {
                        m3673j(m7064t, 2);
                        m7064t.append("attribution_eligibility_status {\n");
                        m3678o(m7064t, 2, "eligible", Boolean.valueOf(zzx.zzn()));
                        m3678o(m7064t, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzx.zzp()));
                        m3678o(m7064t, 2, "pre_r", Boolean.valueOf(zzx.zzq()));
                        m3678o(m7064t, 2, "r_extensions_too_old", Boolean.valueOf(zzx.zzr()));
                        m3678o(m7064t, 2, "adservices_extension_too_old", Boolean.valueOf(zzx.zzm()));
                        m3678o(m7064t, 2, "ad_storage_not_allowed", Boolean.valueOf(zzx.zzk()));
                        m3678o(m7064t, 2, "measurement_manager_disabled", Boolean.valueOf(zzx.zzo()));
                        m3673j(m7064t, 2);
                        m7064t.append("}\n");
                    }
                }
                if (zzhxVar.zzbx()) {
                    com.google.android.gms.internal.measurement.zzhc zzw = zzhxVar.zzw();
                    m3673j(m7064t, 2);
                    m7064t.append("ad_campaign_info {\n");
                    if (zzw.zzC()) {
                        m3678o(m7064t, 2, "deep_link_gclid", zzw.zzh());
                    }
                    if (zzw.zzB()) {
                        m3678o(m7064t, 2, "deep_link_gbraid", zzw.zzg());
                    }
                    if (zzw.zzA()) {
                        m3678o(m7064t, 2, "deep_link_gad_source", zzw.zzf());
                    }
                    if (zzw.zzD()) {
                        m3678o(m7064t, 2, "deep_link_session_millis", Long.valueOf(zzw.zza()));
                    }
                    if (zzw.zzH()) {
                        m3678o(m7064t, 2, "market_referrer_gclid", zzw.zzk());
                    }
                    if (zzw.zzG()) {
                        m3678o(m7064t, 2, "market_referrer_gbraid", zzw.zzj());
                    }
                    if (zzw.zzF()) {
                        m3678o(m7064t, 2, "market_referrer_gad_source", zzw.zzi());
                    }
                    if (zzw.zzE()) {
                        m3678o(m7064t, 2, "market_referrer_click_millis", Long.valueOf(zzw.zzb()));
                    }
                    m3673j(m7064t, 2);
                    m7064t.append("}\n");
                }
                if (zzhxVar.zzbA()) {
                    m3678o(m7064t, 1, "batching_timestamp_millis", Long.valueOf(zzhxVar.zzj()));
                }
                if (zzhxVar.zzbU()) {
                    com.google.android.gms.internal.measurement.zzim zzC = zzhxVar.zzC();
                    m3673j(m7064t, 2);
                    m7064t.append("sgtm_diagnostics {\n");
                    int zzg = zzC.zzg();
                    if (zzg != 1) {
                        if (zzg != 2) {
                            if (zzg != 3) {
                                if (zzg != 4) {
                                    str = "SDK_SERVICE_UPLOAD";
                                } else {
                                    str = "PACKAGE_SERVICE_UPLOAD";
                                }
                            } else {
                                str = "SDK_CLIENT_UPLOAD";
                            }
                        } else {
                            str = "GA_UPLOAD";
                        }
                    } else {
                        str = "UPLOAD_TYPE_UNKNOWN";
                    }
                    m3678o(m7064t, 2, "upload_type", str);
                    m3678o(m7064t, 2, "client_upload_eligibility", zzC.zzb().name());
                    int zzf = zzC.zzf();
                    if (zzf != 1) {
                        if (zzf != 2) {
                            if (zzf != 3) {
                                if (zzf != 4) {
                                    if (zzf != 5) {
                                        str2 = "NON_PLAY_MISSING_SGTM_SERVER_URL";
                                    } else {
                                        str2 = "MISSING_SGTM_PROXY_INFO";
                                    }
                                } else {
                                    str2 = "MISSING_SGTM_SETTINGS";
                                }
                            } else {
                                str2 = "NOT_IN_ROLLOUT";
                            }
                        } else {
                            str2 = "SERVICE_UPLOAD_ELIGIBLE";
                        }
                    } else {
                        str2 = "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN";
                    }
                    m3678o(m7064t, 2, "service_upload_eligibility", str2);
                    m3673j(m7064t, 2);
                    m7064t.append("}\n");
                }
                List<com.google.android.gms.internal.measurement.zzio> zzY = zzhxVar.zzY();
                if (zzY != null) {
                    for (com.google.android.gms.internal.measurement.zzio zzioVar2 : zzY) {
                        if (zzioVar2 != null) {
                            m3673j(m7064t, 2);
                            m7064t.append("user_property {\n");
                            Double d = null;
                            if (zzioVar2.zzu()) {
                                l = Long.valueOf(zzioVar2.zzd());
                            } else {
                                l = null;
                            }
                            m3678o(m7064t, 2, "set_timestamp_millis", l);
                            m3678o(m7064t, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, zzioVar.zzj().zzf(zzioVar2.zzg()));
                            m3678o(m7064t, 2, "string_value", zzioVar2.zzh());
                            if (zzioVar2.zzt()) {
                                l2 = Long.valueOf(zzioVar2.zzc());
                            } else {
                                l2 = null;
                            }
                            m3678o(m7064t, 2, "int_value", l2);
                            if (zzioVar2.zzr()) {
                                d = Double.valueOf(zzioVar2.zza());
                            }
                            m3678o(m7064t, 2, "double_value", d);
                            m3673j(m7064t, 2);
                            m7064t.append("}\n");
                        }
                    }
                }
                List<zzhi> zzW = zzhxVar.zzW();
                if (zzW != null) {
                    for (zzhi zzhiVar : zzW) {
                        if (zzhiVar != null) {
                            m3673j(m7064t, 2);
                            m7064t.append("audience_membership {\n");
                            if (zzhiVar.zzk()) {
                                m3678o(m7064t, 2, "audience_id", Integer.valueOf(zzhiVar.zza()));
                            }
                            if (zzhiVar.zzm()) {
                                m3678o(m7064t, 2, "new_audience", Boolean.valueOf(zzhiVar.zzj()));
                            }
                            m3677n(m7064t, "current_data", zzhiVar.zzd());
                            if (zzhiVar.zzn()) {
                                m3677n(m7064t, "previous_data", zzhiVar.zze());
                            }
                            m3673j(m7064t, 2);
                            m7064t.append("}\n");
                        }
                    }
                }
                List<zzhm> zzX = zzhxVar.zzX();
                if (zzX != null) {
                    for (zzhm zzhmVar : zzX) {
                        if (zzhmVar != null) {
                            m3673j(m7064t, 2);
                            m7064t.append("event {\n");
                            m3678o(m7064t, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, zzioVar.zzj().zzd(zzhmVar.zzh()));
                            if (zzhmVar.zzu()) {
                                m3678o(m7064t, 2, "timestamp_millis", Long.valueOf(zzhmVar.zzd()));
                            }
                            if (zzhmVar.zzt()) {
                                m3678o(m7064t, 2, "previous_timestamp_millis", Long.valueOf(zzhmVar.zzc()));
                            }
                            if (zzhmVar.zzs()) {
                                m3678o(m7064t, 2, "count", Integer.valueOf(zzhmVar.zza()));
                            }
                            if (zzhmVar.zzb() != 0) {
                                m3689h(m7064t, 2, zzhmVar.zzi());
                            }
                            m3673j(m7064t, 2);
                            m7064t.append("}\n");
                        }
                    }
                }
                m3673j(m7064t, 1);
                m7064t.append("}\n");
            }
        }
        m7064t.append("} // End-of-batch\n");
        return m7064t.toString();
    }

    /* renamed from: z */
    public final String m3696z(com.google.android.gms.internal.measurement.zzfr zzfrVar) {
        StringBuilder m7064t = AbstractC1726qj.m7064t("\nproperty_filter {\n");
        if (zzfrVar.zzj()) {
            m3678o(m7064t, 0, "filter_id", Integer.valueOf(zzfrVar.zza()));
        }
        m3678o(m7064t, 0, "property_name", this.zzu.zzj().zzf(zzfrVar.zze()));
        String m3675l = m3675l(zzfrVar.zzg(), zzfrVar.zzh(), zzfrVar.zzi());
        if (!m3675l.isEmpty()) {
            m3678o(m7064t, 0, "filter_type", m3675l);
        }
        m3690i(m7064t, 1, zzfrVar.zzb());
        m7064t.append("}\n");
        return m7064t.toString();
    }

    @Override // p000.re3
    public final boolean zzb() {
        return false;
    }
}
