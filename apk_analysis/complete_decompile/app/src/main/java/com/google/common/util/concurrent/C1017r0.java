package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.Arrays;
import p000.AbstractC1726qj;

/* renamed from: com.google.common.util.concurrent.r0 */
/* loaded from: classes2.dex */
public class C1017r0 extends IllegalStateException {

    /* renamed from: a */
    public static final StackTraceElement[] f15420a = new StackTraceElement[0];

    /* renamed from: b */
    public static final ImmutableSet f15421b = ImmutableSet.m3974of(CycleDetectingLockFactory.class.getName(), C1017r0.class.getName(), C1019s0.class.getName());

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1017r0(C1019s0 c1019s0, C1019s0 c1019s02) {
        super(AbstractC1726qj.m7059o(r4, " -> ", r5, AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(4, r4), r5)));
        String str = c1019s02.f15425c;
        String str2 = c1019s0.f15425c;
        StackTraceElement[] stackTrace = getStackTrace();
        int length = stackTrace.length;
        for (int i = 0; i < length; i++) {
            if (CycleDetectingLockFactory.WithExplicitOrdering.class.getName().equals(stackTrace[i].getClassName())) {
                setStackTrace(f15420a);
                return;
            }
            if (!f15421b.contains(stackTrace[i].getClassName())) {
                setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                return;
            }
        }
    }
}
