package p000;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class o23 extends ge3 {

    /* renamed from: b */
    public final ParsableByteArray f23576b;

    /* renamed from: c */
    public final ParsableByteArray f23577c;

    /* renamed from: d */
    public int f23578d;

    /* renamed from: e */
    public boolean f23579e;

    /* renamed from: f */
    public boolean f23580f;

    /* renamed from: g */
    public int f23581g;

    public o23(TrackOutput trackOutput) {
        super(trackOutput);
        this.f23576b = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.f23577c = new ParsableByteArray(4);
    }
}
