package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Comparator;

/* renamed from: com.google.common.collect.z1 */
/* loaded from: classes.dex */
public final class C0959z1 implements Comparator {

    /* renamed from: a */
    public static final C0959z1 f14997a = new Object();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Multiset.Entry) obj2).getCount() - ((Multiset.Entry) obj).getCount();
    }
}
