package com.facebook.android.crypto.keychain;

import android.os.Build;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandomSpi;

/* loaded from: classes.dex */
public class SecureRandomFix {

    /* renamed from: a */
    public static boolean f9190a;

    /* loaded from: classes.dex */
    public static class FixException extends RuntimeException {
        public FixException(Throwable th) {
            super("Error fixing the Android's SecureRandom", th);
        }
    }

    /* loaded from: classes.dex */
    public static class LinuxPRNGSecureRandom extends SecureRandomSpi {

        /* renamed from: b */
        public static final File f9191b = new File("/dev/urandom");

        /* renamed from: c */
        public static final Object f9192c = new Object();

        /* renamed from: d */
        public static DataInputStream f9193d;

        /* renamed from: e */
        public static FileOutputStream f9194e;

        /* renamed from: a */
        public boolean f9195a;

        /* renamed from: a */
        public static DataInputStream m2402a() {
            DataInputStream dataInputStream;
            synchronized (f9192c) {
                if (f9193d == null) {
                    try {
                        f9193d = new DataInputStream(new FileInputStream(f9191b));
                    } catch (IOException e) {
                        throw new SecurityException("Failed to open " + f9191b + " for reading", e);
                    }
                }
                dataInputStream = f9193d;
            }
            return dataInputStream;
        }

        /* renamed from: b */
        public static OutputStream m2403b() {
            FileOutputStream fileOutputStream;
            synchronized (f9192c) {
                if (f9194e == null) {
                    try {
                        f9194e = new FileOutputStream(f9191b);
                    } catch (IOException e) {
                        throw new SecurityException("Failed to open " + f9191b + " for writing", e);
                    }
                }
                fileOutputStream = f9194e;
            }
            return fileOutputStream;
        }

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i) {
            byte[] bArr = new byte[i];
            engineNextBytes(bArr);
            return bArr;
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            DataInputStream m2402a;
            if (!this.f9195a) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeLong(System.currentTimeMillis());
                    dataOutputStream.writeLong(System.nanoTime());
                    dataOutputStream.writeInt(Process.myPid());
                    dataOutputStream.writeInt(Process.myUid());
                    dataOutputStream.write(SecureRandomFix.m2401a());
                    dataOutputStream.close();
                    engineSetSeed(byteArrayOutputStream.toByteArray());
                } catch (IOException e) {
                    throw new SecurityException("Failed to generate seed", e);
                }
            }
            try {
                synchronized (f9192c) {
                    m2402a = m2402a();
                }
                synchronized (m2402a) {
                    m2402a.readFully(bArr);
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read from " + f9191b, e2);
            }
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            OutputStream m2403b;
            try {
                synchronized (f9192c) {
                    m2403b = m2403b();
                }
                m2403b.write(bArr);
                m2403b.flush();
            } catch (Throwable unused) {
            }
            this.f9195a = true;
        }
    }

    /* renamed from: a */
    public static byte[] m2401a() {
        StringBuilder sb = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            sb.append(str);
        }
        String str2 = null;
        try {
            str2 = (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception unused) {
        }
        if (str2 != null) {
            sb.append(str2);
        }
        try {
            return sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused2) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }

    public static synchronized void tryApplyFixes() {
        synchronized (SecureRandomFix.class) {
            if (f9190a) {
                return;
            }
            f9190a = true;
        }
    }
}
