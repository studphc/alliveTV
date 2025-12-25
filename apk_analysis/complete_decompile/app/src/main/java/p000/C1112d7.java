package p000;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: d7 */
/* loaded from: classes.dex */
public final class C1112d7 implements DataSource {

    /* renamed from: a */
    public final DataSource f16274a;

    /* renamed from: b */
    public final byte[] f16275b;

    /* renamed from: c */
    public final byte[] f16276c;

    /* renamed from: d */
    public CipherInputStream f16277d;

    public C1112d7(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.f16274a = dataSource;
        this.f16275b = bArr;
        this.f16276c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f16274a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void close() {
        if (this.f16277d != null) {
            this.f16277d = null;
            this.f16274a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final Map getResponseHeaders() {
        return this.f16274a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final Uri getUri() {
        return this.f16274a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final long open(DataSpec dataSpec) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f16275b, "AES"), new IvParameterSpec(this.f16276c));
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f16274a, dataSpec);
                this.f16277d = new CipherInputStream(dataSourceInputStream, cipher);
                dataSourceInputStream.open();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        Assertions.checkNotNull(this.f16277d);
        int read = this.f16277d.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
