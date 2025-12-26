package p000;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.ContentFrameLayout;

/* renamed from: g9 */
/* loaded from: classes.dex */
public final class C1224g9 extends ContentFrameLayout {

    /* renamed from: i */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f17614i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1224g9(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e, ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper);
        this.f17614i = layoutInflaterFactory2C0084e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f17614i.m184m(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f17614i;
                layoutInflaterFactory2C0084e.m183k(layoutInflaterFactory2C0084e.m190t(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
    }
}
