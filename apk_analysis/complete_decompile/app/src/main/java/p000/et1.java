package p000;

import com.google.gson.stream.JsonToken;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class et1 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f16979a;

    static {
        int[] iArr = new int[JsonToken.values().length];
        f16979a = iArr;
        try {
            iArr[JsonToken.NULL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16979a[JsonToken.NUMBER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16979a[JsonToken.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
