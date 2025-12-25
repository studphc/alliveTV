package p000;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Map;

/* loaded from: classes.dex */
public final class v11 implements DataSource {

    /* renamed from: a */
    public final DataSource f27619a;

    /* renamed from: b */
    public final int f27620b;

    /* renamed from: c */
    public final u72 f27621c;

    /* renamed from: d */
    public final byte[] f27622d;

    /* renamed from: e */
    public int f27623e;

    public v11(DataSource dataSource, int i, u72 u72Var) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f27619a = dataSource;
        this.f27620b = i;
        this.f27621c = u72Var;
        this.f27622d = new byte[1];
        this.f27623e = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f27619a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final Map getResponseHeaders() {
        return this.f27619a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final Uri getUri() {
        return this.f27619a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final long open(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        int i3 = this.f27623e;
        DataSource dataSource = this.f27619a;
        if (i3 == 0) {
            byte[] bArr2 = this.f27622d;
            int i4 = 0;
            if (dataSource.read(bArr2, 0, 1) != -1) {
                int i5 = (bArr2[0] & 255) << 4;
                if (i5 != 0) {
                    byte[] bArr3 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int read = dataSource.read(bArr3, i4, i6);
                        if (read != -1) {
                            i4 += read;
                            i6 -= read;
                        }
                    }
                    while (i5 > 0 && bArr3[i5 - 1] == 0) {
                        i5--;
                    }
                    if (i5 > 0) {
                        this.f27621c.onIcyMetadata(new ParsableByteArray(bArr3, i5));
                    }
                }
                this.f27623e = this.f27620b;
            }
            return -1;
        }
        int read2 = dataSource.read(bArr, i, Math.min(this.f27623e, i2));
        if (read2 != -1) {
            this.f27623e -= read2;
        }
        return read2;
    }
}
