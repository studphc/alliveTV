package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ActionProvider;
import p000.C1859u4;
import p000.xh2;

/* loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /* renamed from: d */
    public final int f1414d;

    /* renamed from: e */
    public final xh2 f1415e;

    /* renamed from: f */
    public final Context f1416f;

    /* renamed from: g */
    public String f1417g;

    /* renamed from: h */
    public OnShareTargetSelectedListener f1418h;

    /* renamed from: i */
    public C0106o f1419i;

    /* loaded from: classes.dex */
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f1414d = 4;
        this.f1415e = new xh2(this);
        this.f1417g = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.f1416f = context;
    }

    /* renamed from: a */
    public final void m277a() {
        if (this.f1418h == null) {
            return;
        }
        if (this.f1419i == null) {
            this.f1419i = new C0106o(this);
        }
        C1859u4 m7532d = C1859u4.m7532d(this.f1416f, this.f1417g);
        C0106o c0106o = this.f1419i;
        synchronized (m7532d.f27086a) {
            m7532d.f27098m = c0106o;
        }
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        Context context = this.f1416f;
        ActivityChooserView activityChooserView = new ActivityChooserView(context);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(C1859u4.m7532d(context, this.f1417g));
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(context, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        xh2 xh2Var;
        subMenu.clear();
        String str = this.f1417g;
        Context context = this.f1416f;
        C1859u4 m7532d = C1859u4.m7532d(context, str);
        PackageManager packageManager = context.getPackageManager();
        int m7537f = m7532d.m7537f();
        int min = Math.min(m7537f, this.f1414d);
        int i = 0;
        while (true) {
            xh2Var = this.f1415e;
            if (i >= min) {
                break;
            }
            ResolveInfo m7536e = m7532d.m7536e(i);
            subMenu.add(0, i, i, m7536e.loadLabel(packageManager)).setIcon(m7536e.loadIcon(packageManager)).setOnMenuItemClickListener(xh2Var);
            i++;
        }
        if (min < m7537f) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, context.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < m7537f; i2++) {
                ResolveInfo m7536e2 = m7532d.m7536e(i2);
                addSubMenu.add(0, i2, i2, m7536e2.loadLabel(packageManager)).setIcon(m7536e2.loadIcon(packageManager)).setOnMenuItemClickListener(xh2Var);
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f1418h = onShareTargetSelectedListener;
        m277a();
    }

    public void setShareHistoryFileName(String str) {
        this.f1417g = str;
        m277a();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                intent.addFlags(134742016);
            }
        }
        C1859u4 m7532d = C1859u4.m7532d(this.f1416f, this.f1417g);
        synchronized (m7532d.f27086a) {
            try {
                if (m7532d.f27091f != intent) {
                    m7532d.f27091f = intent;
                    m7532d.f27097l = true;
                    m7532d.m7535c();
                }
            } finally {
            }
        }
    }
}
