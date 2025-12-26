package p000;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import androidx.media.MediaBrowserProtocol;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class al1 {

    /* renamed from: a */
    public final Messenger f255a;

    public al1(Messenger messenger) {
        this.f255a = messenger;
    }

    /* renamed from: a */
    public final void m114a(String str, List list, Bundle bundle, Bundle bundle2) {
        ArrayList<? extends Parcelable> arrayList;
        Bundle bundle3 = new Bundle();
        bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
        bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
        bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
        if (list != null) {
            if (list instanceof ArrayList) {
                arrayList = (ArrayList) list;
            } else {
                arrayList = new ArrayList<>(list);
            }
            bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, arrayList);
        }
        m115b(3, bundle3);
    }

    /* renamed from: b */
    public final void m115b(int i, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 2;
        obtain.setData(bundle);
        this.f255a.send(obtain);
    }
}
