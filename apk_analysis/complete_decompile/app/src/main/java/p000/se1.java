package p000;

import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes2.dex */
public final class se1 implements View.OnKeyListener {
    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (i == 166) {
                new Thread(new a80(9)).start();
                return true;
            }
            if (i == 167) {
                new Thread(new a80(10)).start();
                return true;
            }
            if (i != 88 && i != 89) {
                if (i != 87 && i != 90) {
                    if (i == 126 || i == 85) {
                        new Thread(new a80(13)).start();
                        return true;
                    }
                    return false;
                }
                new Thread(new a80(12)).start();
                return true;
            }
            new Thread(new a80(11)).start();
            return true;
        }
        return false;
    }
}
