package com.orhanobut.hawk;

import android.util.Base64;
import p000.z80;

/* loaded from: classes2.dex */
public class NoEncryption implements z80 {
    @Override // p000.z80
    public String decrypt(String str, String str2) {
        return new String(Base64.decode(str2, 0));
    }

    @Override // p000.z80
    public String encrypt(String str, String str2) {
        return Base64.encodeToString(str2.getBytes(), 0);
    }

    public boolean init() {
        return true;
    }
}
