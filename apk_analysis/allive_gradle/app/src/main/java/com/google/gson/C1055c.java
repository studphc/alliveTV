package com.google.gson;

import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.ReflectionAccessFilterHelper;

/* renamed from: com.google.gson.c */
/* loaded from: classes2.dex */
public final class C1055c implements ReflectionAccessFilter {
    @Override // com.google.gson.ReflectionAccessFilter
    public final ReflectionAccessFilter.FilterResult check(Class cls) {
        if (ReflectionAccessFilterHelper.isAndroidType(cls)) {
            return ReflectionAccessFilter.FilterResult.BLOCK_ALL;
        }
        return ReflectionAccessFilter.FilterResult.INDECISIVE;
    }
}
