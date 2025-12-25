package p000;

import com.google.gson.stream.JsonToken;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class mx2 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f23156a;

    static {
        int[] iArr = new int[JsonToken.values().length];
        f23156a = iArr;
        try {
            iArr[JsonToken.NUMBER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f23156a[JsonToken.STRING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f23156a[JsonToken.BOOLEAN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f23156a[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f23156a[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f23156a[JsonToken.NULL.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
