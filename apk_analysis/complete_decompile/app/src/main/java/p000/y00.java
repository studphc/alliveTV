package p000;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleExtractor;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final /* synthetic */ class y00 implements ExtractorsFactory, fl1 {

    /* renamed from: a */
    public final /* synthetic */ Format f28779a;

    public /* synthetic */ y00(Format format) {
        this.f28779a = format;
    }

    @Override // p000.fl1
    /* renamed from: a */
    public int mo4692a(Object obj) {
        Format format = this.f28779a;
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) obj;
        Pattern pattern = MediaCodecUtil.f10723a;
        try {
            return mediaCodecInfo.isFormatSupported(format) ? 1 : 0;
        } catch (MediaCodecUtil.DecoderQueryException unused) {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return zb0.m8410a(this, uri, map);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        Extractor b10Var;
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.DEFAULT;
        Format format = this.f28779a;
        if (subtitleDecoderFactory.supportsFormat(format)) {
            b10Var = new SubtitleExtractor(subtitleDecoderFactory.createDecoder(format), format);
        } else {
            b10Var = new b10(format);
        }
        return new Extractor[]{b10Var};
    }
}
