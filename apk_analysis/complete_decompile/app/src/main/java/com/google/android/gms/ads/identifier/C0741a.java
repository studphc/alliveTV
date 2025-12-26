package com.google.android.gms.ads.identifier;

import android.net.Uri;
import java.util.HashMap;

/* renamed from: com.google.android.gms.ads.identifier.a */
/* loaded from: classes.dex */
public final class C0741a extends Thread {

    /* renamed from: a */
    public final /* synthetic */ HashMap f12918a;

    public C0741a(HashMap hashMap) {
        this.f12918a = hashMap;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        HashMap hashMap = this.f12918a;
        for (String str : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str, (String) hashMap.get(str));
        }
        zzc.zza(buildUpon.build().toString());
    }
}
