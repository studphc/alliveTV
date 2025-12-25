package p000;

import android.content.SharedPreferences;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ka3 implements SharedPreferences.Editor {

    /* renamed from: a */
    public boolean f20804a = false;

    /* renamed from: b */
    public final HashSet f20805b = new HashSet();

    /* renamed from: c */
    public final HashMap f20806c = new HashMap();

    /* renamed from: d */
    public final /* synthetic */ zzcg f20807d;

    /* renamed from: a */
    public final void m5516a(Object obj, String str) {
        if (obj != null) {
            this.f20806c.put(str, obj);
        } else {
            remove(str);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f20804a = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        boolean z = this.f20804a;
        zzcg zzcgVar = this.f20807d;
        if (z) {
            zzcgVar.f13801a.clear();
        }
        Set keySet = zzcgVar.f13801a.keySet();
        HashSet hashSet = this.f20805b;
        keySet.removeAll(hashSet);
        HashMap hashMap = this.f20806c;
        for (Map.Entry entry : hashMap.entrySet()) {
            zzcgVar.f13801a.put((String) entry.getKey(), entry.getValue());
        }
        Iterator it = zzcgVar.f13802b.iterator();
        while (it.hasNext()) {
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
            UnmodifiableIterator it2 = Sets.union(hashSet, hashMap.keySet()).iterator();
            while (it2.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(zzcgVar, (String) it2.next());
            }
        }
        if (!this.f20804a && hashSet.isEmpty() && hashMap.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        m5516a(Boolean.valueOf(z), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f) {
        m5516a(Float.valueOf(f), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i) {
        m5516a(Integer.valueOf(i), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j) {
        m5516a(Long.valueOf(j), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        m5516a(str2, str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        m5516a(set, str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        this.f20805b.add(str);
        return this;
    }
}
