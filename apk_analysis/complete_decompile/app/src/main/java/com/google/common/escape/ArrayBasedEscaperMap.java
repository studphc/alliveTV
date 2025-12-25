package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

@GwtCompatible
/* loaded from: classes.dex */
public final class ArrayBasedEscaperMap {

    /* renamed from: b */
    public static final char[][] f15002b = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 0, 0);

    /* renamed from: a */
    public final char[][] f15003a;

    public ArrayBasedEscaperMap(char[][] cArr) {
        this.f15003a = cArr;
    }

    public static ArrayBasedEscaperMap create(Map<Character, String> map) {
        char[][] cArr;
        Preconditions.checkNotNull(map);
        if (map.isEmpty()) {
            cArr = f15002b;
        } else {
            char[][] cArr2 = new char[((Character) Collections.max(map.keySet())).charValue() + 1];
            for (Character ch : map.keySet()) {
                cArr2[ch.charValue()] = map.get(ch).toCharArray();
            }
            cArr = cArr2;
        }
        return new ArrayBasedEscaperMap(cArr);
    }
}
