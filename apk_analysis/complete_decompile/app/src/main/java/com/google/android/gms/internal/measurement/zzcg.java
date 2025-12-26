package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p000.ka3;

/* loaded from: classes.dex */
public final class zzcg implements SharedPreferences {

    /* renamed from: a */
    public final HashMap f13801a = new HashMap();

    /* renamed from: b */
    public final HashSet f13802b = new HashSet();

    /* renamed from: a */
    public final Object m3292a(Object obj, String str) {
        Object obj2 = this.f13801a.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return this.f13801a.containsKey(str);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new ka3(this);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        return this.f13801a;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Boolean) m3292a(Boolean.valueOf(z), str)).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        return ((Float) m3292a(Float.valueOf(f), str)).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        return ((Integer) m3292a(Integer.valueOf(i), str)).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        return ((Long) m3292a(Long.valueOf(j), str)).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        return (String) m3292a(str2, str);
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        return (Set) m3292a(set, str);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f13802b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f13802b.remove(onSharedPreferenceChangeListener);
    }
}
