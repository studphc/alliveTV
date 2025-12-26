package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class BaseVector {

    /* renamed from: a */
    public int f4242a;

    /* renamed from: b */
    public int f4243b;

    /* renamed from: bb */
    protected ByteBuffer f4244bb;

    /* renamed from: c */
    public int f4245c;

    public int __element(int i) {
        return (i * this.f4245c) + this.f4242a;
    }

    public void __reset(int i, int i2, ByteBuffer byteBuffer) {
        this.f4244bb = byteBuffer;
        if (byteBuffer != null) {
            this.f4242a = i;
            this.f4243b = byteBuffer.getInt(i - 4);
            this.f4245c = i2;
        } else {
            this.f4242a = 0;
            this.f4243b = 0;
            this.f4245c = 0;
        }
    }

    public int __vector() {
        return this.f4242a;
    }

    public int length() {
        return this.f4243b;
    }

    public void reset() {
        __reset(0, 0, null);
    }
}
