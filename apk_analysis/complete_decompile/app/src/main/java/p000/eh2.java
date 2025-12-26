package p000;

import com.google.common.util.concurrent.AbstractService;

/* loaded from: classes2.dex */
public final class eh2 extends AbstractService {
    @Override // com.google.common.util.concurrent.AbstractService
    public final void doStart() {
        notifyStarted();
    }

    @Override // com.google.common.util.concurrent.AbstractService
    public final void doStop() {
        notifyStopped();
    }
}
