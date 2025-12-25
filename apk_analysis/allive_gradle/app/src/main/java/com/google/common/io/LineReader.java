package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import javax.annotation.CheckForNull;
import p000.C1904vc;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class LineReader {

    /* renamed from: a */
    public final Readable f15085a;

    /* renamed from: b */
    public final Reader f15086b;

    /* renamed from: c */
    public final CharBuffer f15087c;

    /* renamed from: d */
    public final char[] f15088d;

    /* renamed from: e */
    public final ArrayDeque f15089e;

    /* renamed from: f */
    public final C1904vc f15090f;

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, vc] */
    public LineReader(Readable readable) {
        Reader reader;
        CharBuffer allocate = CharBuffer.allocate(2048);
        this.f15087c = allocate;
        this.f15088d = allocate.array();
        this.f15089e = new ArrayDeque();
        ?? obj = new Object();
        obj.f27736c = this;
        obj.f27735b = new StringBuilder();
        this.f15090f = obj;
        this.f15085a = (Readable) Preconditions.checkNotNull(readable);
        if (readable instanceof Reader) {
            reader = (Reader) readable;
        } else {
            reader = null;
        }
        this.f15086b = reader;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    @CanIgnoreReturnValue
    @CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readLine() {
        ArrayDeque arrayDeque;
        int read;
        int i;
        boolean z;
        boolean z2;
        while (true) {
            arrayDeque = this.f15089e;
            if (arrayDeque.peek() != null) {
                break;
            }
            CharBuffer charBuffer = this.f15087c;
            charBuffer.clear();
            char[] cArr = this.f15088d;
            Reader reader = this.f15086b;
            if (reader != null) {
                read = reader.read(cArr, 0, cArr.length);
            } else {
                read = this.f15085a.read(charBuffer);
            }
            C1904vc c1904vc = this.f15090f;
            if (read == -1) {
                if (c1904vc.f27734a || ((StringBuilder) c1904vc.f27735b).length() > 0) {
                    c1904vc.m7899a(false);
                }
            } else {
                if (c1904vc.f27734a && read > 0) {
                    if (cArr[0] == '\n') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    c1904vc.m7899a(z2);
                    if (z2) {
                        i = 1;
                        int i2 = i;
                        while (i < read) {
                            char c = cArr[i];
                            if (c != '\n') {
                                if (c == '\r') {
                                    ((StringBuilder) c1904vc.f27735b).append(cArr, i2, i - i2);
                                    c1904vc.f27734a = true;
                                    int i3 = i + 1;
                                    if (i3 < read) {
                                        if (cArr[i3] == '\n') {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        c1904vc.m7899a(z);
                                        if (z) {
                                            i = i3;
                                        }
                                    }
                                } else {
                                    i++;
                                }
                            } else {
                                ((StringBuilder) c1904vc.f27735b).append(cArr, i2, i - i2);
                                c1904vc.m7899a(true);
                            }
                            i2 = i + 1;
                            i++;
                        }
                        ((StringBuilder) c1904vc.f27735b).append(cArr, i2, read - i2);
                    }
                }
                i = 0;
                int i22 = i;
                while (i < read) {
                }
                ((StringBuilder) c1904vc.f27735b).append(cArr, i22, read - i22);
            }
        }
        return (String) arrayDeque.poll();
    }
}
