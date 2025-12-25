package p000;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/* loaded from: classes.dex */
public final class fu0 implements TabHost.TabContentFactory {

    /* renamed from: a */
    public final Context f17398a;

    public fu0(Context context) {
        this.f17398a = context;
    }

    @Override // android.widget.TabHost.TabContentFactory
    public final View createTabContent(String str) {
        View view = new View(this.f17398a);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }
}
