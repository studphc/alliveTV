package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import p000.C2063zn;

@GwtCompatible
/* loaded from: classes.dex */
public final class CharEscaperBuilder {

    /* renamed from: b */
    public int f15011b = -1;

    /* renamed from: a */
    public final HashMap f15010a = new HashMap();

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscape(char c, String str) {
        this.f15010a.put(Character.valueOf(c), (String) Preconditions.checkNotNull(str));
        if (c > this.f15011b) {
            this.f15011b = c;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char c : cArr) {
            addEscape(c, str);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[this.f15011b + 1];
        for (Map.Entry entry : this.f15010a.entrySet()) {
            cArr[((Character) entry.getKey()).charValue()] = ((String) entry.getValue()).toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new C2063zn(toArray());
    }
}
