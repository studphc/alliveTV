package p000;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes.dex */
public final class mp1 {

    /* renamed from: a */
    public final Track f23045a;

    /* renamed from: b */
    public final ev2 f23046b;

    /* renamed from: c */
    public final TrackOutput f23047c;

    /* renamed from: d */
    public final TrueHdSampleRechunker f23048d;

    /* renamed from: e */
    public int f23049e;

    public mp1(Track track, ev2 ev2Var, TrackOutput trackOutput) {
        TrueHdSampleRechunker trueHdSampleRechunker;
        this.f23045a = track;
        this.f23046b = ev2Var;
        this.f23047c = trackOutput;
        if (MimeTypes.AUDIO_TRUEHD.equals(track.format.sampleMimeType)) {
            trueHdSampleRechunker = new TrueHdSampleRechunker();
        } else {
            trueHdSampleRechunker = null;
        }
        this.f23048d = trueHdSampleRechunker;
    }
}
