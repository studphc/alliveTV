package p000;

import com.google.common.base.Preconditions;
import java.io.Writer;

/* renamed from: fp */
/* loaded from: classes2.dex */
public final class C1203fp extends Writer {

    /* renamed from: a */
    public static final C1203fp f17357a = new Writer();

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c) {
        return this;
    }

    public final String toString() {
        return "CharStreams.nullWriter()";
    }

    @Override // java.io.Writer
    public final void write(int i) {
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr) {
        Preconditions.checkNotNull(cArr);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) {
        append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2 + i, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        Preconditions.checkNotNull(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, charSequence == null ? 4 : charSequence.length());
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2 + i, str.length());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c) {
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
