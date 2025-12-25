package p000;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class s72 {

    /* renamed from: a */
    public final int f26307a;

    /* renamed from: b */
    public final int f26308b;

    /* renamed from: c */
    public final long f26309c;

    /* renamed from: d */
    public final long f26310d;

    public s72(int i, long j, int i2, long j2) {
        this.f26307a = i;
        this.f26308b = i2;
        this.f26309c = j;
        this.f26310d = j2;
    }

    /* renamed from: a */
    public static s72 m7346a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            s72 s72Var = new s72(dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readInt(), dataInputStream.readLong());
            dataInputStream.close();
            return s72Var;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: b */
    public final void m7347b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f26307a);
            dataOutputStream.writeInt(this.f26308b);
            dataOutputStream.writeLong(this.f26309c);
            dataOutputStream.writeLong(this.f26310d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof s72)) {
            return false;
        }
        s72 s72Var = (s72) obj;
        if (this.f26308b == s72Var.f26308b && this.f26309c == s72Var.f26309c && this.f26307a == s72Var.f26307a && this.f26310d == s72Var.f26310d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f26308b), Long.valueOf(this.f26309c), Integer.valueOf(this.f26307a), Long.valueOf(this.f26310d));
    }
}
