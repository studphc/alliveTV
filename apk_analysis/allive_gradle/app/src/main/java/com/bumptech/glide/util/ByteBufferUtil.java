package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
import p000.C0595cj;
import p000.d13;

/* loaded from: classes.dex */
public final class ByteBufferUtil {

    /* renamed from: a */
    public static final AtomicReference f9158a = new AtomicReference();

    @NonNull
    public static ByteBuffer fromFile(@NonNull File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                throw th;
                            } catch (IOException unused4) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static ByteBuffer fromStream(@NonNull InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        AtomicReference atomicReference = f9158a;
        byte[] bArr = (byte[]) atomicReference.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                atomicReference.set(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    @NonNull
    public static byte[] toBytes(@NonNull ByteBuffer byteBuffer) {
        d13 d13Var;
        if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
            d13Var = new d13(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        } else {
            d13Var = null;
        }
        if (d13Var != null && d13Var.f16214a == 0) {
            if (d13Var.f16215b == d13Var.f16216c.length) {
                return byteBuffer.array();
            }
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void toFile(@NonNull ByteBuffer byteBuffer, @NonNull File file) {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static InputStream toStream(@NonNull ByteBuffer byteBuffer) {
        return new C0595cj(byteBuffer);
    }

    public static void toStream(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) {
        d13 d13Var = (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) ? null : new d13(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        if (d13Var != null) {
            int i = d13Var.f16214a;
            outputStream.write(d13Var.f16216c, i, d13Var.f16215b + i);
            return;
        }
        AtomicReference atomicReference = f9158a;
        byte[] bArr = (byte[]) atomicReference.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), bArr.length);
            byteBuffer.get(bArr, 0, min);
            outputStream.write(bArr, 0, min);
        }
        atomicReference.set(bArr);
    }
}
