package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');


    /* renamed from: a */
    public final char f15795a;

    /* renamed from: b */
    public final char f15796b;

    PublicSuffixType(char c, char c2) {
        this.f15795a = c;
        this.f15796b = c2;
    }
}
