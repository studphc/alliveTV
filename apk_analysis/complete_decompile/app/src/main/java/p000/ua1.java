package p000;

import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public abstract class ua1 {

    /* renamed from: a */
    public static final Enum f27166a;

    static {
        Enum r0 = oa1.f23682a;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                    r0 = ta1.f26745a;
                } else {
                    r0 = ta1.f26746b;
                }
            }
        } catch (Throwable unused) {
        }
        f27166a = r0;
    }

    /* renamed from: a */
    public static int m7688a(int i, byte[] bArr) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }
}
