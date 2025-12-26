package p000;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public abstract /* synthetic */ class dv2 {
    /* renamed from: a */
    public static int m4620a(TrackOutput trackOutput, DataReader dataReader, int i, boolean z) {
        return trackOutput.sampleData(dataReader, i, z, 0);
    }

    /* renamed from: b */
    public static void m4621b(TrackOutput trackOutput, ParsableByteArray parsableByteArray, int i) {
        trackOutput.sampleData(parsableByteArray, i, 0);
    }
}
