package androidx.core.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.Writer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class LogWriter extends Writer {

    /* renamed from: a */
    public final String f3818a;

    /* renamed from: b */
    public final StringBuilder f3819b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f3818a = str;
    }

    /* renamed from: a */
    public final void m896a() {
        StringBuilder sb = this.f3819b;
        if (sb.length() > 0) {
            Log.d(this.f3818a, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m896a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m896a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m896a();
            } else {
                this.f3819b.append(c);
            }
        }
    }
}
