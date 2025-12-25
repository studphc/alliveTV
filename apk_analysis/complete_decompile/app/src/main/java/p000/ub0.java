package p000;

import com.google.android.exoplayer2.text.ExoplayerCuesDecoder;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class ub0 extends SubtitleOutputBuffer {

    /* renamed from: d */
    public final /* synthetic */ int f27183d;

    /* renamed from: e */
    public final /* synthetic */ SubtitleDecoder f27184e;

    public /* synthetic */ ub0(SubtitleDecoder subtitleDecoder, int i) {
        this.f27183d = i;
        this.f27184e = subtitleDecoder;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
    public final void release() {
        boolean z;
        switch (this.f27183d) {
            case 0:
                ArrayDeque arrayDeque = ((ExoplayerCuesDecoder) this.f27184e).f11737c;
                if (arrayDeque.size() < 2) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkState(z);
                Assertions.checkArgument(!arrayDeque.contains(this));
                clear();
                arrayDeque.addFirst(this);
                return;
            default:
                ((SimpleSubtitleDecoder) this.f27184e).releaseOutputBuffer(this);
                return;
        }
    }
}
