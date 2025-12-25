package com.hisona.allive;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* loaded from: classes2.dex */
public class FetchChannelResultReceiver extends ResultReceiver {

    /* renamed from: a */
    public Receiver f15826a;

    /* loaded from: classes2.dex */
    public interface Receiver {
        void onReceiveResult(int i, Bundle bundle);
    }

    public FetchChannelResultReceiver(Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        Receiver receiver = this.f15826a;
        if (receiver != null) {
            receiver.onReceiveResult(i, bundle);
        }
    }

    public void setReceiver(Receiver receiver) {
        this.f15826a = receiver;
    }
}
