package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* loaded from: classes.dex */
public final class zzjx {

    /* renamed from: a */
    public static final ArrayMap f13850a = new ArrayMap();
    public static final /* synthetic */ int zza = 0;

    public static synchronized Uri zza(String str) {
        synchronized (zzjx.class) {
            ArrayMap arrayMap = f13850a;
            Uri uri = (Uri) arrayMap.get("com.google.android.gms.measurement");
            if (uri == null) {
                Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
                arrayMap.put("com.google.android.gms.measurement", parse);
                return parse;
            }
            return uri;
        }
    }
}
