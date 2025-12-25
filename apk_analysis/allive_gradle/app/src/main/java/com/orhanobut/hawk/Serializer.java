package com.orhanobut.hawk;

import p000.C1704py;

/* loaded from: classes2.dex */
public interface Serializer {
    C1704py deserialize(String str);

    <T> String serialize(String str, T t);
}
