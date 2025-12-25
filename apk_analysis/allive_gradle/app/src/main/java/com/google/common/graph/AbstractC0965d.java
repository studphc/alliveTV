package com.google.common.graph;

import com.google.common.graph.ElementOrder;

/* renamed from: com.google.common.graph.d */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0965d {

    /* renamed from: a */
    public static final /* synthetic */ int[] f15051a;

    static {
        int[] iArr = new int[ElementOrder.Type.values().length];
        f15051a = iArr;
        try {
            iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15051a[ElementOrder.Type.STABLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
