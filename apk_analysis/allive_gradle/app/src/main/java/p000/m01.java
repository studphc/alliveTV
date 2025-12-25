package p000;

import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.UriUtil;
import java.util.List;

/* loaded from: classes.dex */
public final class m01 extends BaseMediaChunkIterator {

    /* renamed from: d */
    public final List f22743d;

    /* renamed from: e */
    public final long f22744e;

    /* renamed from: f */
    public final String f22745f;

    public m01(String str, long j, List list) {
        super(0L, list.size() - 1);
        this.f22745f = str;
        this.f22744e = j;
        this.f22743d = list;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public final long getChunkEndTimeUs() {
        checkInBounds();
        HlsMediaPlaylist.SegmentBase segmentBase = (HlsMediaPlaylist.SegmentBase) this.f22743d.get((int) getCurrentIndex());
        return this.f22744e + segmentBase.relativeStartTimeUs + segmentBase.durationUs;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public final long getChunkStartTimeUs() {
        checkInBounds();
        return this.f22744e + ((HlsMediaPlaylist.SegmentBase) this.f22743d.get((int) getCurrentIndex())).relativeStartTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public final DataSpec getDataSpec() {
        checkInBounds();
        HlsMediaPlaylist.SegmentBase segmentBase = (HlsMediaPlaylist.SegmentBase) this.f22743d.get((int) getCurrentIndex());
        return new DataSpec(UriUtil.resolveToUri(this.f22745f, segmentBase.url), segmentBase.byteRangeOffset, segmentBase.byteRangeLength);
    }
}
