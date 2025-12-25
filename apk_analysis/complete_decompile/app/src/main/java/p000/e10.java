package p000;

import android.util.Base64;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager;
import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final /* synthetic */ class e10 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f16642a;

    public /* synthetic */ e10(int i) {
        this.f16642a = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f16642a) {
            case 0:
                byte[] bArr = new byte[12];
                DefaultPlaybackSessionManager.f9521h.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
            case 1:
                return new DefaultLoadControl();
            case 2:
                return new fp2();
            case 3:
                return new ReentrantLock(false);
            case 4:
                return new ReentrantLock(false);
            default:
                return new ReentrantReadWriteLock();
        }
    }
}
