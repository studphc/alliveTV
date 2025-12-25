package p000;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.widget.ToolbarWidgetWrapper;

/* loaded from: classes.dex */
public final class ou2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f24917a = 1;

    /* renamed from: b */
    public final Object f24918b;

    /* renamed from: c */
    public final /* synthetic */ Object f24919c;

    public ou2(Context context, Intent intent) {
        this.f24918b = context;
        this.f24919c = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f24917a) {
            case 0:
                ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.f24919c;
                Window.Callback callback = toolbarWidgetWrapper.f1578m;
                if (callback != null && toolbarWidgetWrapper.f1579n) {
                    callback.onMenuItemSelected(0, (ActionMenuItem) this.f24918b);
                    return;
                }
                return;
            default:
                try {
                    ((Context) this.f24918b).startActivity((Intent) this.f24919c);
                    return;
                } catch (ActivityNotFoundException e) {
                    Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
                    return;
                }
        }
    }

    public ou2(ToolbarWidgetWrapper toolbarWidgetWrapper) {
        this.f24919c = toolbarWidgetWrapper;
        this.f24918b = new ActionMenuItem(toolbarWidgetWrapper.f1566a.getContext(), 0, R.id.home, 0, 0, toolbarWidgetWrapper.f1575j);
    }
}
