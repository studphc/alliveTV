package p000;

import com.google.common.io.C0967a;
import com.google.common.io.C0972f;
import java.io.OutputStream;
import java.io.Writer;

/* renamed from: ze */
/* loaded from: classes2.dex */
public final class C2054ze extends OutputStream {

    /* renamed from: a */
    public int f29329a = 0;

    /* renamed from: b */
    public int f29330b = 0;

    /* renamed from: c */
    public int f29331c = 0;

    /* renamed from: d */
    public final /* synthetic */ Writer f29332d;

    /* renamed from: e */
    public final /* synthetic */ C0972f f29333e;

    public C2054ze(C0972f c0972f, Writer writer) {
        this.f29333e = c0972f;
        this.f29332d = writer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.f29330b;
        Writer writer = this.f29332d;
        if (i > 0) {
            int i2 = this.f29329a;
            C0972f c0972f = this.f29333e;
            C0967a c0967a = c0972f.f15110f;
            writer.write(c0967a.f15093b[(i2 << (c0967a.f15095d - i)) & c0967a.f15094c]);
            this.f29331c++;
            if (c0972f.f15111g != null) {
                while (this.f29331c % c0972f.f15110f.f15096e != 0) {
                    writer.write(c0972f.f15111g.charValue());
                    this.f29331c++;
                }
            }
        }
        writer.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f29332d.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f29329a = (i & 255) | (this.f29329a << 8);
        this.f29330b += 8;
        while (true) {
            int i2 = this.f29330b;
            C0972f c0972f = this.f29333e;
            C0967a c0967a = c0972f.f15110f;
            int i3 = c0967a.f15095d;
            if (i2 >= i3) {
                this.f29332d.write(c0967a.f15093b[(this.f29329a >> (i2 - i3)) & c0967a.f15094c]);
                this.f29331c++;
                this.f29330b -= c0972f.f15110f.f15095d;
            } else {
                return;
            }
        }
    }
}
