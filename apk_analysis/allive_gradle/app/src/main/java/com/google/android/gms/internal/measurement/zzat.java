package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.AbstractC1726qj;
import p000.t93;

/* loaded from: classes.dex */
public final class zzat implements Iterable, zzap {

    /* renamed from: a */
    public final String f13785a;

    public zzat(String str) {
        if (str != null) {
            this.f13785a = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        return this.f13785a.equals(((zzat) obj).f13785a);
    }

    public final int hashCode() {
        return this.f13785a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new t93(this, 1);
    }

    public final String toString() {
        return AbstractC1726qj.m7061q(new StringBuilder("\""), this.f13785a, "\"");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0177. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025e  */
    @Override // com.google.android.gms.internal.measurement.zzap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        char c;
        int i;
        zzap zzatVar;
        int i2;
        double doubleValue;
        zzap zzahVar;
        double doubleValue2;
        double zza;
        String zzi;
        int i3;
        double d;
        double min;
        double length;
        double min2;
        long j;
        int i4;
        int i5;
        int i6;
        zzg zzgVar2;
        int i7;
        int length2;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || FirebaseAnalytics.Event.SEARCH.equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
        } else {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "hasOwnProperty";
                str4 = "trim";
                if (!str4.equals(str)) {
                    throw new IllegalArgumentException(AbstractC1726qj.m7057m(str, " is not a String function"));
                }
                switch (str.hashCode()) {
                    case -1789698943:
                        str5 = "charAt";
                        str6 = str3;
                        if (str.equals(str6)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1776922004:
                        str5 = "charAt";
                        if (str.equals("toString")) {
                            c = 14;
                            str6 = str3;
                            break;
                        }
                        str6 = str3;
                        c = 65535;
                        break;
                    case -1464939364:
                        str5 = "charAt";
                        if (str.equals("toLocaleLowerCase")) {
                            c = '\f';
                            str6 = str3;
                            break;
                        }
                        str6 = str3;
                        c = 65535;
                        break;
                    case -1361633751:
                        str5 = "charAt";
                        if (str.equals(str5)) {
                            str6 = str3;
                            c = 0;
                            break;
                        }
                        str6 = str3;
                        c = 65535;
                        break;
                    case -1354795244:
                        if (str.equals("concat")) {
                            str5 = "charAt";
                            str6 = str3;
                            c = 1;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case -1137582698:
                        if (str.equals("toLowerCase")) {
                            c = '\r';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case -906336856:
                        if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                            c = 7;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case -726908483:
                        if (str.equals(str2)) {
                            c = 11;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case -467511597:
                        if (str.equals("lastIndexOf")) {
                            c = 4;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case -399551817:
                        if (str.equals("toUpperCase")) {
                            c = 15;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case 3568674:
                        if (str.equals(str4)) {
                            c = 16;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case 103668165:
                        if (str.equals("match")) {
                            c = 5;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case 109526418:
                        if (str.equals("slice")) {
                            c = '\b';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case 109648666:
                        if (str.equals("split")) {
                            c = '\t';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case 530542161:
                        if (str.equals("substring")) {
                            c = '\n';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case 1094496948:
                        if (str.equals("replace")) {
                            c = 6;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    case 1943291465:
                        if (str.equals("indexOf")) {
                            str5 = "charAt";
                            str6 = str3;
                            c = 3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                    default:
                        str5 = "charAt";
                        str6 = str3;
                        c = 65535;
                        break;
                }
                String str7 = "undefined";
                String str8 = this.f13785a;
                switch (c) {
                    case 0:
                        zzh.zzj(str5, 1, list);
                        if (!list.isEmpty()) {
                            i = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                        } else {
                            i = 0;
                        }
                        if (i >= 0 && i < str8.length()) {
                            return new zzat(String.valueOf(str8.charAt(i)));
                        }
                        return zzap.zzm;
                    case 1:
                        if (!list.isEmpty()) {
                            StringBuilder sb = new StringBuilder(str8);
                            for (int i8 = 0; i8 < list.size(); i8++) {
                                sb.append(zzgVar.zzb((zzap) list.get(i8)).zzi());
                            }
                            zzatVar = new zzat(sb.toString());
                            return zzatVar;
                        }
                        return this;
                    case 2:
                        zzh.zzh(str6, 1, list);
                        zzap zzb = zzgVar.zzb((zzap) list.get(0));
                        if ("length".equals(zzb.zzi())) {
                            return zzap.zzk;
                        }
                        double doubleValue3 = zzb.zzh().doubleValue();
                        if (doubleValue3 == Math.floor(doubleValue3) && (i2 = (int) doubleValue3) >= 0 && i2 < str8.length()) {
                            return zzap.zzk;
                        }
                        return zzap.zzl;
                    case 3:
                        zzh.zzj("indexOf", 2, list);
                        if (list.size() > 0) {
                            str7 = zzgVar.zzb((zzap) list.get(0)).zzi();
                        }
                        String str9 = str7;
                        if (list.size() < 2) {
                            doubleValue = 0.0d;
                        } else {
                            doubleValue = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                        }
                        zzahVar = new zzah(Double.valueOf(str8.indexOf(str9, (int) zzh.zza(doubleValue))));
                        return zzahVar;
                    case 4:
                        zzh.zzj("lastIndexOf", 2, list);
                        if (list.size() > 0) {
                            str7 = zzgVar.zzb((zzap) list.get(0)).zzi();
                        }
                        String str10 = str7;
                        if (list.size() < 2) {
                            doubleValue2 = Double.NaN;
                        } else {
                            doubleValue2 = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                        }
                        if (Double.isNaN(doubleValue2)) {
                            zza = Double.POSITIVE_INFINITY;
                        } else {
                            zza = zzh.zza(doubleValue2);
                        }
                        zzahVar = new zzah(Double.valueOf(str8.lastIndexOf(str10, (int) zza)));
                        return zzahVar;
                    case 5:
                        zzh.zzj("match", 1, list);
                        if (list.size() <= 0) {
                            zzi = "";
                        } else {
                            zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                        }
                        Matcher matcher = Pattern.compile(zzi).matcher(str8);
                        if (matcher.find()) {
                            zzatVar = new zzae(Arrays.asList(new zzat(matcher.group())));
                            return zzatVar;
                        }
                        return zzap.zzg;
                    case 6:
                        zzh.zzj("replace", 2, list);
                        zzap zzapVar = zzap.zzf;
                        if (!list.isEmpty()) {
                            str7 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            if (list.size() > 1) {
                                zzapVar = zzgVar.zzb((zzap) list.get(1));
                            }
                        }
                        String str11 = str7;
                        int indexOf = str8.indexOf(str11);
                        if (indexOf >= 0) {
                            if (zzapVar instanceof zzai) {
                                i3 = 0;
                                zzapVar = ((zzai) zzapVar).zza(zzgVar, Arrays.asList(new zzat(str11), new zzah(Double.valueOf(indexOf)), this));
                            } else {
                                i3 = 0;
                            }
                            zzahVar = new zzat(AbstractC1726qj.m7058n(str8.substring(i3, indexOf), zzapVar.zzi(), str8.substring(str11.length() + indexOf)));
                            return zzahVar;
                        }
                        return this;
                    case 7:
                        zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                        if (!list.isEmpty()) {
                            str7 = zzgVar.zzb((zzap) list.get(0)).zzi();
                        }
                        if (Pattern.compile(str7).matcher(str8).find()) {
                            zzatVar = new zzah(Double.valueOf(r1.start()));
                            return zzatVar;
                        }
                        return new zzah(Double.valueOf(-1.0d));
                    case '\b':
                        zzh.zzj("slice", 2, list);
                        if (!list.isEmpty()) {
                            d = zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue();
                        } else {
                            d = 0.0d;
                        }
                        double zza2 = zzh.zza(d);
                        if (zza2 < 0.0d) {
                            min = Math.max(str8.length() + zza2, 0.0d);
                        } else {
                            min = Math.min(zza2, str8.length());
                        }
                        if (list.size() > 1) {
                            length = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                        } else {
                            length = str8.length();
                        }
                        double zza3 = zzh.zza(length);
                        if (zza3 < 0.0d) {
                            min2 = Math.max(str8.length() + zza3, 0.0d);
                        } else {
                            min2 = Math.min(zza3, str8.length());
                        }
                        int i9 = (int) min;
                        return new zzat(str8.substring(i9, Math.max(0, ((int) min2) - i9) + i9));
                    case '\t':
                        zzh.zzj("split", 2, list);
                        if (str8.length() == 0) {
                            return new zzae(Arrays.asList(this));
                        }
                        ArrayList arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(this);
                        } else {
                            String zzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            if (list.size() > 1) {
                                j = zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                            } else {
                                j = 2147483647L;
                            }
                            if (j == 0) {
                                return new zzae();
                            }
                            String[] split = str8.split(Pattern.quote(zzi2), ((int) j) + 1);
                            int length3 = split.length;
                            if (zzi2.isEmpty() && length3 > 0) {
                                boolean isEmpty = split[0].isEmpty();
                                i4 = -1;
                                i5 = length3 - 1;
                                i6 = isEmpty;
                                if (!split[i5].isEmpty()) {
                                    i5 = length3;
                                    i6 = isEmpty;
                                }
                            } else {
                                i4 = -1;
                                i5 = length3;
                                i6 = 0;
                            }
                            if (length3 > j) {
                                i5 += i4;
                            }
                            while (i6 < i5) {
                                arrayList.add(new zzat(split[i6]));
                                i6++;
                            }
                        }
                        return new zzae(arrayList);
                    case '\n':
                        zzh.zzj("substring", 2, list);
                        if (!list.isEmpty()) {
                            zzgVar2 = zzgVar;
                            i7 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                        } else {
                            zzgVar2 = zzgVar;
                            i7 = 0;
                        }
                        if (list.size() > 1) {
                            length2 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                        } else {
                            length2 = str8.length();
                        }
                        int min3 = Math.min(Math.max(i7, 0), str8.length());
                        int min4 = Math.min(Math.max(length2, 0), str8.length());
                        zzahVar = new zzat(str8.substring(Math.min(min3, min4), Math.max(min3, min4)));
                        return zzahVar;
                    case 11:
                        zzh.zzh(str2, 0, list);
                        return new zzat(str8.toUpperCase());
                    case '\f':
                        zzh.zzh("toLocaleLowerCase", 0, list);
                        return new zzat(str8.toLowerCase());
                    case '\r':
                        zzh.zzh("toLowerCase", 0, list);
                        return new zzat(str8.toLowerCase(Locale.ENGLISH));
                    case 14:
                        zzh.zzh("toString", 0, list);
                        return this;
                    case 15:
                        zzh.zzh("toUpperCase", 0, list);
                        return new zzat(str8.toUpperCase(Locale.ENGLISH));
                    case 16:
                        zzh.zzh("toUpperCase", 0, list);
                        return new zzat(str8.trim());
                    default:
                        throw new IllegalArgumentException("Command not supported");
                }
            }
        }
        str3 = "hasOwnProperty";
        str4 = "trim";
        switch (str.hashCode()) {
            case -1789698943:
                break;
            case -1776922004:
                break;
            case -1464939364:
                break;
            case -1361633751:
                break;
            case -1354795244:
                break;
            case -1137582698:
                break;
            case -906336856:
                break;
            case -726908483:
                break;
            case -467511597:
                break;
            case -399551817:
                break;
            case 3568674:
                break;
            case 103668165:
                break;
            case 109526418:
                break;
            case 109648666:
                break;
            case 530542161:
                break;
            case 1094496948:
                break;
            case 1943291465:
                break;
        }
        String str72 = "undefined";
        String str82 = this.f13785a;
        switch (c) {
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.f13785a);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.f13785a.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        String str = this.f13785a;
        if (!str.isEmpty()) {
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException unused) {
                return Double.valueOf(Double.NaN);
            }
        }
        return Double.valueOf(0.0d);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.f13785a;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new t93(this, 0);
    }
}
