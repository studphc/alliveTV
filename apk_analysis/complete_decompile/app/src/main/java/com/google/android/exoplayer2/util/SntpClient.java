package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import p000.ye0;

/* loaded from: classes.dex */
public final class SntpClient {
    public static final String DEFAULT_NTP_HOST = "time.android.com";

    /* renamed from: a */
    public static final Object f12757a = new Object();

    /* renamed from: b */
    public static final Object f12758b = new Object();

    /* renamed from: c */
    public static boolean f12759c = false;

    /* renamed from: d */
    public static long f12760d = 0;

    /* renamed from: e */
    public static String f12761e = "time.android.com";

    /* loaded from: classes.dex */
    public interface InitializationCallback {
        void onInitializationFailed(IOException iOException);

        void onInitialized();
    }

    /* renamed from: a */
    public static long m3039a() {
        DatagramSocket datagramSocket;
        long j;
        InetAddress byName = InetAddress.getByName(getNtpHost());
        DatagramSocket datagramSocket2 = new DatagramSocket();
        try {
            datagramSocket2.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = Ascii.ESC;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (currentTimeMillis == 0) {
                Arrays.fill(bArr, 40, 48, (byte) 0);
                j = currentTimeMillis;
                datagramSocket = datagramSocket2;
            } else {
                long j2 = currentTimeMillis / 1000;
                Long.signum(j2);
                long j3 = currentTimeMillis - (j2 * 1000);
                long j4 = j2 + 2208988800L;
                j = currentTimeMillis;
                bArr[40] = (byte) (j4 >> 24);
                bArr[41] = (byte) (j4 >> 16);
                datagramSocket = datagramSocket2;
                try {
                    bArr[42] = (byte) (j4 >> 8);
                    bArr[43] = (byte) j4;
                    long j5 = (j3 * 4294967296L) / 1000;
                    bArr[44] = (byte) (j5 >> 24);
                    bArr[45] = (byte) (j5 >> 16);
                    bArr[46] = (byte) (j5 >> 8);
                    bArr[47] = (byte) (Math.random() * 255.0d);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    try {
                        datagramSocket.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            long j6 = (elapsedRealtime2 - elapsedRealtime) + j;
            byte b = bArr[0];
            int i = bArr[1] & 255;
            long m3042d = m3042d(24, bArr);
            long m3042d2 = m3042d(32, bArr);
            long m3042d3 = m3042d(40, bArr);
            m3040b((byte) ((b >> 6) & 3), (byte) (b & 7), i, m3042d3);
            long j7 = (j6 + (((m3042d3 - j6) + (m3042d2 - m3042d)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j7;
        } catch (Throwable th4) {
            th = th4;
            datagramSocket = datagramSocket2;
        }
    }

    /* renamed from: b */
    public static void m3040b(byte b, byte b2, int i, long j) {
        if (b != 3) {
            if (b2 != 4 && b2 != 5) {
                throw new IOException(ye0.m8291k(b2, "SNTP: Untrusted mode: "));
            }
            if (i != 0 && i <= 15) {
                if (j != 0) {
                    return;
                } else {
                    throw new IOException("SNTP: Zero transmitTime");
                }
            }
            throw new IOException(ye0.m8291k(i, "SNTP: Untrusted stratum: "));
        }
        throw new IOException("SNTP: Unsynchronized server");
    }

    /* renamed from: c */
    public static long m3041c(int i, byte[] bArr) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    /* renamed from: d */
    public static long m3042d(int i, byte[] bArr) {
        long m3041c = m3041c(i, bArr);
        long m3041c2 = m3041c(i + 4, bArr);
        if (m3041c == 0 && m3041c2 == 0) {
            return 0L;
        }
        return ((m3041c2 * 1000) / 4294967296L) + ((m3041c - 2208988800L) * 1000);
    }

    public static long getElapsedRealtimeOffsetMs() {
        long j;
        synchronized (f12758b) {
            try {
                if (f12759c) {
                    j = f12760d;
                } else {
                    j = C0643C.TIME_UNSET;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public static String getNtpHost() {
        String str;
        synchronized (f12758b) {
            str = f12761e;
        }
        return str;
    }

    public static void initialize(@Nullable Loader loader, @Nullable InitializationCallback initializationCallback) {
        if (isInitialized()) {
            if (initializationCallback != null) {
                initializationCallback.onInitialized();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.startLoading(new Object(), new C0738c(initializationCallback), 1);
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (f12758b) {
            z = f12759c;
        }
        return z;
    }

    public static void setNtpHost(String str) {
        synchronized (f12758b) {
            try {
                if (!f12761e.equals(str)) {
                    f12761e = str;
                    f12759c = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
