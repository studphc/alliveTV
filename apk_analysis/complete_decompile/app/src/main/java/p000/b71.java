package p000;

import com.google.gson.stream.JsonToken;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class b71 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f7912a;

    static {
        int[] iArr = new int[JsonToken.values().length];
        f7912a = iArr;
        try {
            iArr[JsonToken.NAME.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7912a[JsonToken.END_ARRAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7912a[JsonToken.END_OBJECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7912a[JsonToken.END_DOCUMENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
