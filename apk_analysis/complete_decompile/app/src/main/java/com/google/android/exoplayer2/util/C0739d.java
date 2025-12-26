package com.google.android.exoplayer2.util;

import android.os.Message;
import com.google.android.exoplayer2.util.HandlerWrapper;
import java.util.ArrayList;

/* renamed from: com.google.android.exoplayer2.util.d */
/* loaded from: classes.dex */
public final class C0739d implements HandlerWrapper.Message {

    /* renamed from: a */
    public Message f12789a;

    /* renamed from: b */
    public C0740e f12790b;

    /* renamed from: a */
    public final void m3052a() {
        this.f12789a = null;
        this.f12790b = null;
        ArrayList arrayList = C0740e.f12791b;
        synchronized (arrayList) {
            if (arrayList.size() < 50) {
                arrayList.add(this);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper.Message
    public final HandlerWrapper getTarget() {
        return (HandlerWrapper) Assertions.checkNotNull(this.f12790b);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper.Message
    public final void sendToTarget() {
        ((Message) Assertions.checkNotNull(this.f12789a)).sendToTarget();
        m3052a();
    }
}
