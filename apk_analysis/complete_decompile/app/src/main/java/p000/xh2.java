package p000;

import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.widget.ShareActionProvider;

/* loaded from: classes.dex */
public final class xh2 implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ ShareActionProvider f28563a;

    public xh2(ShareActionProvider shareActionProvider) {
        this.f28563a = shareActionProvider;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ShareActionProvider shareActionProvider = this.f28563a;
        Intent m7534b = C1859u4.m7532d(shareActionProvider.f1416f, shareActionProvider.f1417g).m7534b(menuItem.getItemId());
        if (m7534b != null) {
            String action = m7534b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                shareActionProvider.getClass();
                m7534b.addFlags(134742016);
            }
            shareActionProvider.f1416f.startActivity(m7534b);
            return true;
        }
        return true;
    }
}
