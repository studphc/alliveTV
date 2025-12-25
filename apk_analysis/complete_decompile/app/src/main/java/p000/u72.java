package p000;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.C0707m;
import com.google.android.exoplayer2.source.IcyDataSource$Listener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public final class u72 implements Loader.Loadable, IcyDataSource$Listener {

    /* renamed from: b */
    public final Uri f27130b;

    /* renamed from: c */
    public final StatsDataSource f27131c;

    /* renamed from: d */
    public final ProgressiveMediaExtractor f27132d;

    /* renamed from: e */
    public final C0707m f27133e;

    /* renamed from: f */
    public final ConditionVariable f27134f;

    /* renamed from: h */
    public volatile boolean f27136h;

    /* renamed from: j */
    public long f27138j;

    /* renamed from: l */
    public SampleQueue f27140l;

    /* renamed from: m */
    public boolean f27141m;

    /* renamed from: n */
    public final /* synthetic */ C0707m f27142n;

    /* renamed from: g */
    public final PositionHolder f27135g = new PositionHolder();

    /* renamed from: i */
    public boolean f27137i = true;

    /* renamed from: a */
    public final long f27129a = LoadEventInfo.getNewId();

    /* renamed from: k */
    public DataSpec f27139k = m7681a(0);

    public u72(C0707m c0707m, Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, C0707m c0707m2, ConditionVariable conditionVariable) {
        this.f27142n = c0707m;
        this.f27130b = uri;
        this.f27131c = new StatsDataSource(dataSource);
        this.f27132d = progressiveMediaExtractor;
        this.f27133e = c0707m2;
        this.f27134f = conditionVariable;
    }

    /* renamed from: a */
    public final DataSpec m7681a(long j) {
        return new DataSpec.Builder().setUri(this.f27130b).setPosition(j).setKey(this.f27142n.f11568i).setFlags(6).setHttpRequestHeaders(C0707m.f11546M).build();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.f27136h = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        DataReader dataReader;
        int i;
        int i2 = 0;
        while (i2 == 0 && !this.f27136h) {
            try {
                long j = this.f27135g.position;
                DataSpec m7681a = m7681a(j);
                this.f27139k = m7681a;
                long open = this.f27131c.open(m7681a);
                if (open != -1) {
                    open += j;
                    C0707m c0707m = this.f27142n;
                    c0707m.getClass();
                    c0707m.f11575p.post(new t72(c0707m, 2));
                }
                long j2 = open;
                this.f27142n.f11577r = IcyHeaders.parse(this.f27131c.getResponseHeaders());
                StatsDataSource statsDataSource = this.f27131c;
                IcyHeaders icyHeaders = this.f27142n.f11577r;
                if (icyHeaders != null && (i = icyHeaders.metadataInterval) != -1) {
                    dataReader = new v11(statsDataSource, i, this);
                    C0707m c0707m2 = this.f27142n;
                    c0707m2.getClass();
                    SampleQueue m2822h = c0707m2.m2822h(new x72(0, true));
                    this.f27140l = m2822h;
                    m2822h.format(C0707m.f11547N);
                } else {
                    dataReader = statsDataSource;
                }
                long j3 = j;
                this.f27132d.init(dataReader, this.f27130b, this.f27131c.getResponseHeaders(), j, j2, this.f27133e);
                if (this.f27142n.f11577r != null) {
                    this.f27132d.disableSeekingOnMp3Streams();
                }
                if (this.f27137i) {
                    this.f27132d.seek(j3, this.f27138j);
                    this.f27137i = false;
                }
                while (true) {
                    long j4 = j3;
                    while (i2 == 0 && !this.f27136h) {
                        try {
                            this.f27134f.block();
                            i2 = this.f27132d.read(this.f27135g);
                            j3 = this.f27132d.getCurrentInputPosition();
                            if (j3 > this.f27142n.f11569j + j4) {
                                break;
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    this.f27134f.close();
                    C0707m c0707m3 = this.f27142n;
                    c0707m3.f11575p.post(c0707m3.f11574o);
                }
                if (i2 == 1) {
                    i2 = 0;
                } else if (this.f27132d.getCurrentInputPosition() != -1) {
                    this.f27135g.position = this.f27132d.getCurrentInputPosition();
                }
                DataSourceUtil.closeQuietly(this.f27131c);
            } catch (Throwable th) {
                if (i2 != 1 && this.f27132d.getCurrentInputPosition() != -1) {
                    this.f27135g.position = this.f27132d.getCurrentInputPosition();
                }
                DataSourceUtil.closeQuietly(this.f27131c);
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.IcyDataSource$Listener
    public final void onIcyMetadata(ParsableByteArray parsableByteArray) {
        long max;
        if (!this.f27141m) {
            max = this.f27138j;
        } else {
            max = Math.max(this.f27142n.m2817c(true), this.f27138j);
        }
        long j = max;
        int bytesLeft = parsableByteArray.bytesLeft();
        TrackOutput trackOutput = (TrackOutput) Assertions.checkNotNull(this.f27140l);
        trackOutput.sampleData(parsableByteArray, bytesLeft);
        trackOutput.sampleMetadata(j, 1, bytesLeft, 0, null);
        this.f27141m = true;
    }
}
