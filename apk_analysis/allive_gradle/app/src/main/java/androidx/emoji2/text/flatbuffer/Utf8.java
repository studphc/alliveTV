package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class Utf8 {

    /* renamed from: a */
    public static Utf8 f4287a;

    public static Utf8 getDefault() {
        if (f4287a == null) {
            f4287a = new Utf8Safe();
        }
        return f4287a;
    }

    public static void setDefault(Utf8 utf8) {
        f4287a = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i, int i2);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
