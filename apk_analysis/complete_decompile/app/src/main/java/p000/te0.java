package p000;

import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class te0 extends InputStream {

    /* renamed from: a */
    public ByteBuffer f26784a;

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f26784a.get() & 255;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }
}
