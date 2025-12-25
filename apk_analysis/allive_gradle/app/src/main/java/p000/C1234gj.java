package p000;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: gj */
/* loaded from: classes2.dex */
public final class C1234gj extends ByteSource {

    /* renamed from: a */
    public final /* synthetic */ int f17714a = 1;

    /* renamed from: b */
    public final Object f17715b;

    public C1234gj(URL url) {
        this.f17715b = (URL) Preconditions.checkNotNull(url);
    }

    @Override // com.google.common.io.ByteSource
    public boolean isEmpty() {
        switch (this.f17714a) {
            case 0:
                Iterator it = ((Iterable) this.f17715b).iterator();
                while (it.hasNext()) {
                    if (!((ByteSource) it.next()).isEmpty()) {
                        return false;
                    }
                }
                return true;
            default:
                return super.isEmpty();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [op1, java.io.InputStream] */
    @Override // com.google.common.io.ByteSource
    public final InputStream openStream() {
        switch (this.f17714a) {
            case 0:
                Iterator it = ((Iterable) this.f17715b).iterator();
                ?? inputStream = new InputStream();
                inputStream.f24855a = (Iterator) Preconditions.checkNotNull(it);
                inputStream.m6714a();
                return inputStream;
            case 1:
                return new FileInputStream((File) this.f17715b);
            default:
                return ((URL) this.f17715b).openStream();
        }
    }

    @Override // com.google.common.io.ByteSource
    public byte[] read() {
        switch (this.f17714a) {
            case 1:
                try {
                    FileInputStream fileInputStream = (FileInputStream) Closer.create().register(new FileInputStream((File) this.f17715b));
                    return ByteStreams.m4200c(fileInputStream, fileInputStream.getChannel().size());
                } finally {
                }
            default:
                return super.read();
        }
    }

    @Override // com.google.common.io.ByteSource
    public long size() {
        switch (this.f17714a) {
            case 0:
                Iterator it = ((Iterable) this.f17715b).iterator();
                long j = 0;
                while (it.hasNext()) {
                    j += ((ByteSource) it.next()).size();
                    if (j < 0) {
                        return Long.MAX_VALUE;
                    }
                }
                return j;
            case 1:
                File file = (File) this.f17715b;
                if (file.isFile()) {
                    return file.length();
                }
                throw new FileNotFoundException(file.toString());
            default:
                return super.size();
        }
    }

    @Override // com.google.common.io.ByteSource
    public Optional sizeIfKnown() {
        switch (this.f17714a) {
            case 0:
                Iterable iterable = (Iterable) this.f17715b;
                if (!(iterable instanceof Collection)) {
                    return Optional.absent();
                }
                Iterator it = iterable.iterator();
                long j = 0;
                while (it.hasNext()) {
                    Optional<Long> sizeIfKnown = ((ByteSource) it.next()).sizeIfKnown();
                    if (!sizeIfKnown.isPresent()) {
                        return Optional.absent();
                    }
                    j += sizeIfKnown.get().longValue();
                    if (j < 0) {
                        return Optional.m3770of(Long.MAX_VALUE);
                    }
                }
                return Optional.m3770of(Long.valueOf(j));
            case 1:
                File file = (File) this.f17715b;
                if (file.isFile()) {
                    return Optional.m3770of(Long.valueOf(file.length()));
                }
                return Optional.absent();
            default:
                return super.sizeIfKnown();
        }
    }

    public final String toString() {
        switch (this.f17714a) {
            case 0:
                String valueOf = String.valueOf((Iterable) this.f17715b);
                return AbstractC1726qj.m7059o("ByteSource.concat(", valueOf, ")", valueOf.length() + 19);
            case 1:
                String valueOf2 = String.valueOf((File) this.f17715b);
                return AbstractC1726qj.m7059o("Files.asByteSource(", valueOf2, ")", valueOf2.length() + 20);
            default:
                String valueOf3 = String.valueOf((URL) this.f17715b);
                return AbstractC1726qj.m7059o("Resources.asByteSource(", valueOf3, ")", valueOf3.length() + 24);
        }
    }

    public C1234gj(File file) {
        this.f17715b = (File) Preconditions.checkNotNull(file);
    }

    public C1234gj(Iterable iterable) {
        this.f17715b = (Iterable) Preconditions.checkNotNull(iterable);
    }
}
