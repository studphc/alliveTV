package p000;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import java.io.Writer;
import java.util.Objects;

/* renamed from: ye */
/* loaded from: classes2.dex */
public final class C2017ye extends Writer {

    /* renamed from: a */
    public final /* synthetic */ int f28920a;

    /* renamed from: b */
    public final Object f28921b;

    /* renamed from: c */
    public final Object f28922c;

    public C2017ye() {
        this.f28920a = 1;
        this.f28922c = new StringBuilder(128);
        this.f28921b = FragmentManager.TAG;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        switch (this.f28920a) {
            case 2:
                ((Appendable) this.f28921b).append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    /* renamed from: c */
    public void m8277c() {
        StringBuilder sb = (StringBuilder) this.f28922c;
        if (sb.length() > 0) {
            Log.d((String) this.f28921b, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f28920a) {
            case 0:
                ((Writer) this.f28922c).close();
                return;
            case 1:
                m8277c();
                return;
            default:
                return;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        switch (this.f28920a) {
            case 0:
                ((Writer) this.f28922c).flush();
                return;
            case 1:
                m8277c();
                return;
            default:
                return;
        }
    }

    @Override // java.io.Writer
    public void write(int i) {
        switch (this.f28920a) {
            case 0:
                ((C1980xe) this.f28921b).append((char) i);
                return;
            case 1:
            default:
                super.write(i);
                return;
            case 2:
                ((Appendable) this.f28921b).append((char) i);
                return;
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(CharSequence charSequence) {
        switch (this.f28920a) {
            case 2:
                ((Appendable) this.f28921b).append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        switch (this.f28920a) {
            case 2:
                ((Appendable) this.f28921b).append(charSequence, i, i2);
                return this;
            default:
                return super.append(charSequence, i, i2);
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        switch (this.f28920a) {
            case 2:
                Objects.requireNonNull(str);
                ((Appendable) this.f28921b).append(str, i, i2 + i);
                return;
            default:
                super.write(str, i, i2);
                return;
        }
    }

    public C2017ye(Appendable appendable) {
        this.f28920a = 2;
        this.f28922c = new Object();
        this.f28921b = appendable;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i, int i2) {
        switch (this.f28920a) {
            case 2:
                ((Appendable) this.f28921b).append(charSequence, i, i2);
                return this;
            default:
                return super.append(charSequence, i, i2);
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        switch (this.f28920a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                for (int i3 = 0; i3 < i2; i3++) {
                    char c = cArr[i + i3];
                    if (c == '\n') {
                        m8277c();
                    } else {
                        ((StringBuilder) this.f28922c).append(c);
                    }
                }
                return;
            default:
                fo2 fo2Var = (fo2) this.f28922c;
                fo2Var.f17355a = cArr;
                fo2Var.f17356b = null;
                ((Appendable) this.f28921b).append(fo2Var, i, i2 + i);
                return;
        }
    }

    public C2017ye(C1980xe c1980xe, Writer writer) {
        this.f28920a = 0;
        this.f28921b = c1980xe;
        this.f28922c = writer;
    }

    /* renamed from: a */
    private final void m8275a() {
    }

    /* renamed from: b */
    private final void m8276b() {
    }
}
