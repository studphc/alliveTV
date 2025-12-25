package p000;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class sj2 implements Loader.Loadable {

    /* renamed from: a */
    public final long f26456a = LoadEventInfo.getNewId();

    /* renamed from: b */
    public final DataSpec f26457b;

    /* renamed from: c */
    public final StatsDataSource f26458c;

    /* renamed from: d */
    public byte[] f26459d;

    public sj2(DataSource dataSource, DataSpec dataSpec) {
        this.f26457b = dataSpec;
        this.f26458c = new StatsDataSource(dataSource);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        StatsDataSource statsDataSource = this.f26458c;
        statsDataSource.resetBytesRead();
        try {
            statsDataSource.open(this.f26457b);
            int i = 0;
            while (i != -1) {
                int bytesRead = (int) statsDataSource.getBytesRead();
                byte[] bArr = this.f26459d;
                if (bArr == null) {
                    this.f26459d = new byte[1024];
                } else if (bytesRead == bArr.length) {
                    this.f26459d = Arrays.copyOf(bArr, bArr.length * 2);
                }
                byte[] bArr2 = this.f26459d;
                i = statsDataSource.read(bArr2, bytesRead, bArr2.length - bytesRead);
            }
            DataSourceUtil.closeQuietly(statsDataSource);
        } catch (Throwable th) {
            DataSourceUtil.closeQuietly(statsDataSource);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
    }
}
