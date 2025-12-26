package p000;

import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.SearchBar;

/* loaded from: classes.dex */
public final class mf2 implements SearchBar.SearchBarPermissionListener {

    /* renamed from: a */
    public final /* synthetic */ SearchSupportFragment f22926a;

    public mf2(SearchSupportFragment searchSupportFragment) {
        this.f22926a = searchSupportFragment;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarPermissionListener
    public final void requestAudioPermission() {
        this.f22926a.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 0);
    }
}
