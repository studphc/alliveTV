package p000;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.common.api.internal.zacp;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class p73 extends zau {

    /* renamed from: a */
    public final /* synthetic */ int f25058a;

    /* renamed from: b */
    public final /* synthetic */ Object f25059b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p73(Object obj, Looper looper, int i) {
        super(looper);
        this.f25058a = i;
        this.f25059b = obj;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (this.f25058a) {
            case 0:
                int i = message.what;
                zabe zabeVar = (zabe) this.f25059b;
                if (i != 1) {
                    if (i != 2) {
                        Log.w("GoogleApiClientImpl", "Unknown message id: " + i);
                        return;
                    }
                    zabe.m3106b(zabeVar);
                    return;
                }
                Lock lock = zabeVar.f13219b;
                lock.lock();
                try {
                    if (zabeVar.m3108c()) {
                        zabeVar.m3110e();
                    }
                    return;
                } finally {
                    lock.unlock();
                }
            case 1:
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        Log.w("GACStateManager", "Unknown message id: " + i2);
                        return;
                    }
                    throw ((RuntimeException) message.obj);
                }
                r73 r73Var = (r73) message.obj;
                zabi zabiVar = (zabi) this.f25059b;
                r73Var.getClass();
                zabiVar.f13242a.lock();
                try {
                    if (zabiVar.f13252k == r73Var.f25890a) {
                        r73Var.mo33a();
                    }
                    return;
                } finally {
                    zabiVar.f13242a.unlock();
                }
            default:
                int i3 = message.what;
                if (i3 != 0) {
                    if (i3 != 1) {
                        Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i3);
                        return;
                    } else {
                        RuntimeException runtimeException = (RuntimeException) message.obj;
                        Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                        throw runtimeException;
                    }
                }
                PendingResult pendingResult = (PendingResult) message.obj;
                synchronized (((zada) this.f25059b).f13289e) {
                    try {
                        zada zadaVar = (zada) Preconditions.checkNotNull(((zada) this.f25059b).f13286b);
                        if (pendingResult == null) {
                            zadaVar.m3124a(new Status(13, "Transform returned null"));
                        } else if (pendingResult instanceof zacp) {
                            zadaVar.m3124a(((zacp) pendingResult).f13276a);
                        } else {
                            zadaVar.zai(pendingResult);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
