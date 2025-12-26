package com.facebook.crypto.util;

import com.facebook.crypto.exception.CryptoInitializationException;
import java.util.ArrayList;
import java.util.Iterator;
import p000.zr2;

/* loaded from: classes.dex */
public class SystemNativeCryptoLibrary implements NativeCryptoLibrary {

    /* renamed from: d */
    public static final zr2 f9242d;

    /* renamed from: a */
    public boolean f9243a = true;

    /* renamed from: b */
    public boolean f9244b = false;

    /* renamed from: c */
    public volatile UnsatisfiedLinkError f9245c = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, zr2, java.util.ArrayList] */
    static {
        ?? arrayList = new ArrayList();
        arrayList.add("conceal");
        f9242d = arrayList;
    }

    /* renamed from: a */
    public final synchronized boolean m2409a() {
        if (!this.f9243a) {
            return this.f9244b;
        }
        try {
            Iterator it = f9242d.iterator();
            while (it.hasNext()) {
                System.loadLibrary((String) it.next());
            }
            this.f9244b = true;
        } catch (UnsatisfiedLinkError e) {
            this.f9245c = e;
            this.f9244b = false;
        }
        this.f9243a = false;
        return this.f9244b;
    }

    @Override // com.facebook.crypto.util.NativeCryptoLibrary
    public synchronized void ensureCryptoLoaded() {
        if (!m2409a()) {
            throw new CryptoInitializationException(this.f9245c);
        }
    }
}
