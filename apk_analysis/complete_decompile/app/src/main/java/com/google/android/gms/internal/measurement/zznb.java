package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zznb extends LinkedHashMap {

    /* renamed from: b */
    public static final zznb f13891b;

    /* renamed from: a */
    public boolean f13892a = true;

    static {
        zznb zznbVar = new zznb();
        f13891b = zznbVar;
        zznbVar.f13892a = false;
    }

    /* renamed from: a */
    public static int m3475a(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            Charset charset = zzmk.f13887a;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            if (length == 0) {
                return 1;
            }
            return length;
        }
        if (!(obj instanceof zzmf)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static zznb zza() {
        return f13891b;
    }

    /* renamed from: c */
    public final void m3476c() {
        if (this.f13892a) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        m3476c();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    Iterator it = entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (map.containsKey(entry.getKey())) {
                            Object value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                                equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                            } else {
                                equals = value.equals(obj2);
                            }
                            if (!equals) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i += m3475a(entry.getValue()) ^ m3475a(entry.getKey());
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        m3476c();
        Charset charset = zzmk.f13887a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        m3476c();
        for (Object obj : map.keySet()) {
            Charset charset = zzmk.f13887a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m3476c();
        return super.remove(obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, com.google.android.gms.internal.measurement.zznb] */
    public final zznb zzb() {
        if (isEmpty()) {
            return new zznb();
        }
        ?? linkedHashMap = new LinkedHashMap(this);
        linkedHashMap.f13892a = true;
        return linkedHashMap;
    }

    public final void zzc() {
        this.f13892a = false;
    }

    public final void zzd(zznb zznbVar) {
        m3476c();
        if (!zznbVar.isEmpty()) {
            putAll(zznbVar);
        }
    }

    public final boolean zze() {
        return this.f13892a;
    }
}
