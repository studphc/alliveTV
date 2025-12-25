package com.facebook.android.crypto.keychain;

import com.facebook.crypto.Conceal;
import com.facebook.crypto.util.SystemNativeCryptoLibrary;

/* loaded from: classes.dex */
public class AndroidConceal extends Conceal {

    /* renamed from: a */
    public static AndroidConceal f9189a;

    /* JADX WARN: Type inference failed for: r1v3, types: [com.facebook.android.crypto.keychain.AndroidConceal, com.facebook.crypto.Conceal] */
    public static synchronized AndroidConceal get() {
        AndroidConceal androidConceal;
        synchronized (AndroidConceal.class) {
            try {
                if (f9189a == null) {
                    f9189a = new Conceal(new SystemNativeCryptoLibrary(), new FixedSecureRandom());
                }
                androidConceal = f9189a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return androidConceal;
    }
}
