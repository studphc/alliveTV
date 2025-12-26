package p000;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class be2 {

    /* renamed from: a */
    public final Allocator f7980a;

    /* renamed from: b */
    public final int f7981b;

    /* renamed from: c */
    public final ParsableByteArray f7982c;

    /* renamed from: d */
    public ae2 f7983d;

    /* renamed from: e */
    public ae2 f7984e;

    /* renamed from: f */
    public ae2 f7985f;

    /* renamed from: g */
    public long f7986g;

    public be2(Allocator allocator) {
        this.f7980a = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.f7981b = individualAllocationLength;
        this.f7982c = new ParsableByteArray(32);
        ae2 ae2Var = new ae2(0L, individualAllocationLength);
        this.f7983d = ae2Var;
        this.f7984e = ae2Var;
        this.f7985f = ae2Var;
    }

    /* renamed from: c */
    public static ae2 m2087c(ae2 ae2Var, long j, ByteBuffer byteBuffer, int i) {
        while (j >= ae2Var.f152b) {
            ae2Var = ae2Var.f154d;
        }
        while (i > 0) {
            int min = Math.min(i, (int) (ae2Var.f152b - j));
            Allocation allocation = ae2Var.f153c;
            byteBuffer.put(allocation.data, ((int) (j - ae2Var.f151a)) + allocation.offset, min);
            i -= min;
            j += min;
            if (j == ae2Var.f152b) {
                ae2Var = ae2Var.f154d;
            }
        }
        return ae2Var;
    }

    /* renamed from: d */
    public static ae2 m2088d(ae2 ae2Var, long j, byte[] bArr, int i) {
        while (j >= ae2Var.f152b) {
            ae2Var = ae2Var.f154d;
        }
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (ae2Var.f152b - j));
            Allocation allocation = ae2Var.f153c;
            System.arraycopy(allocation.data, ((int) (j - ae2Var.f151a)) + allocation.offset, bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == ae2Var.f152b) {
                ae2Var = ae2Var.f154d;
            }
        }
        return ae2Var;
    }

    /* renamed from: e */
    public static ae2 m2089e(ae2 ae2Var, DecoderInputBuffer decoderInputBuffer, ce2 ce2Var, ParsableByteArray parsableByteArray) {
        ae2 ae2Var2;
        boolean z;
        if (decoderInputBuffer.isEncrypted()) {
            long j = ce2Var.f8347b;
            int i = 1;
            parsableByteArray.reset(1);
            ae2 m2088d = m2088d(ae2Var, j, parsableByteArray.getData(), 1);
            long j2 = j + 1;
            byte b = parsableByteArray.getData()[0];
            if ((b & 128) != 0) {
                z = true;
            } else {
                z = false;
            }
            int i2 = b & Byte.MAX_VALUE;
            CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
            byte[] bArr = cryptoInfo.f9920iv;
            if (bArr == null) {
                cryptoInfo.f9920iv = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            ae2Var2 = m2088d(m2088d, j2, cryptoInfo.f9920iv, i2);
            long j3 = j2 + i2;
            if (z) {
                parsableByteArray.reset(2);
                ae2Var2 = m2088d(ae2Var2, j3, parsableByteArray.getData(), 2);
                j3 += 2;
                i = parsableByteArray.readUnsignedShort();
            }
            int i3 = i;
            int[] iArr = cryptoInfo.numBytesOfClearData;
            if (iArr == null || iArr.length < i3) {
                iArr = new int[i3];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = cryptoInfo.numBytesOfEncryptedData;
            if (iArr3 == null || iArr3.length < i3) {
                iArr3 = new int[i3];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i3 * 6;
                parsableByteArray.reset(i4);
                ae2Var2 = m2088d(ae2Var2, j3, parsableByteArray.getData(), i4);
                j3 += i4;
                parsableByteArray.setPosition(0);
                for (int i5 = 0; i5 < i3; i5++) {
                    iArr2[i5] = parsableByteArray.readUnsignedShort();
                    iArr4[i5] = parsableByteArray.readUnsignedIntToInt();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = ce2Var.f8346a - ((int) (j3 - ce2Var.f8347b));
            }
            TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.castNonNull(ce2Var.f8348c);
            cryptoInfo.set(i3, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo.f9920iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
            long j4 = ce2Var.f8347b;
            int i6 = (int) (j3 - j4);
            ce2Var.f8347b = j4 + i6;
            ce2Var.f8346a -= i6;
        } else {
            ae2Var2 = ae2Var;
        }
        if (decoderInputBuffer.hasSupplementalData()) {
            parsableByteArray.reset(4);
            ae2 m2088d2 = m2088d(ae2Var2, ce2Var.f8347b, parsableByteArray.getData(), 4);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            ce2Var.f8347b += 4;
            ce2Var.f8346a -= 4;
            decoderInputBuffer.ensureSpaceForWrite(readUnsignedIntToInt);
            ae2 m2087c = m2087c(m2088d2, ce2Var.f8347b, decoderInputBuffer.data, readUnsignedIntToInt);
            ce2Var.f8347b += readUnsignedIntToInt;
            int i7 = ce2Var.f8346a - readUnsignedIntToInt;
            ce2Var.f8346a = i7;
            decoderInputBuffer.resetSupplementalData(i7);
            return m2087c(m2087c, ce2Var.f8347b, decoderInputBuffer.supplementalData, ce2Var.f8346a);
        }
        decoderInputBuffer.ensureSpaceForWrite(ce2Var.f8346a);
        return m2087c(ae2Var2, ce2Var.f8347b, decoderInputBuffer.data, ce2Var.f8346a);
    }

    /* renamed from: a */
    public final void m2090a(long j) {
        ae2 ae2Var;
        if (j == -1) {
            return;
        }
        while (true) {
            ae2Var = this.f7983d;
            if (j < ae2Var.f152b) {
                break;
            }
            this.f7980a.release(ae2Var.f153c);
            ae2 ae2Var2 = this.f7983d;
            ae2Var2.f153c = null;
            ae2 ae2Var3 = ae2Var2.f154d;
            ae2Var2.f154d = null;
            this.f7983d = ae2Var3;
        }
        if (this.f7984e.f151a < ae2Var.f151a) {
            this.f7984e = ae2Var;
        }
    }

    /* renamed from: b */
    public final int m2091b(int i) {
        ae2 ae2Var = this.f7985f;
        if (ae2Var.f153c == null) {
            Allocation allocate = this.f7980a.allocate();
            ae2 ae2Var2 = new ae2(this.f7985f.f152b, this.f7981b);
            ae2Var.f153c = allocate;
            ae2Var.f154d = ae2Var2;
        }
        return Math.min(i, (int) (this.f7985f.f152b - this.f7986g));
    }
}
