package p000;

import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public class il1 extends hl1 {
    @Override // android.support.v4.media.session.AbstractC0054j, android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void prepare() {
        this.f429a.prepare();
    }

    @Override // android.support.v4.media.session.AbstractC0054j, android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void prepareFromMediaId(String str, Bundle bundle) {
        this.f429a.prepareFromMediaId(str, bundle);
    }

    @Override // android.support.v4.media.session.AbstractC0054j, android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void prepareFromSearch(String str, Bundle bundle) {
        this.f429a.prepareFromSearch(str, bundle);
    }

    @Override // android.support.v4.media.session.AbstractC0054j, android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void prepareFromUri(Uri uri, Bundle bundle) {
        this.f429a.prepareFromUri(uri, bundle);
    }
}
