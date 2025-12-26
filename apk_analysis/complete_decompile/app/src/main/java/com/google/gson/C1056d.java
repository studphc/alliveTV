package com.google.gson;

import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.ReflectionAccessFilterHelper;

/* renamed from: com.google.gson.d */
/* loaded from: classes2.dex */
public final class C1056d implements ReflectionAccessFilter {
    @Override // com.google.gson.ReflectionAccessFilter
    public final ReflectionAccessFilter.FilterResult check(Class cls) {
        if (ReflectionAccessFilterHelper.isAnyPlatformType(cls)) {
            return ReflectionAccessFilter.FilterResult.BLOCK_ALL;
        }
        return ReflectionAccessFilter.FilterResult.INDECISIVE;
    }
}
