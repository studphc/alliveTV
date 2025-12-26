package androidx.leanback.widget;

import android.view.KeyEvent;
import android.view.View;
import androidx.leanback.widget.PlaybackTransportRowPresenter;

/* renamed from: androidx.leanback.widget.n2 */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0367n2 implements View.OnKeyListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackTransportRowPresenter.ViewHolder f6329a;

    public ViewOnKeyListenerC0367n2(PlaybackTransportRowPresenter.ViewHolder viewHolder) {
        this.f6329a = viewHolder;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        PlaybackTransportRowPresenter.ViewHolder viewHolder = this.f6329a;
        if (i != 4) {
            if (i != 66) {
                if (i != 69) {
                    if (i != 81) {
                        if (i != 111) {
                            if (i != 89) {
                                if (i != 90) {
                                    switch (i) {
                                        case 19:
                                        case 20:
                                            return viewHolder.f6048I;
                                        case 21:
                                            break;
                                        case 22:
                                            break;
                                        case 23:
                                            break;
                                        default:
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                    if (keyEvent.getAction() == 0 && viewHolder.m1475d()) {
                        viewHolder.m1477f(true);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 0 && viewHolder.m1475d()) {
                    viewHolder.m1477f(false);
                }
                return true;
            }
            if (!viewHolder.f6048I) {
                return false;
            }
            if (keyEvent.getAction() == 1) {
                viewHolder.m1476e(false);
            }
            return true;
        }
        if (!viewHolder.f6048I) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            viewHolder.m1476e(!viewHolder.f6062u.isAccessibilityFocused());
        }
        return true;
    }
}
