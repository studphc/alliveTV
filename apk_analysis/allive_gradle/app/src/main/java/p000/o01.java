package p000;

import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;

/* loaded from: classes.dex */
public final class o01 {

    /* renamed from: a */
    public final HlsMediaPlaylist.SegmentBase f23550a;

    /* renamed from: b */
    public final long f23551b;

    /* renamed from: c */
    public final int f23552c;

    /* renamed from: d */
    public final boolean f23553d;

    public o01(HlsMediaPlaylist.SegmentBase segmentBase, long j, int i) {
        boolean z;
        this.f23550a = segmentBase;
        this.f23551b = j;
        this.f23552c = i;
        if ((segmentBase instanceof HlsMediaPlaylist.Part) && ((HlsMediaPlaylist.Part) segmentBase).isPreload) {
            z = true;
        } else {
            z = false;
        }
        this.f23553d = z;
    }
}
