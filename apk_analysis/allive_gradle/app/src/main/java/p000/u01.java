package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Allocator;
import java.util.Map;

/* loaded from: classes.dex */
public final class u01 extends SampleQueue {

    /* renamed from: H */
    public final Map f27055H;

    /* renamed from: I */
    public DrmInitData f27056I;

    public u01(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Map map) {
        super(allocator, drmSessionManager, eventDispatcher);
        this.f27055H = map;
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue
    public final Format getAdjustedUpstreamFormat(Format format) {
        DrmInitData drmInitData;
        DrmInitData drmInitData2 = this.f27056I;
        if (drmInitData2 == null) {
            drmInitData2 = format.drmInitData;
        }
        if (drmInitData2 != null && (drmInitData = (DrmInitData) this.f27055H.get(drmInitData2.schemeType)) != null) {
            drmInitData2 = drmInitData;
        }
        Metadata metadata = format.metadata;
        if (metadata != null) {
            int length = metadata.length();
            int i = 0;
            while (true) {
                if (i < length) {
                    Metadata.Entry entry = metadata.get(i);
                    if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i != -1) {
                if (length != 1) {
                    Metadata.Entry[] entryArr = new Metadata.Entry[length - 1];
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 != i) {
                            entryArr[i2 < i ? i2 : i2 - 1] = metadata.get(i2);
                        }
                    }
                    metadata = new Metadata(entryArr);
                }
            }
            if (drmInitData2 == format.drmInitData || metadata != format.metadata) {
                format = format.buildUpon().setDrmInitData(drmInitData2).setMetadata(metadata).build();
            }
            return super.getAdjustedUpstreamFormat(format);
        }
        metadata = null;
        if (drmInitData2 == format.drmInitData) {
        }
        format = format.buildUpon().setDrmInitData(drmInitData2).setMetadata(metadata).build();
        return super.getAdjustedUpstreamFormat(format);
    }
}
