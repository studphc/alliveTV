package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class LongSerializationPolicy {
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    /* renamed from: a */
    public static final /* synthetic */ LongSerializationPolicy[] f15713a;

    static {
        LongSerializationPolicy longSerializationPolicy = new LongSerializationPolicy() { // from class: ce1
            @Override // com.google.gson.LongSerializationPolicy
            public final JsonElement serialize(Long l) {
                if (l == null) {
                    return JsonNull.INSTANCE;
                }
                return new JsonPrimitive(l);
            }
        };
        DEFAULT = longSerializationPolicy;
        LongSerializationPolicy longSerializationPolicy2 = new LongSerializationPolicy() { // from class: de1
            @Override // com.google.gson.LongSerializationPolicy
            public final JsonElement serialize(Long l) {
                if (l == null) {
                    return JsonNull.INSTANCE;
                }
                return new JsonPrimitive(l.toString());
            }
        };
        STRING = longSerializationPolicy2;
        f15713a = new LongSerializationPolicy[]{longSerializationPolicy, longSerializationPolicy2};
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) f15713a.clone();
    }

    public abstract JsonElement serialize(Long l);
}
