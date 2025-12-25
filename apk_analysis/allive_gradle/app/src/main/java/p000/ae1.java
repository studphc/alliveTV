package p000;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class ae1 extends lp2 implements Serializable, td1 {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f22633c = 0;
        this.f22631a = null;
        this.f22632b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(mo79b());
    }

    @Override // p000.td1
    /* renamed from: a */
    public final void mo78a() {
        mo80c(1L);
    }

    @Override // p000.td1
    /* renamed from: b */
    public final long mo79b() {
        long j = this.f22632b;
        jp2[] jp2VarArr = this.f22631a;
        if (jp2VarArr != null) {
            for (jp2 jp2Var : jp2VarArr) {
                if (jp2Var != null) {
                    j += jp2Var.f20582a;
                }
            }
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x00b3, code lost:
    
        if (r13.f22631a != r6) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00b5, code lost:
    
        r5 = new p000.jp2[r7 << 1];
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00ba, code lost:
    
        if (r8 >= r7) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00bc, code lost:
    
        r5[r8] = r6[r8];
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00c5, code lost:
    
        r13.f22631a = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0049 A[SYNTHETIC] */
    @Override // p000.td1
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo80c(long j) {
        boolean z;
        int i;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        int length3;
        jp2 jp2Var;
        jp2[] jp2VarArr = this.f22631a;
        if (jp2VarArr == null) {
            long j2 = this.f22632b;
            if (m5972e(j2, j2 + j)) {
                return;
            }
        }
        ThreadLocal threadLocal = lp2.f22625d;
        int[] iArr = (int[]) threadLocal.get();
        if (iArr != null && jp2VarArr != null && (length3 = jp2VarArr.length) >= 1 && (jp2Var = jp2VarArr[(length3 - 1) & iArr[0]]) != null) {
            long j3 = jp2Var.f20582a;
            z = jp2Var.m5449a(j3, j3 + j);
            if (z) {
                return;
            }
        } else {
            z = true;
        }
        if (iArr == null) {
            iArr = new int[1];
            threadLocal.set(iArr);
            i = lp2.f22626e.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr[0] = i;
        } else {
            i = iArr[0];
        }
        while (true) {
            boolean z4 = false;
            while (true) {
                jp2[] jp2VarArr2 = this.f22631a;
                if (jp2VarArr2 != null && (length = jp2VarArr2.length) > 0) {
                    jp2 jp2Var2 = jp2VarArr2[(length - 1) & i];
                    if (jp2Var2 == null) {
                        if (this.f22633c == 0) {
                            jp2 jp2Var3 = new jp2(j);
                            if (this.f22633c == 0 && m5973f()) {
                                try {
                                    jp2[] jp2VarArr3 = this.f22631a;
                                    if (jp2VarArr3 != null && (length2 = jp2VarArr3.length) > 0) {
                                        int i2 = (length2 - 1) & i;
                                        if (jp2VarArr3[i2] == null) {
                                            jp2VarArr3[i2] = jp2Var3;
                                            z3 = true;
                                            if (!z3) {
                                                return;
                                            }
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                    }
                                } finally {
                                }
                            }
                        }
                    } else {
                        if (!z) {
                            z = true;
                        } else {
                            long j4 = jp2Var2.f20582a;
                            if (!jp2Var2.m5449a(j4, j4 + j)) {
                                if (length < lp2.f22627f && this.f22631a == jp2VarArr2) {
                                    if (!z4) {
                                        z4 = true;
                                    } else if (this.f22633c == 0 && m5973f()) {
                                        try {
                                            break;
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        int i3 = i ^ (i << 13);
                        int i4 = i3 ^ (i3 >>> 17);
                        i = i4 ^ (i4 << 5);
                        iArr[0] = i;
                    }
                    z4 = false;
                    int i32 = i ^ (i << 13);
                    int i42 = i32 ^ (i32 >>> 17);
                    i = i42 ^ (i42 << 5);
                    iArr[0] = i;
                } else if (this.f22633c == 0 && this.f22631a == jp2VarArr2 && m5973f()) {
                    try {
                        if (this.f22631a == jp2VarArr2) {
                            jp2[] jp2VarArr4 = new jp2[2];
                            jp2VarArr4[i & 1] = new jp2(j);
                            this.f22631a = jp2VarArr4;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            return;
                        }
                    } finally {
                    }
                } else {
                    long j5 = this.f22632b;
                    if (m5972e(j5, j5 + j)) {
                        return;
                    }
                }
            }
        }
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return mo79b();
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) mo79b();
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) mo79b();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return mo79b();
    }

    public final String toString() {
        return Long.toString(mo79b());
    }
}
