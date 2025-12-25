package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import p000.C1356jj;
import p000.C1393kj;
import p000.C1513lj;
import p000.C1550mj;
import p000.ye0;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class ByteStreams {

    /* renamed from: a */
    public static final C1356jj f15067a = new OutputStream();

    /* renamed from: a */
    public static byte[] m4198a(ArrayDeque arrayDeque, int i) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i) {
            return bArr;
        }
        int length = i - bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, i);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int min = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i - length, min);
            length -= min;
        }
        return copyOf;
    }

    /* renamed from: b */
    public static long m4199b(InputStream inputStream, long j) {
        long skip;
        byte[] bArr = null;
        long j2 = 0;
        while (j2 < j) {
            long j3 = j - j2;
            int available = inputStream.available();
            if (available == 0) {
                skip = 0;
            } else {
                skip = inputStream.skip(Math.min(available, j3));
            }
            if (skip == 0) {
                int min = (int) Math.min(j3, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                skip = inputStream.read(bArr, 0, min);
                if (skip == -1) {
                    break;
                }
            }
            j2 += skip;
        }
        return j2;
    }

    /* renamed from: c */
    public static byte[] m4200c(InputStream inputStream, long j) {
        boolean z;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "expectedSize (%s) must be non-negative", j);
        if (j <= 2147483639) {
            int i = (int) j;
            byte[] bArr = new byte[i];
            int i2 = i;
            while (i2 > 0) {
                int i3 = i - i2;
                int read = inputStream.read(bArr, i3, i2);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i3);
                }
                i2 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return m4201d(inputStream, arrayDeque, i + 1);
        }
        StringBuilder sb = new StringBuilder(62);
        sb.append(j);
        sb.append(" bytes is too large to fit in a byte array");
        throw new OutOfMemoryError(sb.toString());
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    /* renamed from: d */
    public static byte[] m4201d(InputStream inputStream, ArrayDeque arrayDeque, int i) {
        int i2;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i) * 2));
        while (i < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i);
            byte[] bArr = new byte[min2];
            arrayDeque.add(bArr);
            int i3 = 0;
            while (i3 < min2) {
                int read = inputStream.read(bArr, i3, min2 - i3);
                if (read == -1) {
                    return m4198a(arrayDeque, i);
                }
                i3 += read;
                i += read;
            }
            if (min < 4096) {
                i2 = 4;
            } else {
                i2 = 2;
            }
            min = IntMath.saturatedMultiply(min, i2);
        }
        if (inputStream.read() == -1) {
            return m4198a(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(InputStream inputStream) {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            long read = inputStream.read(bArr);
            if (read != -1) {
                j += read;
            } else {
                return j;
            }
        }
    }

    @Beta
    public static InputStream limit(InputStream inputStream, long j) {
        return new C1550mj(inputStream, j);
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    @Beta
    public static OutputStream nullOutputStream() {
        return f15067a;
    }

    @CanIgnoreReturnValue
    @Beta
    public static int read(InputStream inputStream, byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        if (i2 >= 0) {
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, i + i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            }
            return i3;
        }
        throw new IndexOutOfBoundsException(ye0.m8292l(i2, "len (", ") cannot be negative"));
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) {
        int read;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] bArr = new byte[8192];
        do {
            read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
        } while (byteProcessor.processBytes(bArr, 0, read));
        return byteProcessor.getResult();
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr) {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    @Beta
    public static void skipFully(InputStream inputStream, long j) {
        long m4199b = m4199b(inputStream, j);
        if (m4199b >= j) {
            return;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append("reached end of stream after skipping ");
        sb.append(m4199b);
        sb.append(" bytes; ");
        throw new EOFException(ye0.m8297q(sb, j, " bytes expected"));
    }

    public static byte[] toByteArray(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        return m4201d(inputStream, new ArrayDeque(20), 0);
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr, int i) {
        Preconditions.checkPositionIndex(i, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i, bArr.length - i));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(int i) {
        if (i >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i));
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Invalid size: "));
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr, int i, int i2) {
        int read = read(inputStream, bArr, i, i2);
        if (read == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(81);
        sb.append("reached end of stream after reading ");
        sb.append(read);
        sb.append(" bytes; ");
        sb.append(i2);
        sb.append(" bytes expected");
        throw new EOFException(sb.toString());
    }

    @Beta
    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new C1393kj((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long j = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long position = fileChannel.position();
            long j2 = position;
            while (true) {
                long transferTo = fileChannel.transferTo(j2, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel);
                j2 += transferTo;
                fileChannel.position(j2);
                if (transferTo <= 0 && j2 >= fileChannel.size()) {
                    return j2 - position;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[8192]);
            while (readableByteChannel.read(wrap) != -1) {
                wrap.flip();
                while (wrap.hasRemaining()) {
                    j += writableByteChannel.write(wrap);
                }
                wrap.clear();
            }
            return j;
        }
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new C1513lj((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }
}
