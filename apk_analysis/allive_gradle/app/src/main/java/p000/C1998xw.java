package p000;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.cursoradapter.widget.CursorAdapter;

/* renamed from: xw */
/* loaded from: classes.dex */
public final class C1998xw extends ContentObserver {

    /* renamed from: a */
    public final /* synthetic */ CursorAdapter f28748a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1998xw(CursorAdapter cursorAdapter) {
        super(new Handler());
        this.f28748a = cursorAdapter;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f28748a.onContentChanged();
    }
}
