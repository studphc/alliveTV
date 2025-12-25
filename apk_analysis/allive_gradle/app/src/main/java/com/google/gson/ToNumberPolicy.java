package com.google.gson;

import com.google.gson.JsonParseException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class ToNumberPolicy implements ToNumberStrategy {
    public static final ToNumberPolicy BIG_DECIMAL;
    public static final ToNumberPolicy DOUBLE;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER;
    public static final ToNumberPolicy LONG_OR_DOUBLE;

    /* renamed from: a */
    public static final /* synthetic */ ToNumberPolicy[] f15715a;

    static {
        ToNumberPolicy toNumberPolicy = new ToNumberPolicy() { // from class: eu2
            @Override // com.google.gson.ToNumberStrategy
            public final Number readNumber(JsonReader jsonReader) {
                return Double.valueOf(jsonReader.nextDouble());
            }
        };
        DOUBLE = toNumberPolicy;
        ToNumberPolicy toNumberPolicy2 = new ToNumberPolicy() { // from class: fu2
            @Override // com.google.gson.ToNumberStrategy
            public final Number readNumber(JsonReader jsonReader) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
        };
        LAZILY_PARSED_NUMBER = toNumberPolicy2;
        ToNumberPolicy toNumberPolicy3 = new ToNumberPolicy() { // from class: gu2
            @Override // com.google.gson.ToNumberStrategy
            public final Number readNumber(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(nextString));
                    } catch (NumberFormatException unused) {
                        Double valueOf = Double.valueOf(nextString);
                        if (!valueOf.isInfinite()) {
                            if (valueOf.isNaN()) {
                            }
                            return valueOf;
                        }
                        if (!jsonReader.isLenient()) {
                            throw new MalformedJsonException("JSON forbids NaN and infinities: " + valueOf + "; at path " + jsonReader.getPreviousPath());
                        }
                        return valueOf;
                    }
                } catch (NumberFormatException e) {
                    StringBuilder m7065u = AbstractC1726qj.m7065u("Cannot parse ", nextString, "; at path ");
                    m7065u.append(jsonReader.getPreviousPath());
                    throw new JsonParseException(m7065u.toString(), e);
                }
            }
        };
        LONG_OR_DOUBLE = toNumberPolicy3;
        ToNumberPolicy toNumberPolicy4 = new ToNumberPolicy() { // from class: hu2
            @Override // com.google.gson.ToNumberStrategy
            public final Number readNumber(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                try {
                    return new BigDecimal(nextString);
                } catch (NumberFormatException e) {
                    StringBuilder m7065u = AbstractC1726qj.m7065u("Cannot parse ", nextString, "; at path ");
                    m7065u.append(jsonReader.getPreviousPath());
                    throw new JsonParseException(m7065u.toString(), e);
                }
            }
        };
        BIG_DECIMAL = toNumberPolicy4;
        f15715a = new ToNumberPolicy[]{toNumberPolicy, toNumberPolicy2, toNumberPolicy3, toNumberPolicy4};
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) f15715a.clone();
    }
}
