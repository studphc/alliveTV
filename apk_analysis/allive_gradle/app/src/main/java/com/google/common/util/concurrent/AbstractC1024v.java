package com.google.common.util.concurrent;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.AbstractC1670p0;
import p000.C1259h7;
import p000.p63;

/* renamed from: com.google.common.util.concurrent.v */
/* loaded from: classes2.dex */
public abstract class AbstractC1024v extends AbstractC1670p0 {

    /* renamed from: j */
    public static final p63 f15433j;

    /* renamed from: k */
    public static final Logger f15434k = Logger.getLogger(AbstractC1024v.class.getName());

    /* renamed from: h */
    public volatile Set f15435h;

    /* renamed from: i */
    public volatile int f15436i;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [p63] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    static {
        ?? r1;
        try {
            th = null;
            r1 = new C1259h7(AtomicReferenceFieldUpdater.newUpdater(AbstractC1024v.class, Set.class, "h"), AtomicIntegerFieldUpdater.newUpdater(AbstractC1024v.class, "i"));
        } catch (Throwable th) {
            th = th;
            r1 = new Object();
        }
        f15433j = r1;
        if (th != null) {
            f15434k.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }
}
