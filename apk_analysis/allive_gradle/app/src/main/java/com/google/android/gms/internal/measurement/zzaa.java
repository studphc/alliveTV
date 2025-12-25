package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class zzaa {

    /* renamed from: d */
    public static final ImmutableSet f13769d = ImmutableSet.m3974of("_syn", "_err", "_el");

    /* renamed from: a */
    public String f13770a;

    /* renamed from: b */
    public final long f13771b;

    /* renamed from: c */
    public final HashMap f13772c;

    public zzaa(String str, long j, Map map) {
        this.f13770a = str;
        this.f13771b = j;
        HashMap hashMap = new HashMap();
        this.f13772c = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public static Object zzd(String str, Object obj, Object obj2) {
        if (f13769d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else if (!(obj instanceof Double)) {
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaa)) {
            return false;
        }
        zzaa zzaaVar = (zzaa) obj;
        if (this.f13771b != zzaaVar.f13771b || !this.f13770a.equals(zzaaVar.f13770a)) {
            return false;
        }
        return this.f13772c.equals(zzaaVar.f13772c);
    }

    public final int hashCode() {
        int hashCode = this.f13770a.hashCode() * 31;
        HashMap hashMap = this.f13772c;
        long j = this.f13771b;
        return hashMap.hashCode() + ((hashCode + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public final String toString() {
        String str = this.f13770a;
        String obj = this.f13772c.toString();
        StringBuilder m7065u = AbstractC1726qj.m7065u("Event{name='", str, "', timestamp=");
        m7065u.append(this.f13771b);
        m7065u.append(", params=");
        m7065u.append(obj);
        m7065u.append("}");
        return m7065u.toString();
    }

    public final long zza() {
        return this.f13771b;
    }

    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaa clone() {
        return new zzaa(this.f13770a, this.f13771b, new HashMap(this.f13772c));
    }

    public final Object zzc(String str) {
        HashMap hashMap = this.f13772c;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        return null;
    }

    public final String zze() {
        return this.f13770a;
    }

    public final Map zzf() {
        return this.f13772c;
    }

    public final void zzg(String str) {
        this.f13770a = str;
    }

    public final void zzh(String str, Object obj) {
        HashMap hashMap = this.f13772c;
        if (obj == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, zzd(str, hashMap.get(str), obj));
        }
    }
}
