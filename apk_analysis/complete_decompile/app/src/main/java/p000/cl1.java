package p000;

import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class cl1 implements MediaCodecSelector {
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
    public final List getDecoderInfos(String str, boolean z, boolean z2) {
        return MediaCodecUtil.getDecoderInfos(str, z, z2);
    }
}
