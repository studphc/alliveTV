package com.google.gson;

import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.ReflectionAccessFilterHelper;

/* renamed from: com.google.gson.a */
/* loaded from: classes2.dex */
public final class C1053a implements ReflectionAccessFilter {
    @Override // com.google.gson.ReflectionAccessFilter
    public final ReflectionAccessFilter.FilterResult check(Class cls) {
        if (ReflectionAccessFilterHelper.isJavaType(cls)) {
            return ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
        }
        return ReflectionAccessFilter.FilterResult.INDECISIVE;
    }
}
