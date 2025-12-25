package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import p000.ww0;
import p000.ye0;

/* loaded from: classes.dex */
public class GifHeaderParser {

    /* renamed from: b */
    public ByteBuffer f8588b;

    /* renamed from: c */
    public GifHeader f8589c;

    /* renamed from: a */
    public final byte[] f8587a = new byte[256];

    /* renamed from: d */
    public int f8590d = 0;

    /* renamed from: a */
    public final boolean m2300a() {
        if (this.f8589c.f8576b != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final int m2301b() {
        try {
            return this.f8588b.get() & 255;
        } catch (Exception unused) {
            this.f8589c.f8576b = 1;
            return 0;
        }
    }

    /* renamed from: c */
    public final void m2302c() {
        int m2301b = m2301b();
        this.f8590d = m2301b;
        if (m2301b > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    i2 = this.f8590d;
                    if (i < i2) {
                        i2 -= i;
                        this.f8588b.get(this.f8587a, i, i2);
                        i += i2;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder m8302v = ye0.m8302v("Error Reading Block n: ", i, " count: ", i2, " blockSize: ");
                        m8302v.append(this.f8590d);
                        Log.d("GifHeaderParser", m8302v.toString(), e);
                    }
                    this.f8589c.f8576b = 1;
                    return;
                }
            }
        }
    }

    public void clear() {
        this.f8588b = null;
        this.f8589c = null;
    }

    /* renamed from: d */
    public final int[] m2303d(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f8588b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i5] & 255);
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f8589c.f8576b = 1;
        }
        return iArr;
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [ww0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v25, types: [ww0, java.lang.Object] */
    /* renamed from: e */
    public final void m2304e(int i) {
        boolean z;
        boolean z2;
        byte[] bArr;
        boolean z3 = false;
        while (!z3 && !m2300a() && this.f8589c.f8577c <= i) {
            int m2301b = m2301b();
            boolean z4 = true;
            if (m2301b != 33) {
                if (m2301b != 44) {
                    if (m2301b != 59) {
                        this.f8589c.f8576b = 1;
                    } else {
                        z3 = true;
                    }
                } else {
                    GifHeader gifHeader = this.f8589c;
                    if (gifHeader.f8578d == null) {
                        gifHeader.f8578d = new Object();
                    }
                    gifHeader.f8578d.f28357a = this.f8588b.getShort();
                    this.f8589c.f8578d.f28358b = this.f8588b.getShort();
                    this.f8589c.f8578d.f28359c = this.f8588b.getShort();
                    this.f8589c.f8578d.f28360d = this.f8588b.getShort();
                    int m2301b2 = m2301b();
                    if ((m2301b2 & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int pow = (int) Math.pow(2.0d, (m2301b2 & 7) + 1);
                    ww0 ww0Var = this.f8589c.f8578d;
                    if ((m2301b2 & 64) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ww0Var.f28361e = z2;
                    if (z) {
                        ww0Var.f28367k = m2303d(pow);
                    } else {
                        ww0Var.f28367k = null;
                    }
                    this.f8589c.f8578d.f28366j = this.f8588b.position();
                    m2301b();
                    m2306g();
                    if (!m2300a()) {
                        GifHeader gifHeader2 = this.f8589c;
                        gifHeader2.f8577c++;
                        gifHeader2.f8579e.add(gifHeader2.f8578d);
                    }
                }
            } else {
                int m2301b3 = m2301b();
                if (m2301b3 != 1) {
                    if (m2301b3 != 249) {
                        if (m2301b3 != 254) {
                            if (m2301b3 != 255) {
                                m2306g();
                            } else {
                                m2302c();
                                StringBuilder sb = new StringBuilder();
                                int i2 = 0;
                                while (true) {
                                    bArr = this.f8587a;
                                    if (i2 >= 11) {
                                        break;
                                    }
                                    sb.append((char) bArr[i2]);
                                    i2++;
                                }
                                if (sb.toString().equals("NETSCAPE2.0")) {
                                    do {
                                        m2302c();
                                        if (bArr[0] == 1) {
                                            this.f8589c.f8586l = (bArr[1] & 255) | ((bArr[2] & 255) << 8);
                                        }
                                        if (this.f8590d > 0) {
                                        }
                                    } while (!m2300a());
                                } else {
                                    m2306g();
                                }
                            }
                        } else {
                            m2306g();
                        }
                    } else {
                        this.f8589c.f8578d = new Object();
                        m2301b();
                        int m2301b4 = m2301b();
                        ww0 ww0Var2 = this.f8589c.f8578d;
                        int i3 = (m2301b4 & 28) >> 2;
                        ww0Var2.f28363g = i3;
                        if (i3 == 0) {
                            ww0Var2.f28363g = 1;
                        }
                        if ((m2301b4 & 1) == 0) {
                            z4 = false;
                        }
                        ww0Var2.f28362f = z4;
                        short s = this.f8588b.getShort();
                        if (s < 2) {
                            s = 10;
                        }
                        ww0 ww0Var3 = this.f8589c.f8578d;
                        ww0Var3.f28365i = s * 10;
                        ww0Var3.f28364h = m2301b();
                        m2301b();
                    }
                } else {
                    m2306g();
                }
            }
        }
    }

    /* renamed from: f */
    public final void m2305f() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < 6; i++) {
            sb.append((char) m2301b());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f8589c.f8576b = 1;
            return;
        }
        this.f8589c.f8580f = this.f8588b.getShort();
        this.f8589c.f8581g = this.f8588b.getShort();
        int m2301b = m2301b();
        GifHeader gifHeader = this.f8589c;
        if ((m2301b & 128) != 0) {
            z = true;
        }
        gifHeader.f8582h = z;
        gifHeader.f8583i = (int) Math.pow(2.0d, (m2301b & 7) + 1);
        this.f8589c.f8584j = m2301b();
        GifHeader gifHeader2 = this.f8589c;
        m2301b();
        gifHeader2.getClass();
        if (this.f8589c.f8582h && !m2300a()) {
            GifHeader gifHeader3 = this.f8589c;
            gifHeader3.f8575a = m2303d(gifHeader3.f8583i);
            GifHeader gifHeader4 = this.f8589c;
            gifHeader4.f8585k = gifHeader4.f8575a[gifHeader4.f8584j];
        }
    }

    /* renamed from: g */
    public final void m2306g() {
        int m2301b;
        do {
            m2301b = m2301b();
            this.f8588b.position(Math.min(this.f8588b.position() + m2301b, this.f8588b.limit()));
        } while (m2301b > 0);
    }

    public boolean isAnimated() {
        m2305f();
        if (!m2300a()) {
            m2304e(2);
        }
        if (this.f8589c.f8577c > 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.f8588b != null) {
            if (m2300a()) {
                return this.f8589c;
            }
            m2305f();
            if (!m2300a()) {
                m2304e(Integer.MAX_VALUE);
                GifHeader gifHeader = this.f8589c;
                if (gifHeader.f8577c < 0) {
                    gifHeader.f8576b = 1;
                }
            }
            return this.f8589c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.f8588b = null;
            this.f8589c.f8576b = 2;
        }
        return this;
    }

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        this.f8588b = null;
        Arrays.fill(this.f8587a, (byte) 0);
        this.f8589c = new GifHeader();
        this.f8590d = 0;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f8588b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f8588b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
