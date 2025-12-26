package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes.dex */
public final class zzjo {

    /* renamed from: a */
    public final SimpleArrayMap f13846a;

    public zzjo(SimpleArrayMap simpleArrayMap) {
        this.f13846a = simpleArrayMap;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        SimpleArrayMap simpleArrayMap;
        if (uri != null) {
            simpleArrayMap = (SimpleArrayMap) this.f13846a.get(uri.toString());
        } else {
            simpleArrayMap = null;
        }
        if (simpleArrayMap == null) {
            return null;
        }
        return (String) simpleArrayMap.get("".concat(str3));
    }
}
