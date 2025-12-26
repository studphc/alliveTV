package p000;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;

/* loaded from: classes.dex */
public final class vy0 {

    /* renamed from: a */
    public final TrackOutput f27993a;

    /* renamed from: b */
    public final boolean f27994b;

    /* renamed from: c */
    public final boolean f27995c;

    /* renamed from: f */
    public final ParsableNalUnitBitArray f27998f;

    /* renamed from: g */
    public byte[] f27999g;

    /* renamed from: h */
    public int f28000h;

    /* renamed from: i */
    public int f28001i;

    /* renamed from: j */
    public long f28002j;

    /* renamed from: l */
    public long f28004l;

    /* renamed from: p */
    public long f28008p;

    /* renamed from: q */
    public long f28009q;

    /* renamed from: r */
    public boolean f28010r;

    /* renamed from: d */
    public final SparseArray f27996d = new SparseArray();

    /* renamed from: e */
    public final SparseArray f27997e = new SparseArray();

    /* renamed from: m */
    public uy0 f28005m = new Object();

    /* renamed from: n */
    public uy0 f28006n = new Object();

    /* renamed from: k */
    public boolean f28003k = false;

    /* renamed from: o */
    public boolean f28007o = false;

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, uy0] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, uy0] */
    public vy0(TrackOutput trackOutput, boolean z, boolean z2) {
        this.f27993a = trackOutput;
        this.f27994b = z;
        this.f27995c = z2;
        byte[] bArr = new byte[128];
        this.f27999g = bArr;
        this.f27998f = new ParsableNalUnitBitArray(bArr, 0, 0);
        uy0 uy0Var = this.f28006n;
        uy0Var.f27529b = false;
        uy0Var.f27528a = false;
    }
}
