package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class n43 extends co2 {

    /* renamed from: n */
    public m43 f23228n;

    /* renamed from: o */
    public int f23229o;

    /* renamed from: p */
    public boolean f23230p;

    /* renamed from: q */
    public VorbisUtil.VorbisIdHeader f23231q;

    /* renamed from: r */
    public VorbisUtil.CommentHeader f23232r;

    @Override // p000.co2
    /* renamed from: a */
    public final void mo2265a(long j) {
        boolean z;
        this.f8442g = j;
        int i = 0;
        if (j != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f23230p = z;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f23231q;
        if (vorbisIdHeader != null) {
            i = vorbisIdHeader.blockSize0;
        }
        this.f23229o = i;
    }

    @Override // p000.co2
    /* renamed from: b */
    public final long mo2266b(ParsableByteArray parsableByteArray) {
        int i;
        int i2 = 0;
        if ((parsableByteArray.getData()[0] & 1) == 1) {
            return -1L;
        }
        byte b = parsableByteArray.getData()[0];
        m43 m43Var = (m43) Assertions.checkStateNotNull(this.f23228n);
        boolean z = m43Var.f22800d[(b >> 1) & (255 >>> (8 - m43Var.f22801e))].blockFlag;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = m43Var.f22797a;
        if (!z) {
            i = vorbisIdHeader.blockSize0;
        } else {
            i = vorbisIdHeader.blockSize1;
        }
        if (this.f23230p) {
            i2 = (this.f23229o + i) / 4;
        }
        long j = i2;
        if (parsableByteArray.capacity() < parsableByteArray.limit() + 4) {
            parsableByteArray.reset(Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit() + 4));
        } else {
            parsableByteArray.setLimit(parsableByteArray.limit() + 4);
        }
        byte[] data = parsableByteArray.getData();
        data[parsableByteArray.limit() - 4] = (byte) (j & 255);
        data[parsableByteArray.limit() - 3] = (byte) ((j >>> 8) & 255);
        data[parsableByteArray.limit() - 2] = (byte) ((j >>> 16) & 255);
        data[parsableByteArray.limit() - 1] = (byte) ((j >>> 24) & 255);
        this.f23230p = true;
        this.f23229o = i;
        return j;
    }

    @Override // p000.co2
    /* renamed from: c */
    public final boolean mo2267c(ParsableByteArray parsableByteArray, long j, C1540m9 c1540m9) {
        if (this.f23228n != null) {
            Assertions.checkNotNull((Format) c1540m9.f22854b);
            return false;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f23231q;
        m43 m43Var = null;
        if (vorbisIdHeader == null) {
            this.f23231q = VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
        } else {
            VorbisUtil.CommentHeader commentHeader = this.f23232r;
            if (commentHeader == null) {
                this.f23232r = VorbisUtil.readVorbisCommentHeader(parsableByteArray);
            } else {
                byte[] bArr = new byte[parsableByteArray.limit()];
                System.arraycopy(parsableByteArray.getData(), 0, bArr, 0, parsableByteArray.limit());
                VorbisUtil.Mode[] readVorbisModes = VorbisUtil.readVorbisModes(parsableByteArray, vorbisIdHeader.channels);
                m43Var = new m43(vorbisIdHeader, commentHeader, bArr, readVorbisModes, VorbisUtil.iLog(readVorbisModes.length - 1));
            }
        }
        this.f23228n = m43Var;
        if (m43Var == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        VorbisUtil.VorbisIdHeader vorbisIdHeader2 = m43Var.f22797a;
        arrayList.add(vorbisIdHeader2.data);
        arrayList.add(m43Var.f22799c);
        c1540m9.f22854b = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_VORBIS).setAverageBitrate(vorbisIdHeader2.bitrateNominal).setPeakBitrate(vorbisIdHeader2.bitrateMaximum).setChannelCount(vorbisIdHeader2.channels).setSampleRate(vorbisIdHeader2.sampleRate).setInitializationData(arrayList).setMetadata(VorbisUtil.parseVorbisComments(ImmutableList.copyOf(m43Var.f22798b.comments))).build();
        return true;
    }

    @Override // p000.co2
    /* renamed from: d */
    public final void mo2268d(boolean z) {
        super.mo2268d(z);
        if (z) {
            this.f23228n = null;
            this.f23231q = null;
            this.f23232r = null;
        }
        this.f23229o = 0;
        this.f23230p = false;
    }
}
