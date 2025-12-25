package p000;

import androidx.leanback.app.PermissionHelper;
import androidx.leanback.app.SearchFragment;
import androidx.leanback.widget.SearchBar;

/* loaded from: classes.dex */
public final class ff2 implements SearchBar.SearchBarPermissionListener {

    /* renamed from: a */
    public final /* synthetic */ SearchFragment f17241a;

    public ff2(SearchFragment searchFragment) {
        this.f17241a = searchFragment;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarPermissionListener
    public final void requestAudioPermission() {
        PermissionHelper.requestPermissions(this.f17241a, new String[]{"android.permission.RECORD_AUDIO"}, 0);
    }
}
