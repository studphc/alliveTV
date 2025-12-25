package com.hisona.allive;

import android.view.KeyEvent;
import android.view.View;
import p000.a80;

/* renamed from: com.hisona.allive.a0 */
/* loaded from: classes2.dex */
public final class ViewOnKeyListenerC1065a0 implements View.OnKeyListener {

    /* renamed from: a */
    public final /* synthetic */ TvBaseRowsSupportFragment f15971a;

    public ViewOnKeyListenerC1065a0(TvBaseRowsSupportFragment tvBaseRowsSupportFragment) {
        this.f15971a = tvBaseRowsSupportFragment;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (i == 166) {
                new Thread(new a80(21)).start();
                return true;
            }
            if (i == 167) {
                new Thread(new a80(22)).start();
                return true;
            }
            if (i != 88 && i != 89) {
                if (i != 87 && i != 90) {
                    if (i == 126 || i == 85) {
                        new Thread(new a80(25)).start();
                        return true;
                    }
                } else {
                    new Thread(new a80(24)).start();
                    return true;
                }
            } else {
                new Thread(new a80(23)).start();
                return true;
            }
        }
        OnKeyListener onKeyListener = this.f15971a.mKeyListener;
        if (onKeyListener != null) {
            return onKeyListener.onKey(view, i, keyEvent);
        }
        return false;
    }
}
