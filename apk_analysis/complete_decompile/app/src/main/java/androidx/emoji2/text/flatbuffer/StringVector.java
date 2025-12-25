package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StringVector extends BaseVector {

    /* renamed from: d */
    public final Utf8 f4281d = Utf8.getDefault();

    public StringVector __assign(int i, int i2, ByteBuffer byteBuffer) {
        __reset(i, i2, byteBuffer);
        return this;
    }

    public String get(int i) {
        return Table.__string(__element(i), this.f4244bb, this.f4281d);
    }
}
