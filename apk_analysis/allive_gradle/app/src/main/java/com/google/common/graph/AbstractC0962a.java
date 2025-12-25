package com.google.common.graph;

import com.google.common.graph.ElementOrder;

/* renamed from: com.google.common.graph.a */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0962a {

    /* renamed from: a */
    public static final /* synthetic */ int[] f15044a;

    static {
        int[] iArr = new int[ElementOrder.Type.values().length];
        f15044a = iArr;
        try {
            iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15044a[ElementOrder.Type.STABLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
