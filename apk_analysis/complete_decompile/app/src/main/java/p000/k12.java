package p000;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* loaded from: classes.dex */
public final class k12 extends co2 {

    /* renamed from: o */
    public static final byte[] f20715o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p */
    public static final byte[] f20716p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n */
    public boolean f20717n;

    /* renamed from: e */
    public static boolean m5481e(ParsableByteArray parsableByteArray, byte[] bArr) {
        if (parsableByteArray.bytesLeft() < bArr.length) {
            return false;
        }
        int position = parsableByteArray.getPosition();
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        parsableByteArray.setPosition(position);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // p000.co2
    /* renamed from: b */
    public final long mo2266b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        byte[] data = parsableByteArray.getData();
        byte b = data[0];
        int i3 = b & 255;
        int i4 = b & 3;
        if (i4 != 0) {
            i = 2;
            if (i4 != 1 && i4 != 2) {
                i = data[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i = 1;
        }
        int i5 = i3 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i2 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << i6;
        } else if (i5 >= 12) {
            i2 = 10000 << (i5 & 1);
        } else if (i6 == 3) {
            i2 = 60000;
        } else {
            i2 = 10000 << i6;
        }
        return (this.f8444i * (i * i2)) / 1000000;
    }

    @Override // p000.co2
    /* renamed from: c */
    public final boolean mo2267c(ParsableByteArray parsableByteArray, long j, C1540m9 c1540m9) {
        if (m5481e(parsableByteArray, f20715o)) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
            int channelCount = OpusUtil.getChannelCount(copyOf);
            List<byte[]> buildInitializationData = OpusUtil.buildInitializationData(copyOf);
            if (((Format) c1540m9.f22854b) != null) {
                return true;
            }
            c1540m9.f22854b = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_OPUS).setChannelCount(channelCount).setSampleRate(OpusUtil.SAMPLE_RATE).setInitializationData(buildInitializationData).build();
            return true;
        }
        if (m5481e(parsableByteArray, f20716p)) {
            Assertions.checkStateNotNull((Format) c1540m9.f22854b);
            if (this.f20717n) {
                return true;
            }
            this.f20717n = true;
            parsableByteArray.skipBytes(8);
            Metadata parseVorbisComments = VorbisUtil.parseVorbisComments(ImmutableList.copyOf(VorbisUtil.readVorbisCommentHeader(parsableByteArray, false, false).comments));
            if (parseVorbisComments == null) {
                return true;
            }
            c1540m9.f22854b = ((Format) c1540m9.f22854b).buildUpon().setMetadata(parseVorbisComments.copyWithAppendedEntriesFrom(((Format) c1540m9.f22854b).metadata)).build();
            return true;
        }
        Assertions.checkStateNotNull((Format) c1540m9.f22854b);
        return false;
    }

    @Override // p000.co2
    /* renamed from: d */
    public final void mo2268d(boolean z) {
        super.mo2268d(z);
        if (z) {
            this.f20717n = false;
        }
    }
}
