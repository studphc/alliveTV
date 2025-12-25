package com.google.common.graph;

import com.google.common.graph.ElementOrder;

/* renamed from: com.google.common.graph.c */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0964c {

    /* renamed from: a */
    public static final /* synthetic */ int[] f15050a;

    static {
        int[] iArr = new int[ElementOrder.Type.values().length];
        f15050a = iArr;
        try {
            iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15050a[ElementOrder.Type.INSERTION.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15050a[ElementOrder.Type.STABLE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15050a[ElementOrder.Type.SORTED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
