package p000;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* renamed from: ua */
/* loaded from: classes2.dex */
public final class C1865ua extends Writer {

    /* renamed from: a */
    public final Appendable f27162a;

    /* renamed from: b */
    public boolean f27163b;

    public C1865ua(Appendable appendable) {
        this.f27162a = (Appendable) Preconditions.checkNotNull(appendable);
    }

    /* renamed from: a */
    public final void m7684a() {
        if (!this.f27163b) {
        } else {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(char c) {
        append(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f27163b = true;
        Appendable appendable = this.f27162a;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        m7684a();
        Appendable appendable = this.f27162a;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        m7684a();
        this.f27162a.append(new String(cArr, i, i2));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) {
        append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i) {
        m7684a();
        this.f27162a.append((char) i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c) {
        m7684a();
        this.f27162a.append(c);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        Preconditions.checkNotNull(str);
        m7684a();
        this.f27162a.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        m7684a();
        this.f27162a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i, int i2) {
        m7684a();
        this.f27162a.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i, int i2) {
        Preconditions.checkNotNull(str);
        m7684a();
        this.f27162a.append(str, i, i2 + i);
    }
}
