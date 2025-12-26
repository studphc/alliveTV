package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import p000.m00;

/* renamed from: com.google.android.exoplayer2.drm.a */
/* loaded from: classes.dex */
public final class HandlerC0659a extends Handler {

    /* renamed from: a */
    public boolean f10001a;

    /* renamed from: b */
    public final /* synthetic */ C0660b f10002b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0659a(C0660b c0660b, Looper looper) {
        super(looper);
        this.f10002b = c0660b;
    }

    /* renamed from: a */
    public final boolean m2521a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
        IOException iOException;
        m00 m00Var = (m00) message.obj;
        if (!m00Var.f22739b) {
            return false;
        }
        int i = m00Var.f22742e + 1;
        m00Var.f22742e = i;
        if (i > this.f10002b.f10012j.getMinimumLoadableRetryCount(3)) {
            return false;
        }
        LoadEventInfo loadEventInfo = new LoadEventInfo(m00Var.f22738a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - m00Var.f22740c, mediaDrmCallbackException.bytesLoaded);
        MediaLoadData mediaLoadData = new MediaLoadData(3);
        if (mediaDrmCallbackException.getCause() instanceof IOException) {
            iOException = (IOException) mediaDrmCallbackException.getCause();
        } else {
            final Throwable cause = mediaDrmCallbackException.getCause();
            iOException = new IOException(cause) { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$UnexpectedDrmSessionException
            };
        }
        long retryDelayMsFor = this.f10002b.f10012j.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, mediaLoadData, iOException, m00Var.f22742e));
        if (retryDelayMsFor == C0643C.TIME_UNSET) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f10001a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), retryDelayMsFor);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Throwable th;
        m00 m00Var = (m00) message.obj;
        try {
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    C0660b c0660b = this.f10002b;
                    th = c0660b.f10014l.executeKeyRequest(c0660b.f10015m, (ExoMediaDrm.KeyRequest) m00Var.f22741d);
                } else {
                    throw new RuntimeException();
                }
            } else {
                C0660b c0660b2 = this.f10002b;
                th = c0660b2.f10014l.executeProvisionRequest(c0660b2.f10015m, (ExoMediaDrm.ProvisionRequest) m00Var.f22741d);
            }
        } catch (MediaDrmCallbackException e) {
            boolean m2521a = m2521a(message, e);
            th = e;
            if (m2521a) {
                return;
            }
        } catch (Exception e2) {
            Log.m3028w("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
            th = e2;
        }
        this.f10002b.f10012j.onLoadTaskConcluded(m00Var.f22738a);
        synchronized (this) {
            try {
                if (!this.f10001a) {
                    this.f10002b.f10016n.obtainMessage(message.what, Pair.create(m00Var.f22741d, th)).sendToTarget();
                }
            } finally {
            }
        }
    }
}
