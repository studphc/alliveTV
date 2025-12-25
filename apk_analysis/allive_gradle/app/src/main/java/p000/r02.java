package p000;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class r02 {

    /* renamed from: a */
    public int f25822a;

    /* renamed from: b */
    public long f25823b;

    /* renamed from: c */
    public int f25824c;

    /* renamed from: d */
    public int f25825d;

    /* renamed from: e */
    public int f25826e;

    /* renamed from: f */
    public final int[] f25827f = new int[255];

    /* renamed from: g */
    public final ParsableByteArray f25828g = new ParsableByteArray(255);

    /* renamed from: a */
    public final boolean m7160a(ExtractorInput extractorInput, boolean z) {
        this.f25822a = 0;
        this.f25823b = 0L;
        this.f25824c = 0;
        this.f25825d = 0;
        this.f25826e = 0;
        ParsableByteArray parsableByteArray = this.f25828g;
        parsableByteArray.reset(27);
        if (!ExtractorUtil.peekFullyQuietly(extractorInput, parsableByteArray.getData(), 0, 27, z) || parsableByteArray.readUnsignedInt() != 1332176723) {
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != 0) {
            if (z) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.f25822a = parsableByteArray.readUnsignedByte();
        this.f25823b = parsableByteArray.readLittleEndianLong();
        parsableByteArray.readLittleEndianUnsignedInt();
        parsableByteArray.readLittleEndianUnsignedInt();
        parsableByteArray.readLittleEndianUnsignedInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        this.f25824c = readUnsignedByte;
        this.f25825d = readUnsignedByte + 27;
        parsableByteArray.reset(readUnsignedByte);
        if (!ExtractorUtil.peekFullyQuietly(extractorInput, parsableByteArray.getData(), 0, this.f25824c, z)) {
            return false;
        }
        for (int i = 0; i < this.f25824c; i++) {
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            this.f25827f[i] = readUnsignedByte2;
            this.f25826e += readUnsignedByte2;
        }
        return true;
    }

    /* renamed from: b */
    public final boolean m7161b(ExtractorInput extractorInput, long j) {
        boolean z;
        if (extractorInput.getPosition() == extractorInput.getPeekPosition()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        ParsableByteArray parsableByteArray = this.f25828g;
        parsableByteArray.reset(4);
        while (true) {
            if ((j == -1 || extractorInput.getPosition() + 4 < j) && ExtractorUtil.peekFullyQuietly(extractorInput, parsableByteArray.getData(), 0, 4, true)) {
                parsableByteArray.setPosition(0);
                if (parsableByteArray.readUnsignedInt() == 1332176723) {
                    extractorInput.resetPeekPosition();
                    return true;
                }
                extractorInput.skipFully(1);
            }
        }
        do {
            if (j != -1 && extractorInput.getPosition() >= j) {
                break;
            }
        } while (extractorInput.skip(1) != -1);
        return false;
    }
}
