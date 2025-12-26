package p000;

import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class lc0 extends ByteSource {

    /* renamed from: a */
    public final /* synthetic */ int f22458a;

    /* renamed from: b */
    public final /* synthetic */ FileBackedOutputStream f22459b;

    public /* synthetic */ lc0(FileBackedOutputStream fileBackedOutputStream, int i) {
        this.f22458a = i;
        this.f22459b = fileBackedOutputStream;
    }

    public void finalize() {
        switch (this.f22458a) {
            case 0:
                try {
                    this.f22459b.reset();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace(System.err);
                    return;
                }
            default:
                super.finalize();
                return;
        }
    }

    @Override // com.google.common.io.ByteSource
    public final InputStream openStream() {
        switch (this.f22458a) {
            case 0:
                return FileBackedOutputStream.m4202a(this.f22459b);
            default:
                return FileBackedOutputStream.m4202a(this.f22459b);
        }
    }
}
