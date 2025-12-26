package p000;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.hisona.allive.PlayerActivity;
import com.hisona.allive.Utils;

/* loaded from: classes.dex */
public final class q91 implements View.OnTouchListener {

    /* renamed from: a */
    public final /* synthetic */ int f25490a;

    /* renamed from: b */
    public final /* synthetic */ Object f25491b;

    public /* synthetic */ q91(int i, Object obj) {
        this.f25490a = i;
        this.f25491b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        switch (this.f25490a) {
            case 0:
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                ListPopupWindow listPopupWindow = (ListPopupWindow) this.f25491b;
                if (action == 0 && (popupWindow = listPopupWindow.f1296F) != null && popupWindow.isShowing() && x >= 0 && x < listPopupWindow.f1296F.getWidth() && y >= 0 && y < listPopupWindow.f1296F.getHeight()) {
                    listPopupWindow.f1292B.postDelayed(listPopupWindow.f1319w, 250L);
                    return false;
                }
                if (action == 1) {
                    listPopupWindow.f1292B.removeCallbacks(listPopupWindow.f1319w);
                    return false;
                }
                return false;
            default:
                PlayerActivity playerActivity = (PlayerActivity) this.f25491b;
                Utils.doFullScreen(playerActivity.f15874C);
                if (!playerActivity.f15886O.isPanelShow().booleanValue()) {
                    playerActivity.f15886O.showDpadPanel();
                    playerActivity.m4465l(PathInterpolatorCompat.MAX_NUM_POINTS);
                    return false;
                }
                playerActivity.f15886O.hideSlidingPanel(true);
                return false;
        }
    }
}
