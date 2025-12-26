package p000;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class bi2 {

    /* renamed from: a */
    public final int f8027a;

    /* renamed from: b */
    public final Object f8028b;

    /* renamed from: c */
    public final Object f8029c;

    /* renamed from: d */
    public final Object f8030d;

    public bi2(Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        this.f8028b = flow;
        this.f8027a = i;
        this.f8029c = bufferOverflow;
        this.f8030d = coroutineContext;
    }

    public bi2(int i, DataOutputStream dataOutputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f8028b = byteArrayOutputStream;
        this.f8029c = new DataOutputStream(byteArrayOutputStream);
        this.f8027a = i;
        this.f8030d = dataOutputStream;
    }
}
